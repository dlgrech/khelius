package com.dgsd.khelius.cli.nft

import com.dgsd.khelius.cli.util.nftsArgument
import com.dgsd.khelius.nft.NftApi
import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.requireObject
import kotlinx.coroutines.runBlocking

/**
 * Returns metadata for a list of given NFT mint addresses.
 */
internal class GetNftMetadataCommand : CliktCommand(
  name = "metadata",
  help = "Returns metadata for a list of given NFT mint addresses."
) {

  private val nftApi by requireObject<NftApi>()
  private val nfts by nftsArgument()

  override fun run() = runBlocking {
    val metadata = nftApi.getNftMetadata(nfts)
    echo(metadata)
  }
}