package com.dgsd.khelius.nft

import com.dgsd.khelius.common.factory.NftEventFactory
import com.dgsd.khelius.common.model.NftEventInfo
import com.dgsd.khelius.common.response.NftEventResponseBody
import com.dgsd.khelius.core.network.HeliusApi
import com.dgsd.khelius.nft.factory.NftFactory
import com.dgsd.khelius.nft.factory.NftMetadataFactory
import com.dgsd.khelius.nft.model.NftListSummary
import com.dgsd.khelius.nft.model.NftMetadata
import com.dgsd.khelius.nft.response.GetNftMetadataRequestBody
import com.dgsd.khelius.nft.response.GetNftsResponseBody
import com.dgsd.khelius.nft.response.NftMetadataResponseBody

private const val NFT_EVENTS_REQUEST_PATH_TEMPLATE = "/v0/addresses/%s/nft-events"
private const val NFT_REQUEST_PATH_TEMPLATE = "/v0/addresses/%s/nfts"
private const val NFT_METADATA_PATH = "/v0/tokens/metadata"
private const val QUERY_PARAM_PAGE_NUMBER = "page-number"

/**
 * Default implementation of the [NftApi] interface
 */
internal class NftApiImpl(
  private val heliusApi: HeliusApi,
) : NftApi {

  override suspend fun getEvents(account: String): List<NftEventInfo> {
    val requestPath = String.format(NFT_EVENTS_REQUEST_PATH_TEMPLATE, account)

    val response = heliusApi.getList(requestPath, NftEventResponseBody::class.java)

    return response.map(NftEventFactory::create)
  }

  override suspend fun getNfts(account: String, pageNumber: Int?): NftListSummary {
    val requestPath = String.format(NFT_REQUEST_PATH_TEMPLATE, account)
    val queryParams = if (pageNumber == null) {
      emptyMap()
    } else {
      mapOf(QUERY_PARAM_PAGE_NUMBER to pageNumber.toString())
    }

    val response = heliusApi.get(requestPath, GetNftsResponseBody::class.java, queryParams)

    return NftFactory.create(response)
  }

  override suspend fun getNftMetadata(nftAddresses: List<String>): List<NftMetadata> {
    val response = heliusApi.postList(
      requestPath = NFT_METADATA_PATH,
      requestBody = GetNftMetadataRequestBody(nftAddresses),
      responseClass = NftMetadataResponseBody::class.java,
    )

    return response.map(NftMetadataFactory::create)
  }
}