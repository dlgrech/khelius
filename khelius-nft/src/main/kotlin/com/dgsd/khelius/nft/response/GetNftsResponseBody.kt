package com.dgsd.khelius.nft.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class GetNftsResponseBody(
  @Json(name = "numberOfPages") val numberOfPages: Int,
  @Json(name = "nfts") val nfts: List<NftResponseBody>?,
)