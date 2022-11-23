package com.dgsd.khelius.transactions.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ParseTransactionRequestBody(
  @Json(name = "transactions") val transactions: List<String>,
)