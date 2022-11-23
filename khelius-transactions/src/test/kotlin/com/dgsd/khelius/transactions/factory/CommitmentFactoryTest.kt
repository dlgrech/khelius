package com.dgsd.khelius.transactions.factory

import com.dgsd.khelius.transactions.model.Commitment
import com.dgsd.khelius.transactions.response.CommitmentResponse
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class CommitmentFactoryTest {

  @Test
  fun create_fromUnknownString_throwsError() {
    Assertions.assertThrows(IllegalStateException::class.java) {
      CommitmentFactory.create("this_is_rubbish")
    }
  }

  @Test
  fun create_fromString_returnsExpectedResult() {
    Assertions.assertEquals(
      Commitment.CONFIRMED,
      CommitmentFactory.create(CommitmentResponse.CONFIRMED)
    )
    Assertions.assertEquals(
      Commitment.FINALIZED,
      CommitmentFactory.create(CommitmentResponse.FINALIZED)
    )
  }

  @Test
  fun create_fromCommitment_returnsExpectedResult() {
    Assertions.assertEquals(
      CommitmentResponse.CONFIRMED,
      CommitmentFactory.create(Commitment.CONFIRMED)
    )
    Assertions.assertEquals(
      CommitmentResponse.FINALIZED,
      CommitmentFactory.create(Commitment.FINALIZED)
    )
  }
}