package com.dgsd.khelius.core.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Represents the error json format returned from the Helius API
 *
 * @see <a href="https://app.swaggerhub.com/apis-docs/Helius/HeliusAPI/1.0.0">Helius API Docs</a>
 */
@JsonClass(generateAdapter = true)
internal data class ErrorResponseBody(
  @Json(name = "error") val errorMessage: String?,
)