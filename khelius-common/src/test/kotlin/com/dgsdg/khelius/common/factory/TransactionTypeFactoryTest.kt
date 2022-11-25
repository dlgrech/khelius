package com.dgsdg.khelius.common.factory

import com.dgsd.khelius.common.factory.TransactionTypeFactory
import com.dgsd.khelius.common.model.TransactionType
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