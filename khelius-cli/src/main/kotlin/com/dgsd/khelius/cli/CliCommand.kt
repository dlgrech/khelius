package com.dgsd.khelius.cli

import com.dgsd.khelius.cli.balance.BalanceCommand
import com.dgsd.khelius.cli.enhancedtransaction.EnhancedTransactionCommand
import com.dgsd.khelius.cli.name.NameCommand
import com.dgsd.khelius.cli.nft.NftCommand
import com.dgsd.khelius.cli.util.apiKeyArgument
import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.subcommands

/**
 * Parent command the kHelius CLI app
 */
class CliCommand private constructor(): CliktCommand(
  name = "khelius",
  help = "Interact with the Khelius library"
) {

  private val apiKey by apiKeyArgument()

  override fun run() {
    currentContext.obj = apiKey
  }

  companion object {

    fun create(): CliCommand {
      return CliCommand().subcommands(
        BalanceCommand.create(),
        EnhancedTransactionCommand.create(),
        NameCommand.create(),
        NftCommand.create(),
      )
    }
  }
}