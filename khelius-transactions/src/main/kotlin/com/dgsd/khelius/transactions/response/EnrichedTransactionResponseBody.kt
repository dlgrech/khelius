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
    @Json(name = "tokenStandard") @TokenStandardResponse val tokenStandard: String,
  )

  @JsonClass(generateAdapter = true)
  internal data class AccountDataResponseBody(
    @Json(name = "account") val account: String,
    @Json(name = "nativeBalanceChange") val nativeBalanceChange: Long,
    @Json(name = "tokenBalanceChanges") val tokenBalanceChanges: List<TokenBalanceChangesResponseBody>?,
  ) {
    @JsonClass(generateAdapter = true)
    internal data class TokenBalanceChangesResponseBody(
      @Json(name = "userAccount") val userAccount: String,
      @Json(name = "tokenAccount") val tokenAccount: String,
      @Json(name = "mint") val mint: String,
      @Json(name = "rawTokenAmount") val rawTokenAmount: RawTokenAmountResponseBody,
    ) {

      @JsonClass(generateAdapter = true)
      internal data class RawTokenAmountResponseBody(
        @Json(name = "tokenAmount") val tokenAmount: String,
        @Json(name = "decimals") val decimals: Int
      )
    }
  }
}