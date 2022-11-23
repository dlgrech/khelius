package com.dgsd.khelius.transactions.factory

import com.dgsd.khelius.transactions.model.NftEventType
import com.dgsd.khelius.transactions.response.NftEventTypeResponse

/**
 * Maps a raw json response object into a higher-level model object exposed by the library
 */
internal object NftEventTypeFactory {

  fun create(
    @NftEventTypeResponse response: String,
  ): NftEventType {
    return when (response) {
      NftEventTypeResponse.NFT_SALE -> NftEventType.NFT_SALE
      NftEventTypeResponse.NFT_LISTING -> NftEventType.NFT_LISTING
      NftEventTypeResponse.NFT_BID -> NftEventType.NFT_BID
      NftEventTypeResponse.NFT_MINT -> NftEventType.NFT_MINT
      NftEventTypeResponse.NFT_MINT_REJECTED -> NftEventType.NFT_MINT_REJECTED
      NftEventTypeResponse.NFT_BID_CANCELLED -> NftEventType.NFT_BID_CANCELLED
      NftEventTypeResponse.NFT_CANCEL_LISTING -> NftEventType.NFT_CANCEL_LISTING
      NftEventTypeResponse.NFT_AUCTION_STARTED -> NftEventType.NFT_AUCTION_STARTED
      NftEventTypeResponse.NFT_AUCTION_CREATED -> NftEventType.NFT_AUCTION_CREATED
      NftEventTypeResponse.NFT_PARTICIPATION_REWARD -> NftEventType.NFT_PARTICIPATION_REWARD
      NftEventTypeResponse.STAKE_TOKEN -> NftEventType.STAKE_TOKEN
      NftEventTypeResponse.UNSTAKE_TOKEN -> NftEventType.UNSTAKE_TOKEN
      NftEventTypeResponse.CLAIM_REWARDS -> NftEventType.CLAIM_REWARDS
      NftEventTypeResponse.BURN_NFT -> NftEventType.BURN_NFT
      else -> NftEventType.UNKNOWN
    }
  }
}