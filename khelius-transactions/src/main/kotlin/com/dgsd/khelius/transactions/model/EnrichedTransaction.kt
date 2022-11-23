package com.dgsd.khelius.transactions.model

/**
 * @see <a href="https://app.swaggerhub.com/apis-docs/Helius/HeliusAPI/1.0.0#/EnrichedTransaction">Helius API Docs</a>
 */
data class EnrichedTransaction(
  val signature: String,

  /**
   * Human readable interpretation of the transaction
   */
  val description: String?,
  val type: TransactionType,
  val source: TransactionSource,
  val fee: Long,
  val feePayer: String,
  val timestamp: Long,
  val slot: Long,
  val nativeTransfers: List<NativeTransfer>,
  val tokenTransfers: List<TokenTransfer>,
) {

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
}