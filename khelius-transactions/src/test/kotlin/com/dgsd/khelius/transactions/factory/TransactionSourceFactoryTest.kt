package com.dgsd.khelius.transactions.factory

import com.dgsd.khelius.transactions.model.TransactionSource
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class TransactionSourceFactoryTest {

  @Test
  fun create_whenGivenUnknownResponse_returnsUnknown() {
    val input = "this is rubbish"
    val expected = TransactionSource.UNKNOWN

    val actual = TransactionSourceFactory.create(input)

    Assertions.assertEquals(expected, actual)
  }
}