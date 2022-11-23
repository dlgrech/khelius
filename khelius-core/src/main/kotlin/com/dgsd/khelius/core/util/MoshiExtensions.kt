package com.dgsd.khelius.core.util

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

/**
 * Creates a [JsonAdapter] that can be used for parsing lists of objects
 */
internal fun <T> Moshi.listAdapter(cls: Class<T>): JsonAdapter<List<T>> {
  return adapter(Types.newParameterizedType(List::class.java, cls))
}