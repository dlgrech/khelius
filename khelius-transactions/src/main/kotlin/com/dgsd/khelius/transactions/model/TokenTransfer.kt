package com.dgsd.khelius.transactions.model

data class TokenTransfer(
  /**
   * The user account the sol is sent from.
   */
  val fromUserAccount: String?,

  /**
   * The user account the sol is sent to.
   */
  val toUserAccount: String,

  /**
   * The token account the tokens are sent from.
   */
  val fromTokenAccount: String?,

  /**
   * The token account the tokens are sent to.
   */
  val toTokenAccount: String,

  /**
   * The mint account of the token.
   */
  val mint: String,

  /**
   * The number of tokens sent.
   */
  val amount: Double,

  /**
   * The standard used for this token
   */
  val tokenStandard: TokenStandard?,
)