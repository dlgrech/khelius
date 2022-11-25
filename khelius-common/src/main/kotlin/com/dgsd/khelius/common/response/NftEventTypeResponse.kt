package com.dgsd.khelius.common.response

/**
 * The different types of transactions known to the Helius API
 *
 * @see <a href="https://app.swaggerhub.com/apis-docs/Helius/HeliusAPI/1.0.0#/TransactionType">Helius API Docs</a>
 */
@Target(
  AnnotationTarget.TYPE_PARAMETER,
  AnnotationTarget.VALUE_PARAMETER,
  AnnotationTarget.FUNCTION
)
@Retention(AnnotationRetention.SOURCE)
annotation class NftEventTypeResponse {
  companion object {
    const val NFT_SALE = "NFT_SALE"
    const val NFT_LISTING = "NFT_LISTING"
    const val NFT_BID = "NFT_BID"
    const val NFT_MINT = "NFT_MINT"
    const val NFT_MINT_REJECTED = "NFT_MINT_REJECTED"
    const val NFT_BID_CANCELLED = "NFT_BID_CANCELLED"
    const val NFT_CANCEL_LISTING = "NFT_CANCEL_LISTING"
    const val NFT_AUCTION_STARTED = "NFT_AUCTION_STARTED"
    const val NFT_AUCTION_CREATED = "NFT_AUCTION_CREATED"
    const val NFT_PARTICIPATION_REWARD = "NFT_PARTICIPATION_REWARD"
    const val STAKE_TOKEN = "STAKE_TOKEN"
    const val UNSTAKE_TOKEN = "UNSTAKE_TOKEN"
    const val CLAIM_REWARDS = "CLAIM_REWARDS"
    const val BURN_NFT = "BURN_NFT"
  }
}