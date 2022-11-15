package com.dgsd.khelius.cli.util

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.arguments.ArgumentDelegate
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.arguments.transformAll

fun CliktCommand.apiKeyArgument(): ArgumentDelegate<String> {
  return argument(
    name = "API_KEY",
    help = "Helius API Key"
  ).transformAll {
    it.single()
  }
}

fun CliktCommand.accountArgument(): ArgumentDelegate<String> {
  return argument(
    name = "ACCOUNT",
    help = "Base58 hash of account"
  ).transformAll {
    it.single()
  }
}