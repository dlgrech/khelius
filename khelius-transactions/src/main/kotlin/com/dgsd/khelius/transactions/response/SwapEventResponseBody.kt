package com.dgsd.khelius.transactions.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class SwapEventResponseBody(
  @Json(name = "tokenInputs") val tokenInputs: List<TokenAmountResponseBody>?,
  @Json(name = "tokenOutputs") val tokenOutputs: List<TokenAmountResponseBody>?,
  @Json(name = "tokenFees") val tokenFees: List<TokenAmountResponseBody>?,
  @Json(name = "nativeInput") val nativeInput: NativeAmountResponseBody?,
  @Json(name = "nativeOutput") val nativeOutput: NativeAmountResponseBody?,
  @Json(name = "nativeFees") val nativeFees: List<NativeAmountResponseBody>?,
  @Json(name = "innerSwaps") val innerSwaps: List<InnerSwapResponseBody>?,
) {
  @JsonClass(generateAdapter = true)
  internal data class InnerSwapResponseBody(
    @Json(name = "tokenInputs") val tokenInputs: List<EnrichedTransactionResponseBody.TokenTransferResponseBody>?,
    @Json(name = "tokenOutputs") val tokenOutputs: List<EnrichedTransactionResponseBody.TokenTransferResponseBody>?,
    @Json(name = "tokenFees") val tokenFees: List<EnrichedTransactionResponseBody.TokenTransferResponseBody>?,
    @Json(name = "nativeFees") val nativeFees: List<EnrichedTransactionResponseBody.NativeTransferResponseBody>?,
    @Json(name = "programInfo") val programInfo: ProgramInfoResponseBody?,
  ) {

    @JsonClass(generateAdapter = true)
    internal data class ProgramInfoResponseBody(
      @Json(name = "account") val account: String,
      @Json(name = "source") val source: String,
      @Json(name = "programName") val programName: String,
      @Json(name = "instructionName") val instructionName: String?,
    )
  }

  @JsonClass(generateAdapter = true)
  internal data class NativeAmountResponseBody(
    @Json(name = "account") val account: String,
    @Json(name = "amount") val amount: String,
  )
}