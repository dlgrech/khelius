package com.dgsd.khelius.name.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class GetNamesResponseBody(
  @Json(name = "domainNames") val domains: List<String>?
)