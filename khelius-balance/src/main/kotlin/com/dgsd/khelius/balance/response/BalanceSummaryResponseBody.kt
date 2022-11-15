package com.dgsd.khelius.balance.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class BalanceSummaryResponseBody(
  @Json(name = "nativeBalance") val nativeBalance: Long,
  @Json(name = "tokens") val tokens: List<TokenBalanceResponseBody>?
)