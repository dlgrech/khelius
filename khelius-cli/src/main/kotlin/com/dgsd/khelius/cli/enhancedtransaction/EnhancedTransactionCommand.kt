package com.dgsd.khelius.cli.enhancedtransaction

import com.dgsd.khelius.cli.util.newOkHttpClient
import com.dgsd.khelius.transactions.EnhancedTransactionsApi
import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.requireObject
import com.github.ajalt.clikt.core.subcommands

/**
 * Parent command for functionality related to the Helius Enhanced Transaction API
 */
class EnhancedTransactionCommand private constructor() : CliktCommand(
  name = "enhanced-transactions",
  help = "Interact with the Helius Enhanced Transaction API"
) {

  private val apiKey by requireObject<String>()

  override fun run() {
    currentContext.obj = EnhancedTransactionsApi(apiKey, newOkHttpClient())
  }

  companion object {

    fun create(): EnhancedTransactionCommand {
      return EnhancedTransactionCommand().subcommands(
        GetParsedTransactionHistoryCommand(),
        ParseTransactionCommand(),
      )
    }
  }
}