package com.dgsd.khelius.cli

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
        CliCommand.create().main(arguments)
      } catch (ex: Throwable) {
        ex.printStackTrace()
      }
    }
  }

  exitProcess(0)
}