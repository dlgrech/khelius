package com.dgsd.khelius.cli.enhancedtransaction

import com.dgsd.khelius.cli.util.accountArgument
import com.dgsd.khelius.transactions.EnhancedTransactionsApi
import com.dgsd.khelius.transactions.model.TransactionSource
import com.dgsd.khelius.transactions.model.TransactionType
import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.requireObject
import kotlinx.coroutines.runBlocking

/**
 * Returns the enriched transaction history for a given address.
 */
internal class GetParsedTransactionHistoryCommand : CliktCommand(
  name = "history",
  help = "Returns the enriched transaction history for a given address."
) {

  private val enhancedTransactionsApi by requireObject<EnhancedTransactionsApi>()
  private val account by accountArgument()

  override fun run() = runBlocking {
    val transactions = enhancedTransactionsApi.getTransactionHistory(account)
    echo(transactions)
  }
}