package com.dgsd.khelius.core.exception

/**
 * Exception type thrown when there is a problem executing an API request
 */
internal class ApiException(
  message: String,
  cause: Throwable? = null
) : RuntimeException(message, cause)