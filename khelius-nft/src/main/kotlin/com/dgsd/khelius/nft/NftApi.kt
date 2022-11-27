package com.dgsd.khelius.nft

import com.dgsd.khelius.common.model.NftEventInfo
import com.dgsd.khelius.core.network.HeliusApi
import okhttp3.OkHttpClient

/**
 * Creates a default [NftApi] instance
 */
fun NftApi(
  apiKey: String,
  okHttpClient: OkHttpClient = OkHttpClient()
): NftApi {
  val heliusApi = HeliusApi(apiKey, okHttpClient)
  return NftApiImpl(heliusApi)
}

/**
 * Wrapper for the Helius NFT API
 *
 * @see <a href="https://docs.helius.xyz/api-reference/nft-api">Helius API Docs</a>
 */
interface NftApi {

  suspend fun getEvents(account: String): List<NftEventInfo>
}