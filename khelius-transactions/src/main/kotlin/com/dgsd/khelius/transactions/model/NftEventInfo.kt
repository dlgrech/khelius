package com.dgsd.khelius.transactions.model

/**
 * @see <a href="https://app.swaggerhub.com/apis-docs/Helius/HeliusAPI/1.0.0#/NFTEvent">Helius API Docs</a>
 */
data class NftEventInfo(
  val signature: String,
  val description: String?,
  val type: NftEventType,
  val source: TransactionSource,
  val amount: Long,
  val fee: Long,
  val feePayer: String,
  val slot: Long,
  val timestamp: Long,
  val saleType: SaleType,
  val buyer: String?,
  val seller: String?,
  val staker: String?,
  val nfts: List<Token>
) {

  /**
   * @see <a href="https://app.swaggerhub.com/apis-docs/Helius/HeliusAPI/1.0.0#/Token">Helius API Docs</a>
   */
  data class Token(
    val mint: String,
    val tokenStandard: TokenStandard,
  )
}