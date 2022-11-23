package com.dgsd.khelius.transactions.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class EnrichedTransactionResponseBody(
  @Json(name = "signature") val signature: String,
  @Json(name = "description") val description: String?,
  @Json(name = "type") @TransactionTypeResponse val type: String,
  @Json(name = "source") @TransactionSourceResponse val source: String,
  @Json(name = "slot") val slot: Long,
  @Json(name = "timestamp") val timestamp: Long,
  @Json(name = "fee") val fee: Long,
  @Json(name = "feePayer") val feePayer: String,
  @Json(name = "nativeTransfers") val nativeTransfers: List<NativeTransferResponseBody>?,
  @Json(name = "tokenTransfers") val tokenTransfers: List<TokenTransferResponseBody>?,
  @Json(name = "accountData") val accountData: List<AccountDataResponseBody>?,
  @Json(name = "events") val events: EventResponseBody?,
) {

  @JsonClass(generateAdapter = true)
  internal data class NativeTransferResponseBody(
    @Json(name = "fromUserAccount") val fromUserAccount: String,
    @Json(name = "toUserAccount") val toUserAccount: String,
    @Json(name = "amount") val amount: Long,
  )

  @JsonClass(generateAdapter = true)
  internal data class TokenTransferResponseBody(
    @Json(name = "fromUserAccount") val fromUserAccount: String?,
    @Json(name = "toUserAccount") val toUserAccount: String,
    @Json(name = "fromTokenAccount") val fromTokenAccount: String?,
    @Json(name = "toTokenAccount") val toTokenAccount: String,
    @Json(name = "mint") val mint: String,
    @Json(name = "tokenAmount") val tokenAmount: Double,
    @Json(name = "tokenStandard") @TokenStandardResponse val tokenStandard: String?,
  )

  @JsonClass(generateAdapter = true)
  internal data class AccountDataResponseBody(
    @Json(name = "account") val account: String,
    @Json(name = "nativeBalanceChange") val nativeBalanceChange: Long,
    @Json(name = "tokenBalanceChanges") val tokenBalanceChanges: List<TokenAmountResponseBody>?,
  )

  @JsonClass(generateAdapter = true)
  internal data class EventResponseBody(
    @Json(name = "swap") val swap: SwapEventResponseBody?,
    @Json(name = "nft") val nft: NftEventResponseBody?,
  ) {

    @JsonClass(generateAdapter = true)
    internal data class NftEventResponseBody(
      @Json(name = "description") val description: String?,
      @Json(name = "type") @NftEventTypeResponse val type: String,
      @Json(name = "source") @TransactionSourceResponse val source: String,
      @Json(name = "amount") val amount: Long,
      @Json(name = "fee") val fee: Long,
      @Json(name = "feePayer") val feePayer: String,
      @Json(name = "signature") val signature: String,
      @Json(name = "slot") val slot: Long,
      @Json(name = "timestamp") val timestamp: Long,
      @Json(name = "saleType") @SaleTypeResponse val saleType: String,
      @Json(name = "buyer") val buyer: String?,
      @Json(name = "seller") val seller: String?,
      @Json(name = "staker") val staker: String?,
      @Json(name = "nfts") val nfts: List<NftTokenResponseBody>?,
    ) {

      @JsonClass(generateAdapter = true)
      internal data class NftTokenResponseBody(
        @Json(name = "mint") val mint: String,
        @Json(name = "tokenStandard") @TokenStandardResponse val tokenStandard: String,
      )
    }

    @JsonClass(generateAdapter = true)
    internal data class SwapEventResponseBody(
      @Json(name = "tokenInputs") val tokenInputs: List<TokenAmountResponseBody>?,
      @Json(name = "tokenOutputs") val tokenOutputs: List<TokenAmountResponseBody>?,
      @Json(name = "tokenFees") val tokenFees: List<TokenAmountResponseBody>?,
      @Json(name = "nativeInput") val nativeInput: NativeAmountResponseBody,
      @Json(name = "nativeOutput") val nativeOutput: NativeAmountResponseBody,
      @Json(name = "nativeFees") val nativeFees: List<NativeAmountResponseBody>?,
      @Json(name = "innerSwaps") val innerSwaps: List<InnerSwapResponseBody>?,
    ) {
      @JsonClass(generateAdapter = true)
      internal data class InnerSwapResponseBody(
        @Json(name = "tokenInputs") val tokenInputs: List<TokenTransferResponseBody>?,
        @Json(name = "tokenOutputs") val tokenOutputs: List<TokenTransferResponseBody>?,
        @Json(name = "tokenFees") val tokenFees: List<TokenTransferResponseBody>?,
        @Json(name = "nativeFees") val nativeFees: List<NativeTransferResponseBody>?,
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
  }
}