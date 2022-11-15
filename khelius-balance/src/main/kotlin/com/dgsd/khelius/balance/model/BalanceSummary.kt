package com.dgsd.khelius.balance.model

/**
 * Represents the native balance and the token balances for a given account.
 */
data class BalanceSummary(
  /**
   * The base-58 public key hash for the account this balance summary represents
   */
  val account: String,

  /**
   * The SOL balance (in Lamports) for the account
   */
  val nativeBalance: Long,

  /**
   * The balance of each token
   */
  val tokens: List<TokenBalance>,
)