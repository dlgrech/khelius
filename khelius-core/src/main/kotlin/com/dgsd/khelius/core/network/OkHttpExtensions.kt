package com.dgsd.khelius.core.network

import kotlinx.coroutines.suspendCancellableCoroutine
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import java.io.IOException
import kotlin.coroutines.resumeWithException

/**
 * Executes a [Call] object in `suspend`-compatible way
 */
internal suspend inline fun Call.await(): Response {
  return suspendCancellableCoroutine { continuation ->
    enqueue(object : Callback {
      override fun onFailure(call: Call, e: IOException) {
        if (!continuation.isCancelled) {
          continuation.resumeWithException(e)
        }
      }

      override fun onResponse(call: Call, response: Response) {
        continuation.resume(response, onCancellation = { cancel() })
      }
    })

    continuation.invokeOnCancellation {
      try {
        cancel()
      } catch (_: Throwable) {
        // Ignored..
      }
    }
  }
}
