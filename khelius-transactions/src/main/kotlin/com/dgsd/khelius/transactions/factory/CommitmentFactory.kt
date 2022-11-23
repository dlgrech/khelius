package com.dgsd.khelius.transactions.factory

import com.dgsd.khelius.transactions.model.Commitment
import com.dgsd.khelius.transactions.response.CommitmentResponse

/**
 * Maps a raw json response object into a higher-level model object exposed by the library
 */
internal object CommitmentFactory {

  fun create(@CommitmentResponse response: String): Commitment {
    return when (response) {
      CommitmentResponse.FINALIZED -> Commitment.FINALIZED
      CommitmentResponse.CONFIRMED -> Commitment.CONFIRMED
      else -> error("Unknown commitment: $response")
    }
  }

  @CommitmentResponse
  fun create(commitment: Commitment): String {
    return when (commitment) {
      Commitment.FINALIZED -> CommitmentResponse.FINALIZED
      Commitment.CONFIRMED -> CommitmentResponse.CONFIRMED
    }
  }
}