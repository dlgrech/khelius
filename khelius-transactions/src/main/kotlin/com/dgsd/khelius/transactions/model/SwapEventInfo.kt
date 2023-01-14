package com.dgsd.khelius.transactions.model

/**
 * @see <a href="https://app.swaggerhub.com/apis-docs/Helius/HeliusAPI/1.0.0#/SwapEvent">Helius API Docs</a>
 */
data class SwapEventInfo(
  val tokenInputs: List<TokenAmount>,
  val tokenOutputs: List<TokenAmount>,
  val tokenFees: List<TokenAmount>,
  val nativeInput: NativeAmount?,
  val nativeOutput: NativeAmount?,
  val nativeFees: List<NativeAmount>,
  val innerSwaps: List<InnerSwap>,
) {

  data class NativeAmount(
    val account: String,
    val amount: String
  )

  data class InnerSwap(
    val tokenInputs: List<TokenTransfer>,
    val tokenOutputs: List<TokenTransfer>,
    val tokenFees: List<TokenTransfer>,
    val nativeFees: List<NativeTransfer>,
    val programInfo: ProgramInfo?,
  )
}