package com.dgsd.khelius.nft.factory

import com.dgsd.khelius.nft.model.Nft
import com.dgsd.khelius.nft.model.NftListSummary
import com.dgsd.khelius.nft.model.NftTrait
import com.dgsd.khelius.nft.response.GetNftsResponseBody
import com.dgsd.khelius.nft.response.NftResponseBody

private const val HELIUS_DEFAULT_COLLECTION_NAME = "Unknown"

/**
 * Maps a raw json response object into a higher-level model object exposed by the library
 */
internal object NftFactory {

  fun create(response: GetNftsResponseBody): NftListSummary {
    return NftListSummary(
      numberOfPages = response.numberOfPages,
      nfts = response.nfts.orEmpty().map(::create)
    )
  }

  private fun create(response: NftResponseBody): Nft {
    return Nft(
      name = response.name,
      tokenAddress = response.tokenAddress,
      collectionAddress = response.collectionAddress,
      collectionName = response.collectionName?.takeIf { it != HELIUS_DEFAULT_COLLECTION_NAME },
      imageUrl = response.imageUrl,
      traits = response.traits.orEmpty().map(::create),
    )
  }

  private fun create(response: NftResponseBody.Trait): NftTrait {
    return NftTrait(
      displayType = response.displayType,
      traitType = response.traitType,
      value = response.value
    )
  }
}