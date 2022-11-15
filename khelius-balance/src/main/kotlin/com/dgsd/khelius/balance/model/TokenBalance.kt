package com.dgsd.khelius.balance.model

/**
 * Represents the balance of a specific token type for an account
 */
data class TokenBalance(

  /**
   * The account for this token type under a specific address
   */
  val account: String,

  /**
   * The mint account for the token
   */
  val mint: String,

  /**
   * The balance of the token
   */
  val balance: Long,

  /**
   * Number of decimals configured for token's mint
   */
  val decimals: Int
)