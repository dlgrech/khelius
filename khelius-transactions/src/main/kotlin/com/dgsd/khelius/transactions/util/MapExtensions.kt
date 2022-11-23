package com.dgsd.khelius.transactions.util

/**
 * Returns a [Map<K, V>] without any null values contained in the original map
 */
@Suppress("UNCHECKED_CAST")
fun <K, V> Map<K, V?>.filterNonNullValues(): Map<K, V> {
  return filterValues { it != null } as Map<K, V>
}