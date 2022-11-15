package com.dgsd.khelius.name

import com.dgsd.khelius.core.network.HeliusApi
import com.dgsd.khelius.name.model.NamesSummary
import okhttp3.OkHttpClient

/**
 * Creates a default [NameApi] instance
 */
fun NameApi(
  apiKey: String,
  okHttpClient: OkHttpClient = OkHttpClient()
): NameApi {
  val heliusApi = HeliusApi(apiKey, okHttpClient)
  return NameApiImpl(heliusApi)
}

/**
 * Wrapper for the Helius Name API
 *
 * @see <a href="https://docs.helius.xyz/api-reference/name-api">Helius API Docs</a>
 */
interface NameApi {

  /**
   * Retrieve a list of Solana Name Service domain names for the given account
   *
   * @see <a href="https://docs.helius.xyz/api-reference/name-api/name-lookup">Helius API Docs</a>
   */
  suspend fun getNames(account: String): NamesSummary
}