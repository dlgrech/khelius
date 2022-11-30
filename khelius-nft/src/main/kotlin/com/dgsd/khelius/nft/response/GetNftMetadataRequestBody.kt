package com.dgsd.khelius.nft.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class GetNftMetadataRequestBody(
  @Json(name = "mintAccounts") val mintAccounts: List<String>,
)