package com.dgsd.khelius.core.network

import com.dgsd.khelius.core.exception.ApiException
import com.dgsd.khelius.core.response.ErrorResponseBody
import com.squareup.moshi.Moshi
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request

/**
 * Base URL to execute Helius API calls against
 */
private const val HELIUS_URL = "https://api.helius.xyz"

/**
 * The key of the URL query parameter which specifies the Helius API key.
 */
private const val API_KEY_QUERY_PARAM = "api-key"

/**
 * Default implementation of the [HeliusApi] interface
 */
internal class HeliusApiImpl(
  private val apiKey: String,
  private val okHttpClient: OkHttpClient = OkHttpClient(),
  private val coroutineDispatcher: CoroutineDispatcher = Dispatchers.IO
) : HeliusApi {

  private val moshiJson: Moshi = Moshi.Builder().build()

  override suspend fun <T> get(
    requestPath: String,
    responseClass: Class<T>
  ): T = withContext(coroutineDispatcher) {
    try {
      val jsonResponse = execute(createRequest(requestPath, apiKey))
      val parsedResponse = moshiJson.adapter(responseClass).fromJson(jsonResponse)
      parsedResponse ?: throw ApiException("Empty API response")
    } catch (e: Throwable) {
      throw ApiException("Error executing API request for $requestPath", e)
    }
  }

  private suspend fun execute(
    httpRequest: Request,
  ): String {
    val httpResponse = okHttpClient.newCall(httpRequest).await()
    val responseBody = httpResponse.body?.string()
    if (httpResponse.isSuccessful) {
      return checkNotNull(responseBody)
    } else if (responseBody == null) {
      throw ApiException("Empty response body")
    } else {
      val errorResponseParser = moshiJson.adapter(ErrorResponseBody::class.java)
      val error = errorResponseParser.fromJson(responseBody)
      throw ApiException(error?.errorMessage.orEmpty())
    }
  }

  private fun createRequest(
    requestPath: String,
    apiKey: String,
  ): Request {
    val rawUrl = HELIUS_URL + requestPath
    val url = rawUrl.toHttpUrl()
      .newBuilder()
      .addQueryParameter(API_KEY_QUERY_PARAM, apiKey)
      .build()
    return Request.Builder().url(url).build()
  }
}