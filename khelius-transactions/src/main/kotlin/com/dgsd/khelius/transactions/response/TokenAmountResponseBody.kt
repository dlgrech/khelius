package com.dgsd.khelius.transactions.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class TokenAmountResponseBody(
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