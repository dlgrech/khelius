package com.dgsd.khelius.core.network

import okhttp3.OkHttpClient

/**
 * Creates a default [HeliusApi] instance
 */
fun HeliusApi(
  apiKey: String,
  okHttpClient: OkHttpClient = OkHttpClient(),
): HeliusApi {
  return HeliusApiImpl(apiKey, okHttpClient)
}

/**
 * Utility for making raw HTTP calls to the Helius backend.
 *
 * This class should not be used be consumers of the library. It is used by other library modules
 * to make outgoing HTTP requests
 */
interface HeliusApi {

  /**
   * Retrieve a resource from the Helius API at the given `requestPath` and parse the results
   *
   * @param requestPath The URL path of the request to make. This should always begin with a '/'.
   * For example, `/v0/addresses/<ADDRESS>/balances
   * @param responseClass The type that is expected to be returned from the API call
   * @param queryParams Query parameters to include with the request
   */
  suspend fun <T : Any> get(
    requestPath: String,
    responseClass: Class<T>,
    queryParams: Map<String, String> = emptyMap(),
  ): T

  /**
   * Retrieve a list of resources from the Helius API at the given `requestPath` and parse the results
   *
   * @param requestPath The URL path of the request to make. This should always begin with a '/'.
   * For example, `/v0/addresses/<ADDRESS>/balances
   * @param responseClass The type that is expected to be returned from the API call
   * @param queryParams Query parameters to include with the request
   */
  suspend fun <T : Any> getList(
    requestPath: String,
    responseClass: Class<T>,
    queryParams: Map<String, String> = emptyMap(),
  ): List<T>

  /**
   * Retrieve a list of resources from the Helius API at the given `requestPath` and parse the results
   *
   * @param requestPath The URL path of the request to make. This should always begin with a '/'.
   * For example, `/v0/addresses/<ADDRESS>/balances
   * @param requestBody The data to send as a json-encoded request body
   * @param responseClass The type that is expected to be returned from the API call
   * @param queryParams Query parameters to include with the request
   */
  suspend fun <B : Any, T : Any> postList(
    requestPath: String,
    requestBody: B,
    responseClass: Class<T>,
    queryParams: Map<String, String> = emptyMap(),
  ): List<T>

}