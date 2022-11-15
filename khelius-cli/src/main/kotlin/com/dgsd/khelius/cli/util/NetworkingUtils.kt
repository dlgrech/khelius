package com.dgsd.khelius.cli.util

import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

/**
 * Creates a [OkHttpClient] instance with a default configuration
 */
fun newOkHttpClient(): OkHttpClient {
  return OkHttpClient.Builder()
    .connectTimeout(10, TimeUnit.SECONDS)
    .callTimeout(10, TimeUnit.SECONDS)
    .readTimeout(10, TimeUnit.SECONDS)
    .build()
}