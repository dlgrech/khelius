package com.dgsd.khelius.transactions.factory

import com.dgsd.khelius.transactions.model.TransactionType
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class TransactionTypeFactoryTest {

  @Test
  fun create_whenGivenUnknownResponse_returnsUnknown() {
    val input = "this is rubbish"
    val expected = TransactionType.UNKNOWN

    val actual = TransactionTypeFactory.create(input)

    Assertions.assertEquals(expected, actual)
  }
}