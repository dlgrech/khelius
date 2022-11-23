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
  val accountData: List<AccountData>,
  val swapEventInfo: SwapEventInfo?,
) {

  data class AccountData(
    val account: String,
    val nativeBalanceChange: Long,
    val tokenBalanceChanges: List<TokenAmount>
  )
}