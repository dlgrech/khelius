package com.dgsd.khelius.cli.balance

import com.dgsd.khelius.balance.BalanceApi
import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.requireObject
import com.github.ajalt.clikt.core.subcommands

/**
 * Parent command for functionality related to the Helius Balance API
 */
class BalanceCommand private constructor() : CliktCommand(
  name = "balance",
  help = "Interact with the Helius Balance API"
) {

  private val apiKey by requireObject<String>()

  override fun run() {
    currentContext.obj = BalanceApi(apiKey)
  }

  companion object {

    fun create(): BalanceCommand {
      return BalanceCommand().subcommands(
        GetBalanceCommand()
      )
    }
  }
}