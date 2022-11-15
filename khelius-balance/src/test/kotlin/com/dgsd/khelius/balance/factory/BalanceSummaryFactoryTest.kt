package com.dgsd.khelius.balance.factory

import com.dgsd.khelius.balance.model.BalanceSummary
import com.dgsd.khelius.balance.model.TokenBalance
import com.dgsd.khelius.balance.response.BalanceSummaryResponseBody
import com.dgsd.khelius.balance.response.TokenBalanceResponseBody
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class BalanceSummaryFactoryTest {

  @Test
  fun create_withNoTokens_ReturnsExpectedResult() {
    val inputAccount = "abc123"
    val inputResponse = BalanceSummaryResponseBody(
      nativeBalance = 123,
      tokens = null,
    )

    val actualOutput = BalanceSummaryFactory.create(inputAccount, inputResponse)

    val expectedOutput = BalanceSummary(
      account = "abc123",
      nativeBalance = 123,
      tokens = emptyList()
    )

    Assertions.assertEquals(expectedOutput, actualOutput)
  }

  @Test
  fun create_withEmptyTokens_ReturnsExpectedResult() {
    val inputAccount = "abc123"
    val inputResponse = BalanceSummaryResponseBody(
      nativeBalance = 123,
      tokens = emptyList()
    )

    val actualOutput = BalanceSummaryFactory.create(inputAccount, inputResponse)

    val expectedOutput = BalanceSummary(
      account = "abc123",
      nativeBalance = 123,
      tokens = emptyList()
    )

    Assertions.assertEquals(expectedOutput, actualOutput)
  }

  @Test
  fun create_withTokens_returnsExpectedResult() {
    val inputAccount = "abc123"
    val inputResponse = BalanceSummaryResponseBody(
      nativeBalance = 123,
      tokens = listOf(
        TokenBalanceResponseBody(
          tokenAccount = "abc123",
          mint = "def456",
          amount = 123,
          decimals = 9
        )
      ),
    )

    val actualOutput = BalanceSummaryFactory.create(inputAccount, inputResponse)

    val expectedOutput = BalanceSummary(
      account = "abc123",
      nativeBalance = 123,
      tokens = listOf(
        TokenBalance(
          account = "abc123",
          mint = "def456",
          balance = 123,
          decimals = 9
        )
      )
    )

    Assertions.assertEquals(expectedOutput, actualOutput)
  }
}