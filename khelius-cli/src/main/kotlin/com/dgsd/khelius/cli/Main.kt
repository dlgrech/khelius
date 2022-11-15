package com.dgsd.khelius.cli

import com.dgsd.khelius.cli.balance.BalanceCommand
import com.github.ajalt.clikt.core.subcommands
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope
import kotlin.system.exitProcess

/**
 * Entrypoint for the Helius CLI application
 */
fun main(arguments: Array<String>) {
  runBlocking {
    supervisorScope {
      try {
        CliCommand()
          .subcommands(
            BalanceCommand.create(),
          )
          .main(arguments)
      } catch (ex: Throwable) {
        ex.printStackTrace()
      }
    }
  }

  exitProcess(0)
}