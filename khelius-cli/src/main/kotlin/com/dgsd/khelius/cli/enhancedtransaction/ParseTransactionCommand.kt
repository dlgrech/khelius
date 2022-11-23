package com.dgsd.khelius.cli.enhancedtransaction

import com.dgsd.khelius.cli.util.transactionsArgument
import com.dgsd.khelius.transactions.EnhancedTransactionsApi
import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.requireObject
import kotlinx.coroutines.runBlocking

/**
 * Returns an enriched, human-readable transactions of the given transaction .
 */
internal class ParseTransactionCommand : CliktCommand(
  name = "parse",
  help = "Returns an enriched, human-readable transactions of the given transaction"
) {

  private val enhancedTransactionsApi by requireObject<EnhancedTransactionsApi>()
  private val transactions by transactionsArgument()

  override fun run() = runBlocking {
    val transactions = enhancedTransactionsApi.parseTransactions(transactions)
    echo(transactions)
  }
}