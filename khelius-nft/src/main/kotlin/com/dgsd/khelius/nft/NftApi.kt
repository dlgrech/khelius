package com.dgsd.khelius.nft

import com.dgsd.khelius.common.model.NftEventInfo
import com.dgsd.khelius.core.network.HeliusApi
import com.dgsd.khelius.nft.model.NftListSummary
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

  /**
   * Returns all NFT events given an address
   */
  suspend fun getEvents(account: String): List<NftEventInfo>

  /**
   * Returns all the NFTs that the given address currently holds.
   */
  suspend fun getNfts(account: String, pageNumber: Int? = null): NftListSummary
}