package com.dgsd.khelius.common.factory

import com.dgsd.khelius.common.model.TransactionType
import com.dgsd.khelius.common.response.TransactionTypeResponse

/**
 * Maps a raw json response object into a higher-level model object exposed by the library
 */
object TransactionTypeFactory {

  @TransactionTypeResponse
  fun create(type: TransactionType): String {
    return when (type) {
      TransactionType.NFT_BID -> TransactionTypeResponse.NFT_BID
      TransactionType.NFT_BID_CANCELLED -> TransactionTypeResponse.NFT_BID_CANCELLED
      TransactionType.NFT_LISTING -> TransactionTypeResponse.NFT_LISTING
      TransactionType.NFT_CANCEL_LISTING -> TransactionTypeResponse.NFT_CANCEL_LISTING
      TransactionType.NFT_SALE -> TransactionTypeResponse.NFT_SALE
      TransactionType.NFT_MINT -> TransactionTypeResponse.NFT_MINT
      TransactionType.NFT_AUCTION_CREATED -> TransactionTypeResponse.NFT_AUCTION_CREATED
      TransactionType.NFT_AUCTION_UPDATED -> TransactionTypeResponse.NFT_AUCTION_UPDATED
      TransactionType.NFT_AUCTION_CANCELLED -> TransactionTypeResponse.NFT_AUCTION_CANCELLED
      TransactionType.NFT_PARTICIPATION_REWARD -> TransactionTypeResponse.NFT_PARTICIPATION_REWARD
      TransactionType.NFT_MINT_REJECTED -> TransactionTypeResponse.NFT_MINT_REJECTED
      TransactionType.CREATE_STORE -> TransactionTypeResponse.CREATE_STORE
      TransactionType.WHITELIST_CREATOR -> TransactionTypeResponse.WHITELIST_CREATOR
      TransactionType.ADD_TO_WHITELIST -> TransactionTypeResponse.ADD_TO_WHITELIST
      TransactionType.REMOVE_FROM_WHITELIST -> TransactionTypeResponse.REMOVE_FROM_WHITELIST
      TransactionType.AUCTION_MANAGER_CLAIM_BID -> TransactionTypeResponse.AUCTION_MANAGER_CLAIM_BID
      TransactionType.EMPTY_PAYMENT_ACCOUNT -> TransactionTypeResponse.EMPTY_PAYMENT_ACCOUNT
      TransactionType.UPDATE_PRIMARY_SALE_METADATA -> TransactionTypeResponse.UPDATE_PRIMARY_SALE_METADATA
      TransactionType.ADD_TOKEN_TO_VAULT -> TransactionTypeResponse.ADD_TOKEN_TO_VAULT
      TransactionType.ACTIVATE_VAULT -> TransactionTypeResponse.ACTIVATE_VAULT
      TransactionType.INIT_VAULT -> TransactionTypeResponse.INIT_VAULT
      TransactionType.INIT_BANK -> TransactionTypeResponse.INIT_BANK
      TransactionType.INIT_STAKE -> TransactionTypeResponse.INIT_STAKE
      TransactionType.MERGE_STAKE -> TransactionTypeResponse.MERGE_STAKE
      TransactionType.SPLIT_STAKE -> TransactionTypeResponse.SPLIT_STAKE
      TransactionType.SET_BANK_FLAGS -> TransactionTypeResponse.SET_BANK_FLAGS
      TransactionType.SET_VAULT_LOCK -> TransactionTypeResponse.SET_VAULT_LOCK
      TransactionType.UPDATE_VAULT_OWNER -> TransactionTypeResponse.UPDATE_VAULT_OWNER
      TransactionType.UPDATE_BANK_MANAGER -> TransactionTypeResponse.UPDATE_BANK_MANAGER
      TransactionType.RECORD_RARITY_POINTS -> TransactionTypeResponse.RECORD_RARITY_POINTS
      TransactionType.ADD_RARITIES_TO_BANK -> TransactionTypeResponse.ADD_RARITIES_TO_BANK
      TransactionType.INIT_FARM -> TransactionTypeResponse.INIT_FARM
      TransactionType.INIT_FARMER -> TransactionTypeResponse.INIT_FARMER
      TransactionType.REFRESH_FARMER -> TransactionTypeResponse.REFRESH_FARMER
      TransactionType.UPDATE_FARM -> TransactionTypeResponse.UPDATE_FARM
      TransactionType.AUTHORIZE_FUNDER -> TransactionTypeResponse.AUTHORIZE_FUNDER
      TransactionType.DEAUTHORIZE_FUNDER -> TransactionTypeResponse.DEAUTHORIZE_FUNDER
      TransactionType.FUND_REWARD -> TransactionTypeResponse.FUND_REWARD
      TransactionType.CANCEL_REWARD -> TransactionTypeResponse.CANCEL_REWARD
      TransactionType.LOCK_REWARD -> TransactionTypeResponse.LOCK_REWARD
      TransactionType.PAYOUT -> TransactionTypeResponse.PAYOUT
      TransactionType.VALIDATE_SAFETY_DEPOSIT_BOX_V2 -> TransactionTypeResponse.VALIDATE_SAFETY_DEPOSIT_BOX_V2
      TransactionType.SET_AUTHORITY -> TransactionTypeResponse.SET_AUTHORITY
      TransactionType.INIT_AUCTION_MANAGER_V2 -> TransactionTypeResponse.INIT_AUCTION_MANAGER_V2
      TransactionType.UPDATE_EXTERNAL_PRICE_ACCOUNT -> TransactionTypeResponse.UPDATE_EXTERNAL_PRICE_ACCOUNT
      TransactionType.AUCTION_HOUSE_CREATE -> TransactionTypeResponse.AUCTION_HOUSE_CREATE
      TransactionType.CLOSE_ESCROW_ACCOUNT -> TransactionTypeResponse.CLOSE_ESCROW_ACCOUNT
      TransactionType.WITHDRAW -> TransactionTypeResponse.WITHDRAW
      TransactionType.DEPOSIT -> TransactionTypeResponse.DEPOSIT
      TransactionType.TRANSFER -> TransactionTypeResponse.TRANSFER
      TransactionType.BURN -> TransactionTypeResponse.BURN
      TransactionType.BURN_NFT -> TransactionTypeResponse.BURN_NFT
      TransactionType.PLATFORM_FEE -> TransactionTypeResponse.PLATFORM_FEE
      TransactionType.LOAN -> TransactionTypeResponse.LOAN
      TransactionType.REPAY_LOAN -> TransactionTypeResponse.REPAY_LOAN
      TransactionType.ADD_TO_POOL -> TransactionTypeResponse.ADD_TO_POOL
      TransactionType.REMOVE_FROM_POOL -> TransactionTypeResponse.REMOVE_FROM_POOL
      TransactionType.CLOSE_POSITION -> TransactionTypeResponse.CLOSE_POSITION
      TransactionType.UNLABELED -> TransactionTypeResponse.UNLABELED
      TransactionType.CLOSE_ACCOUNT -> TransactionTypeResponse.CLOSE_ACCOUNT
      TransactionType.WITHDRAW_GEM -> TransactionTypeResponse.WITHDRAW_GEM
      TransactionType.DEPOSIT_GEM -> TransactionTypeResponse.DEPOSIT_GEM
      TransactionType.STAKE_TOKEN -> TransactionTypeResponse.STAKE_TOKEN
      TransactionType.UNSTAKE_TOKEN -> TransactionTypeResponse.UNSTAKE_TOKEN
      TransactionType.STAKE_SOL -> TransactionTypeResponse.STAKE_SOL
      TransactionType.UNSTAKE_SOL -> TransactionTypeResponse.UNSTAKE_SOL
      TransactionType.CLAIM_REWARDS -> TransactionTypeResponse.CLAIM_REWARDS
      TransactionType.BUY_SUBSCRIPTION -> TransactionTypeResponse.BUY_SUBSCRIPTION
      TransactionType.SWAP -> TransactionTypeResponse.SWAP
      TransactionType.INIT_SWAP -> TransactionTypeResponse.INIT_SWAP
      TransactionType.CANCEL_SWAP -> TransactionTypeResponse.CANCEL_SWAP
      TransactionType.REJECT_SWAP -> TransactionTypeResponse.REJECT_SWAP
      TransactionType.INITIALIZE_ACCOUNT -> TransactionTypeResponse.INITIALIZE_ACCOUNT
      TransactionType.TOKEN_MINT -> TransactionTypeResponse.TOKEN_MINT
      TransactionType.UNKNOWN -> TransactionTypeResponse.UNKNOWN
    }
  }

