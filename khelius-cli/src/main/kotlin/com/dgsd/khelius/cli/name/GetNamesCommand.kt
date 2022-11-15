package com.dgsd.khelius.cli.name

import com.dgsd.khelius.cli.util.accountArgument
import com.dgsd.khelius.name.NameApi
import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.requireObject
import kotlinx.coroutines.runBlocking

/**
 * Retrieve the Solana Name Service domain names for a specific account
 */
internal class GetNamesCommand : CliktCommand(
  name = "get",
  help = "Returns the Solana Name Service domains for a specific account."
) {

  private val nameApi by requireObject<NameApi>()
  private val account by accountArgument()

  override fun run() = runBlocking {
    val namesSummary = nameApi.getNames(account)
    echo(namesSummary)
  }
}