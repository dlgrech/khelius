package com.dgsd.khelius.nft

import com.dgsd.khelius.common.factory.NftEventFactory
import com.dgsd.khelius.common.model.NftEventInfo
import com.dgsd.khelius.common.response.NftEventResponseBody
import com.dgsd.khelius.core.network.HeliusApi

private const val NFT_EVENTS_REQUEST_PATH_TEMPLATE = "/v0/addresses/%s/nft-events"

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
}