  fun create(@TransactionTypeResponse response: String): TransactionType {
    return when (response) {
      TransactionTypeResponse.NFT_BID -> TransactionType.NFT_BID
      TransactionTypeResponse.NFT_BID_CANCELLED -> TransactionType.NFT_BID_CANCELLED
      TransactionTypeResponse.NFT_LISTING -> TransactionType.NFT_LISTING
      TransactionTypeResponse.NFT_CANCEL_LISTING -> TransactionType.NFT_CANCEL_LISTING
      TransactionTypeResponse.NFT_SALE -> TransactionType.NFT_SALE
      TransactionTypeResponse.NFT_MINT -> TransactionType.NFT_MINT
      TransactionTypeResponse.NFT_AUCTION_CREATED -> TransactionType.NFT_AUCTION_CREATED
      TransactionTypeResponse.NFT_AUCTION_UPDATED -> TransactionType.NFT_AUCTION_UPDATED
      TransactionTypeResponse.NFT_AUCTION_CANCELLED -> TransactionType.NFT_AUCTION_CANCELLED
      TransactionTypeResponse.NFT_PARTICIPATION_REWARD -> TransactionType.NFT_PARTICIPATION_REWARD
      TransactionTypeResponse.NFT_MINT_REJECTED -> TransactionType.NFT_MINT_REJECTED
      TransactionTypeResponse.CREATE_STORE -> TransactionType.CREATE_STORE
      TransactionTypeResponse.WHITELIST_CREATOR -> TransactionType.WHITELIST_CREATOR
      TransactionTypeResponse.ADD_TO_WHITELIST -> TransactionType.ADD_TO_WHITELIST
      TransactionTypeResponse.REMOVE_FROM_WHITELIST -> TransactionType.REMOVE_FROM_WHITELIST
      TransactionTypeResponse.AUCTION_MANAGER_CLAIM_BID -> TransactionType.AUCTION_MANAGER_CLAIM_BID
      TransactionTypeResponse.EMPTY_PAYMENT_ACCOUNT -> TransactionType.EMPTY_PAYMENT_ACCOUNT
      TransactionTypeResponse.UPDATE_PRIMARY_SALE_METADATA -> TransactionType.UPDATE_PRIMARY_SALE_METADATA
      TransactionTypeResponse.ADD_TOKEN_TO_VAULT -> TransactionType.ADD_TOKEN_TO_VAULT
      TransactionTypeResponse.ACTIVATE_VAULT -> TransactionType.ACTIVATE_VAULT
      TransactionTypeResponse.INIT_VAULT -> TransactionType.INIT_VAULT
      TransactionTypeResponse.INIT_BANK -> TransactionType.INIT_BANK
      TransactionTypeResponse.INIT_STAKE -> TransactionType.INIT_STAKE
      TransactionTypeResponse.MERGE_STAKE -> TransactionType.MERGE_STAKE
      TransactionTypeResponse.SPLIT_STAKE -> TransactionType.SPLIT_STAKE
      TransactionTypeResponse.SET_BANK_FLAGS -> TransactionType.SET_BANK_FLAGS
      TransactionTypeResponse.SET_VAULT_LOCK -> TransactionType.SET_VAULT_LOCK
      TransactionTypeResponse.UPDATE_VAULT_OWNER -> TransactionType.UPDATE_VAULT_OWNER
      TransactionTypeResponse.UPDATE_BANK_MANAGER -> TransactionType.UPDATE_BANK_MANAGER
      TransactionTypeResponse.RECORD_RARITY_POINTS -> TransactionType.RECORD_RARITY_POINTS
      TransactionTypeResponse.ADD_RARITIES_TO_BANK -> TransactionType.ADD_RARITIES_TO_BANK
      TransactionTypeResponse.INIT_FARM -> TransactionType.INIT_FARM
      TransactionTypeResponse.INIT_FARMER -> TransactionType.INIT_FARMER
      TransactionTypeResponse.REFRESH_FARMER -> TransactionType.REFRESH_FARMER
      TransactionTypeResponse.UPDATE_FARM -> TransactionType.UPDATE_FARM
      TransactionTypeResponse.AUTHORIZE_FUNDER -> TransactionType.AUTHORIZE_FUNDER
      TransactionTypeResponse.DEAUTHORIZE_FUNDER -> TransactionType.DEAUTHORIZE_FUNDER
      TransactionTypeResponse.FUND_REWARD -> TransactionType.FUND_REWARD
      TransactionTypeResponse.CANCEL_REWARD -> TransactionType.CANCEL_REWARD
      TransactionTypeResponse.LOCK_REWARD -> TransactionType.LOCK_REWARD
      TransactionTypeResponse.PAYOUT -> TransactionType.PAYOUT
      TransactionTypeResponse.VALIDATE_SAFETY_DEPOSIT_BOX_V2 -> TransactionType.VALIDATE_SAFETY_DEPOSIT_BOX_V2
      TransactionTypeResponse.SET_AUTHORITY -> TransactionType.SET_AUTHORITY
      TransactionTypeResponse.INIT_AUCTION_MANAGER_V2 -> TransactionType.INIT_AUCTION_MANAGER_V2
      TransactionTypeResponse.UPDATE_EXTERNAL_PRICE_ACCOUNT -> TransactionType.UPDATE_EXTERNAL_PRICE_ACCOUNT
      TransactionTypeResponse.AUCTION_HOUSE_CREATE -> TransactionType.AUCTION_HOUSE_CREATE
      TransactionTypeResponse.CLOSE_ESCROW_ACCOUNT -> TransactionType.CLOSE_ESCROW_ACCOUNT
      TransactionTypeResponse.WITHDRAW -> TransactionType.WITHDRAW
      TransactionTypeResponse.DEPOSIT -> TransactionType.DEPOSIT
      TransactionTypeResponse.TRANSFER -> TransactionType.TRANSFER
      TransactionTypeResponse.BURN -> TransactionType.BURN
      TransactionTypeResponse.BURN_NFT -> TransactionType.BURN_NFT
      TransactionTypeResponse.PLATFORM_FEE -> TransactionType.PLATFORM_FEE
      TransactionTypeResponse.LOAN -> TransactionType.LOAN
      TransactionTypeResponse.REPAY_LOAN -> TransactionType.REPAY_LOAN
      TransactionTypeResponse.ADD_TO_POOL -> TransactionType.ADD_TO_POOL
      TransactionTypeResponse.REMOVE_FROM_POOL -> TransactionType.REMOVE_FROM_POOL
      TransactionTypeResponse.CLOSE_POSITION -> TransactionType.CLOSE_POSITION
      TransactionTypeResponse.UNLABELED -> TransactionType.UNLABELED
      TransactionTypeResponse.CLOSE_ACCOUNT -> TransactionType.CLOSE_ACCOUNT
      TransactionTypeResponse.WITHDRAW_GEM -> TransactionType.WITHDRAW_GEM
      TransactionTypeResponse.DEPOSIT_GEM -> TransactionType.DEPOSIT_GEM
      TransactionTypeResponse.STAKE_TOKEN -> TransactionType.STAKE_TOKEN
      TransactionTypeResponse.UNSTAKE_TOKEN -> TransactionType.UNSTAKE_TOKEN
      TransactionTypeResponse.STAKE_SOL -> TransactionType.STAKE_SOL
      TransactionTypeResponse.UNSTAKE_SOL -> TransactionType.UNSTAKE_SOL
      TransactionTypeResponse.CLAIM_REWARDS -> TransactionType.CLAIM_REWARDS
      TransactionTypeResponse.BUY_SUBSCRIPTION -> TransactionType.BUY_SUBSCRIPTION
      TransactionTypeResponse.SWAP -> TransactionType.SWAP
      TransactionTypeResponse.INIT_SWAP -> TransactionType.INIT_SWAP
      TransactionTypeResponse.CANCEL_SWAP -> TransactionType.CANCEL_SWAP
      TransactionTypeResponse.REJECT_SWAP -> TransactionType.REJECT_SWAP
      TransactionTypeResponse.INITIALIZE_ACCOUNT -> TransactionType.INITIALIZE_ACCOUNT
      TransactionTypeResponse.TOKEN_MINT -> TransactionType.TOKEN_MINT
      else -> TransactionType.UNKNOWN
    }
  }
}