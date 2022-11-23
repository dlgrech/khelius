package com.dgsd.khelius.transactions.factory

import com.dgsd.khelius.transactions.model.NativeTransfer
import com.dgsd.khelius.transactions.response.EnrichedTransactionResponseBody

/**
 * Maps a raw json response object into a higher-level model object exposed by the library
 */
internal object NativeTransferFactory {

  fun create(
    response: EnrichedTransactionResponseBody.NativeTransferResponseBody
  ): NativeTransfer {
    return NativeTransfer(
      fromUserAccount = response.fromUserAccount,
      toUserAccount = response.toUserAccount,
      amount = response.amount
    )
  }
}