package com.dgsd.khelius.transactions.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

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