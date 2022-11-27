package com.dgsd.khelius.cli.nft

import com.dgsd.khelius.cli.util.accountArgument
import com.dgsd.khelius.nft.NftApi
import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.requireObject
import kotlinx.coroutines.runBlocking

/**
 * Returns all NFT events for a specific account.
 */
internal class GetNftEventsCommand : CliktCommand(
  name = "events",
  help = "Returns all NFT events for a specific account."
) {

  private val nftApi by requireObject<NftApi>()
  private val account by accountArgument()

  override fun run() = runBlocking {
    val events = nftApi.getEvents(account)
    echo(events)
  }
}