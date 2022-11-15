package com.dgsd.khelius.balance.factory

import com.dgsd.khelius.balance.model.TokenBalance
import com.dgsd.khelius.balance.response.TokenBalanceResponseBody
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class TokenBalanceFactoryTest {

  @Test
  fun create_returnsExpectedResult() {
    val input = TokenBalanceResponseBody(
      tokenAccount = "abc123",
      mint = "def456",
      amount = 123,
      decimals = 9
    )

    val actualOutput = TokenBalanceFactory.create(input)

    val expectedOutput = TokenBalance(
      account = "abc123",
      mint = "def456",
      balance = 123,
      decimals = 9
    )

    Assertions.assertEquals(expectedOutput, actualOutput)
  }
}