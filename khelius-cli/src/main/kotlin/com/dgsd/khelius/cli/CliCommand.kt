package com.dgsd.khelius.cli

import com.dgsd.khelius.cli.util.apiKeyArgument
import com.github.ajalt.clikt.core.CliktCommand

/**
 * Parent command the kHelius CLI app
 */
class CliCommand : CliktCommand(
  name = "khelius",
  help = "Interact with the Khelius library"
) {

  private val apiKey by apiKeyArgument()

  override fun run() {
    currentContext.obj = apiKey
  }
}