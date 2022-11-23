package com.dgsd.khelius.core.network

import com.dgsd.khelius.core.exception.ApiException
import com.dgsd.khelius.core.response.ErrorResponseBody
import com.dgsd.khelius.core.util.listAdapter
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody

/**
 * Base URL to execute Helius API calls against
 */
private const val HELIUS_URL = "https://api.helius.xyz"

/**
 * The key of the URL query parameter which specifies the Helius API key.
 */
private const val API_KEY_QUERY_PARAM = "api-key"

/**
 * Used for sending JSON as a POST body
 */
private val JSON_MEDIA_TYPE = "application/json".toMediaType()

/**
 * Default implementation of the [HeliusApi] interface
 */
internal class HeliusApiImpl(
  private val apiKey: String,
  private val okHttpClient: OkHttpClient = OkHttpClient(),
  private val coroutineDispatcher: CoroutineDispatcher = Dispatchers.IO
) : HeliusApi {

  private val moshiJson: Moshi = Moshi.Builder().build()

  override suspend fun <T : Any> get(
    requestPath: String,
    responseClass: Class<T>,
    queryParams: Map<String, String>,
  ): T = withContext(coroutineDispatcher) {
    try {
      val request = createGetRequest(requestPath, queryParams, apiKey)
      val jsonResponse = request.execute()
      moshiJson.adapter(responseClass).fromJsonOrThrow(jsonResponse)
    } catch (e: Throwable) {
      throw ApiException("Error executing API request for $requestPath", e)
    }
  }

  override suspend fun <T : Any> getList(
    requestPath: String,
    responseClass: Class<T>,
    queryParams: Map<String, String>,
  ): List<T> = withContext(coroutineDispatcher) {
    try {
      val request = createGetRequest(requestPath, queryParams, apiKey)
      val jsonResponse = request.execute()
      moshiJson.listAdapter(responseClass).fromJsonOrThrow(jsonResponse)
    } catch (e: Throwable) {
      throw ApiException("Error executing API request for $requestPath", e)
    }
  }

  override suspend fun <B : Any, T : Any> postList(
    requestPath: String,
    requestBody: B,
    responseClass: Class<T>,
    queryParams: Map<String, String>
  ): List<T> = withContext(coroutineDispatcher) {
    try {
      val bodyJson = moshiJson.adapter<B>(requestBody::class.java).toJson(requestBody)
      val request = createPostRequest(requestPath, queryParams, apiKey, bodyJson)
      val jsonResponse = request.execute()
      moshiJson.listAdapter(responseClass).fromJsonOrThrow(jsonResponse)
    } catch (e: Throwable) {
      throw ApiException("Error executing API request for $requestPath", e)
    }
  }

  private suspend fun Request.execute(): String {
    val httpResponse = okHttpClient.newCall(this).await()
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

  private fun createGetRequest(
    requestPath: String,
    queryParams: Map<String, String>,
    apiKey: String,
  ): Request {
    return Request.Builder()
      .url(createUrl(requestPath, queryParams, apiKey))
      .build()
  }

  private fun createPostRequest(
    requestPath: String,
    queryParams: Map<String, String>,
    apiKey: String,
    bodyJson: String,
  ): Request {
    return Request.Builder()
      .url(createUrl(requestPath, queryParams, apiKey))
      .post(bodyJson.toRequestBody(JSON_MEDIA_TYPE))
      .build()
  }

  private fun createUrl(
    requestPath: String,
    queryParams: Map<String, String>,
    apiKey: String,
  ): HttpUrl {
    val rawUrl = HELIUS_URL + requestPath
    return rawUrl.toHttpUrl()
      .newBuilder()
      .addQueryParameter(API_KEY_QUERY_PARAM, apiKey)
      .apply {
        queryParams.forEach { (key, value) ->
          addQueryParameter(key, value)
        }
      }.build()
  }

  private fun <T : Any> JsonAdapter<T>.fromJsonOrThrow(json: String): T {
    return fromJson(json) ?: throw ApiException("Empty API response")
  }
}