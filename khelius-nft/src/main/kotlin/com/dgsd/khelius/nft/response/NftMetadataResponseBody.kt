package com.dgsd.khelius.nft.response

import com.dgsd.khelius.common.response.TokenStandardResponse
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class NftMetadataResponseBody(
  @Json(name = "mint") val mint: String,
  @Json(name = "onChainData") val onChainData: OnChainDataResponseBody,
  @Json(name = "offChainData") val offChainData: OffChainDataResponseBody,
) {

  @JsonClass(generateAdapter = true)
  internal data class OnChainDataResponseBody(
    @Json(name = "key") val key: String,
    @Json(name = "mint") val mint: String,
    @Json(name = "updateAuthority") val updateAuthority: String,
    @Json(name = "tokenStandard") @TokenStandardResponse val tokenStandard: String,
    @Json(name = "primarySaleHappened") val primarySaleHappened: Boolean?,
    @Json(name = "isMutable") val isMutable: Boolean,
    @Json(name = "editionNonce") val editionNonce: Int,
    @Json(name = "collection") val collection: CollectionResponseBody?,
    @Json(name = "collectionDetails") val collectionDetails: CollectionDetailsResponseBody?,
    @Json(name = "data") val data: DataResponseBody,
  ) {

    @JsonClass(generateAdapter = true)
    internal data class CollectionResponseBody(
      @Json(name = "key") val key: String,
      @Json(name = "verified") val verified: Boolean?,
    )

    @JsonClass(generateAdapter = true)
    internal data class CollectionDetailsResponseBody(
      @Json(name = "size") val size: Int?,
    )

    @JsonClass(generateAdapter = true)
    internal data class DataResponseBody(
      @Json(name = "creators") val creators: List<NftCreatorInfoResponseBody>?,
      @Json(name = "name") val name: String,
      @Json(name = "sellerFeeBasisPoints") val sellerFeeBasisPoints: Int,
      @Json(name = "symbol") val symbol: String,
      @Json(name = "uri") val image: String?,
    )
  }

  @JsonClass(generateAdapter = true)
  internal data class OffChainDataResponseBody(
    @Json(name = "name") val name: String,
    @Json(name = "description") val description: String?,
    @Json(name = "symbol") val symbol: String,
    @Json(name = "image") val image: String?,
    @Json(name = "sellerFeeBasisPoints") val sellerFeeBasisPoints: Int,
    @Json(name = "properties") val properties: NftPropertiesResponseBody?,
    @Json(name = "attributes") val attributes: List<TraitResponseBody>?,
  ) {

    @JsonClass(generateAdapter = true)
    internal data class NftPropertiesResponseBody(
      @Json(name = "category") val category: String?,
      @Json(name = "creators") val creators: List<NftCreatorInfoResponseBody>?,
      @Json(name = "files") val files: List<NftFileInfoResponseBody>?,
    ) {
      @JsonClass(generateAdapter = true)
      internal data class NftFileInfoResponseBody(
        @Json(name = "type") val type: String,
        @Json(name = "uri") val uri: String,
      )
    }

    @JsonClass(generateAdapter = true)
    internal data class TraitResponseBody(
      @Json(name = "traitType") val traitType: String,
      @Json(name = "value") val value: String,
    )
  }

  @JsonClass(generateAdapter = true)
  internal data class NftCreatorInfoResponseBody(
    @Json(name = "address") val address: String,
    @Json(name = "share") val share: String,
    @Json(name = "verified") val verified: Boolean?,
  )
}