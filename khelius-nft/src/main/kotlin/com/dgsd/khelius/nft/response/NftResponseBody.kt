package com.dgsd.khelius.nft.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class NftResponseBody(
  @Json(name = "name") val name: String,
  @Json(name = "tokenAddress") val tokenAddress: String,
  @Json(name = "collectionName") val collectionName: String?,
  @Json(name = "collectionAddress") val collectionAddress: String,
  @Json(name = "imageUrl") val imageUrl: String?,
  @Json(name = "traits") val traits: List<Trait>?,
) {

  @JsonClass(generateAdapter = true)
  internal data class Trait(
    @Json(name = "display_type") val displayType: String?,
    @Json(name = "trait_type") val traitType: String,
    @Json(name = "value") val value: String,
  )
}