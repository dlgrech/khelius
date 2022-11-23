package com.dgsd.khelius.transactions.model

/**
 * @see <a href="https://app.swaggerhub.com/apis-docs/Helius/HeliusAPI/1.0.0#/NFTEventType">Helius API Docs</a>
 */
enum class NftEventType {
  NFT_SALE,
  NFT_LISTING,
  NFT_BID,
  NFT_MINT,
  NFT_MINT_REJECTED,
  NFT_BID_CANCELLED,
  NFT_CANCEL_LISTING,
  NFT_AUCTION_STARTED,
  NFT_AUCTION_CREATED,
  NFT_PARTICIPATION_REWARD,
  STAKE_TOKEN,
  UNSTAKE_TOKEN,
  CLAIM_REWARDS,
  BURN_NFT,
  UNKNOWN,
}