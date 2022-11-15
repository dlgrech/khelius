package com.dgsd.khelius.balance.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class TokenBalanceResponseBody(
  @Json(name = "tokenAccount") val tokenAccount: String,
  @Json(name = "mint") val mint: String,
  @Json(name = "amount") val amount: Long,
  @Json(name = "decimals") val decimals: Int,
)