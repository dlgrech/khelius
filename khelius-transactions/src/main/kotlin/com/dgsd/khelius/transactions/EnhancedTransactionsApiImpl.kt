package com.dgsd.khelius.transactions

import com.dgsd.khelius.core.network.HeliusApi
import com.dgsd.khelius.transactions.factory.CommitmentFactory
import com.dgsd.khelius.transactions.factory.EnrichedTransactionFactory
import com.dgsd.khelius.transactions.factory.TransactionSourceFactory
import com.dgsd.khelius.transactions.factory.TransactionTypeFactory
import com.dgsd.khelius.transactions.model.Commitment
import com.dgsd.khelius.transactions.model.EnrichedTransaction
import com.dgsd.khelius.transactions.model.TransactionSource
import com.dgsd.khelius.transactions.model.TransactionType
import com.dgsd.khelius.transactions.response.EnrichedTransactionResponseBody
import com.dgsd.khelius.transactions.response.ParseTransactionRequestBody
import com.dgsd.khelius.transactions.util.filterNonNullValues

private const val TRANSACTION_HISTORY_PATH_TEMPLATE = "/v0/addresses/%s/transactions"
private const val PARSE_TRANSACTIONS_PATH = "/v0/transactions"
private const val QUERY_PARAM_BEFORE = "before"
private const val QUERY_PARAM_UNTIL = "until"
private const val QUERY_PARAM_COMMITMENT = "commitment"
private const val QUERY_PARAM_SOURCE = "source"
private const val QUERY_PARAM_TYPE = "type"

/**
 * Default implementation of the [EnhancedTransactionsApi] interface
 */
class EnhancedTransactionsApiImpl(
  private val heliusApi: HeliusApi
) : EnhancedTransactionsApi {

  override suspend fun getTransactionHistory(
    account: String,
    before: String?,
    until: String?,
    transactionSource: TransactionSource?,
    transactionType: TransactionType?,
    commitment: Commitment
  ): List<EnrichedTransaction> {
    val requestPath = String.format(TRANSACTION_HISTORY_PATH_TEMPLATE, account)

    val queryParams = mapOf(
      QUERY_PARAM_BEFORE to before,
      QUERY_PARAM_UNTIL to until,
      QUERY_PARAM_COMMITMENT to CommitmentFactory.create(commitment),
      QUERY_PARAM_TYPE to transactionType?.let { TransactionTypeFactory.create(it) },
      QUERY_PARAM_SOURCE to transactionSource?.let { TransactionSourceFactory.create(it) },
    ).filterNonNullValues()

    val response = heliusApi.getList(
      requestPath,
      EnrichedTransactionResponseBody::class.java,
      queryParams
    )

    return response.map { EnrichedTransactionFactory.create(it) }
  }

  override suspend fun parseTransactions(
    transactions: List<String>,
    commitment: Commitment
  ): List<EnrichedTransaction> {
    val response = heliusApi.postList(
      requestPath = PARSE_TRANSACTIONS_PATH,
      requestBody = ParseTransactionRequestBody(transactions),
      responseClass = EnrichedTransactionResponseBody::class.java,
      queryParams = mapOf(QUERY_PARAM_COMMITMENT to CommitmentFactory.create(commitment))
    )

    return response.map { EnrichedTransactionFactory.create(it) }
  }
}