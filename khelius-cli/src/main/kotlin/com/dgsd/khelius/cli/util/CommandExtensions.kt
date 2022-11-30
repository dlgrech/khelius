package com.dgsd.khelius.cli.util

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.arguments.ArgumentDelegate
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.arguments.multiple
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

fun CliktCommand.nftsArgument(): ArgumentDelegate<List<String>> {
  return argument(
    name = "NFTS",
    help = "List of NFTs Base58 hashes"
  ).multiple(required = true)
}

fun CliktCommand.transactionsArgument(): ArgumentDelegate<List<String>> {
  return argument(
    name = "TRANSACTION_SIGNATURES",
    help = "List of transaction signatures"
  ).multiple(required = true)
}