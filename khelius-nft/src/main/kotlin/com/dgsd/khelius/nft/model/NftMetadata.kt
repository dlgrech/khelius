package com.dgsd.khelius.nft.model

import com.dgsd.khelius.common.model.TokenStandard

data class NftMetadata(
  val mint: String,
  val onChainData: OnChainData,
  val offChainData: OffChainData,
) {

  data class OnChainData(
    val key: String,
    val mint: String,
    val name: String,
    val imageUrl: String?,
    val symbol: String,
    val creators: List<NftCreator>,
    val sellerFeeBasisPoints: Int,
    val updateAuthority: String,
    val tokenStandard: TokenStandard,
    val primarySaleHappened: Boolean,
    val isMutable: Boolean,
    val editionNonce: Int,
    val collectionInfo: CollectionInfo?,
  ) {

    data class CollectionInfo(
      val key: String,
      val isVerified: Boolean,
      val size: Int?,
    )
  }

  data class OffChainData(
    val name: String,
    val description: String?,
    val symbol: String,
    val imageUrl: String?,
    val sellerFeeBasisPoints: Int,
    val traits: List<NftTrait>,
    val category: String?,
    val creators: List<NftCreator>,
    val files: List<NftFile>,
  ) {

    data class NftFile(
      val mimeType: String,
      val url: String,
    )
  }

  data class NftCreator(
    val address: String,
    val share: String?,
    val isVerified: Boolean,
  )
}