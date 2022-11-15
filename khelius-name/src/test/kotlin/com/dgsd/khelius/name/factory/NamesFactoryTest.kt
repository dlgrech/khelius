package com.dgsd.khelius.name.factory

import com.dgsd.khelius.name.model.NamesSummary
import com.dgsd.khelius.name.response.GetNamesResponseBody
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class NamesFactoryTest {

  @Test
  fun create_withNoDomains_returnsExpectedResult() {
    val inputAccount = "abc123"
    val inputResponse = GetNamesResponseBody(
      domains = null
    )

    val actualOutput = NamesFactory.create(inputAccount, inputResponse)
    val expectedOutput = NamesSummary(
      account = inputAccount,
      names = emptyList(),
    )

    Assertions.assertEquals(expectedOutput, actualOutput)
  }

  @Test
  fun create_withEmptyDomains_returnsExpectedResult() {
    val inputAccount = "abc123"
    val inputResponse = GetNamesResponseBody(
      domains = emptyList()
    )

    val actualOutput = NamesFactory.create(inputAccount, inputResponse)
    val expectedOutput = NamesSummary(
      account = inputAccount,
      names = emptyList(),
    )

    Assertions.assertEquals(expectedOutput, actualOutput)
  }

  @Test
  fun create_withDomains_returnsExpectedResult() {
    val inputAccount = "abc123"
    val inputResponse = GetNamesResponseBody(
      domains = listOf("homer", "marge")
    )

    val actualOutput = NamesFactory.create(inputAccount, inputResponse)
    val expectedOutput = NamesSummary(
      account = inputAccount,
      names = listOf("homer", "marge"),
    )

    Assertions.assertEquals(expectedOutput, actualOutput)
  }
}