package com.dgsd.khelius.transactions.model

/**
 * @see <a href="https://app.swaggerhub.com/apis-docs/Helius/HeliusAPI/1.0.0#/TokenBalanceChange">Helius API Docs</a>
 */
data class TokenAmount(
  val userAccount: String,
  val tokenAccount: String,
  val tokenMint: String,
  val tokenAmount: String,
  val tokenDecimals: Int,
)