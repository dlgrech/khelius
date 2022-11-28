package com.dgsd.khelius.cli.nft

import com.dgsd.khelius.cli.util.accountArgument
import com.dgsd.khelius.nft.NftApi
import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.requireObject
import kotlinx.coroutines.runBlocking

/**
 * Returns all the NFTs that the given address currently holds.
 */
internal class GetNftsCommand : CliktCommand(
  name = "get",
  help = "Returns all the NFTs that the given address currently holds."
) {

  private val nftApi by requireObject<NftApi>()
  private val account by accountArgument()

  override fun run() = runBlocking {
    val nfts = nftApi.getNfts(account)
    echo(nfts)
  }
}