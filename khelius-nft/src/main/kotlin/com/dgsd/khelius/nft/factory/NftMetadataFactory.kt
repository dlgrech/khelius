package com.dgsd.khelius.nft.factory

import com.dgsd.khelius.common.factory.TokenStandardFactory
import com.dgsd.khelius.nft.model.NftMetadata
import com.dgsd.khelius.nft.model.NftTrait
import com.dgsd.khelius.nft.response.NftMetadataResponseBody
import com.dgsd.khelius.nft.response.NftMetadataResponseBody.OffChainDataResponseBody
import com.dgsd.khelius.nft.response.NftMetadataResponseBody.OnChainDataResponseBody

/**
 * Maps a raw json response object into a higher-level model object exposed by the library
 */
internal object NftMetadataFactory {

  fun create(response: NftMetadataResponseBody): NftMetadata {
    return NftMetadata(
      mint = response.mint,
      onChainData = create(response.onChainData),
      offChainData = create(response.offChainData),
    )
  }

  private fun create(response: OnChainDataResponseBody): NftMetadata.OnChainData {
    return NftMetadata.OnChainData(
      key = response.key,
      mint = response.mint,
      updateAuthority = response.updateAuthority,
      tokenStandard = TokenStandardFactory.create(response.tokenStandard),
      primarySaleHappened = response.primarySaleHappened == true,
      isMutable = response.isMutable,
      editionNonce = response.editionNonce,
      collectionInfo = createCollectionInfo(response),
      name = response.data.name,
      imageUrl = response.data.image,
      symbol = response.data.symbol,
      creators = response.data.creators.orEmpty().map(::create),
      sellerFeeBasisPoints = response.data.sellerFeeBasisPoints,
    )
  }

  private fun createCollectionInfo(
    response: OnChainDataResponseBody
  ): NftMetadata.OnChainData.CollectionInfo? {
    return if (response.collection == null) {
      null
    } else {
      NftMetadata.OnChainData.CollectionInfo(
        key = response.collection.key,
        isVerified = response.collection.verified == true,
        size = response.collectionDetails?.size
      )
    }
  }

  private fun create(response: OffChainDataResponseBody): NftMetadata.OffChainData {
    return NftMetadata.OffChainData(
      name = response.name,
      description = response.description,
      symbol = response.symbol,
      imageUrl = response.image,
      sellerFeeBasisPoints = response.sellerFeeBasisPoints,
      traits = response.attributes.orEmpty().map(::create),
      category = response.properties?.category,
      creators = response.properties?.creators.orEmpty().map(::create),
      files = response.properties?.files.orEmpty().map(::create)
    )
  }

  private fun create(response: OffChainDataResponseBody.TraitResponseBody): NftTrait {
    return NftTrait(
      displayType = null,
      traitType = response.traitType,
      value = response.value
    )
  }

  private fun create(
    response: OffChainDataResponseBody.NftPropertiesResponseBody.NftFileInfoResponseBody
  ): NftMetadata.OffChainData.NftFile {
    return NftMetadata.OffChainData.NftFile(
      mimeType = response.type,
      url = response.uri
    )
  }

  private fun create(
    response: NftMetadataResponseBody.NftCreatorInfoResponseBody
  ): NftMetadata.NftCreator {
    return NftMetadata.NftCreator(
      address = response.address,
      share = response.share,
      isVerified = response.verified == true
    )
  }
}