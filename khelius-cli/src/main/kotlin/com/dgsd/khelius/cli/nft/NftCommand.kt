package com.dgsd.khelius.cli.nft

import com.dgsd.khelius.cli.util.newOkHttpClient
import com.dgsd.khelius.nft.NftApi
import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.requireObject
import com.github.ajalt.clikt.core.subcommands

/**
 * Parent command for functionality related to the Helius NFT API
 */
class NftCommand private constructor() : CliktCommand(
  name = "nft",
  help = "Interact with the Helius NFT API"
) {

  private val apiKey by requireObject<String>()

  override fun run() {
    currentContext.obj = NftApi(apiKey, newOkHttpClient())
  }

  companion object {

    fun create(): NftCommand {
      return NftCommand().subcommands(
        GetNftEventsCommand(),
        GetNftsCommand(),
        GetNftMetadataCommand(),
      )
    }
  }
}