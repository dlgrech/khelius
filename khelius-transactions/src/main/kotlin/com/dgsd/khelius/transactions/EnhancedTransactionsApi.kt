package com.dgsd.khelius.transactions

import com.dgsd.khelius.core.network.HeliusApi
import com.dgsd.khelius.transactions.model.Commitment
import com.dgsd.khelius.transactions.model.EnrichedTransaction
import com.dgsd.khelius.transactions.model.TransactionSource
import com.dgsd.khelius.transactions.model.TransactionType
import okhttp3.OkHttpClient

/**
 * Creates a default [EnhancedTransactionsApi] instance
 */
fun EnhancedTransactionsApi(
  apiKey: String,
  okHttpClient: OkHttpClient = OkHttpClient()
): EnhancedTransactionsApi {
  val heliusApi = HeliusApi(apiKey, okHttpClient)
  return EnhancedTransactionsApiImpl(heliusApi)
}

/**
 * Wrapper for the Helius Enhanced Transactions API
 *
 * @see <a href="https://docs.helius.xyz/api-reference/enhanced-transactions-api">Helius API Docs</a>
 */
interface EnhancedTransactionsApi {

  /**
   * Returns an enriched transaction history for a given address
   */
  suspend fun getTransactionHistory(
    account: String,
    before: String? = null,
    until: String? = null,
    transactionSource: TransactionSource? = null,
    transactionType: TransactionType? = null,
    commitment: Commitment = Commitment.FINALIZED,
  ): List<EnrichedTransaction>

  /**
   * Returns an list of enriched, human-readable transactions of the given transaction signatures.
   */
  suspend fun parseTransactions(
    transactions: List<String>,
    commitment: Commitment = Commitment.FINALIZED,
  ): List<EnrichedTransaction>
}