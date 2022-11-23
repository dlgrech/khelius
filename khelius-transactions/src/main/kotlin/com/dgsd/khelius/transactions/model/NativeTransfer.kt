package com.dgsd.khelius.transactions.model

/**
 * @see <a href="https://app.swaggerhub.com/apis-docs/Helius/HeliusAPI/1.0.0#/NativeTransfer">Helius API Docs</a>
 */
data class NativeTransfer(

  /**
   * The user account the sol is sent from.
   */
  val fromUserAccount: String,

  /**
   * The user account the sol is sent to.
   */
  val toUserAccount: String,

  /**
   * The amount of sol sent (in lamports).
   */
  val amount: Long,
)