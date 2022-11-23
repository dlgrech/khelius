package com.dgsd.khelius.transactions.util

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class MapExtensionsTest {

  @Test
  fun filterNonNullValues_whenOnlyContainingNullValues_returnsEmptyMap() {
    val input = mapOf("a" to null, "b" to null, "c" to null)
    val expected = emptyMap<String, String>()

    val actual = input.filterNonNullValues()

    Assertions.assertEquals(expected, actual)
  }

  @Test
  fun filterNonNullValues_onEmptyMap_returnsEmptyMap() {
    val input = emptyMap<String, String>()
    val expected = emptyMap<String, String>()

    val actual = input.filterNonNullValues()

    Assertions.assertEquals(expected, actual)
  }

  @Test
  fun filterNonNullValues_whenContainingNoNullValues_returnsExpectedValue() {
    val input = mapOf("a" to 1, "b" to 2, "c" to 3)
    val expected = mapOf("a" to 1, "b" to 2, "c" to 3)

    val actual = input.filterNonNullValues()

    Assertions.assertEquals(expected, actual)
  }

  @Test
  fun filterNonNullValues_whenContainingMixedNullabilityValues_returnsEmptyMap() {
    val input = mapOf("a" to 1, "b" to null, "c" to 3)
    val expected = mapOf("a" to 1, "c" to 3)

    val actual = input.filterNonNullValues()

    Assertions.assertEquals(expected, actual)
  }
}