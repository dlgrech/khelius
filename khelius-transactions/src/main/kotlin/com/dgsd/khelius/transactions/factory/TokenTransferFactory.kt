package com.dgsd.khelius.transactions.factory

import com.dgsd.khelius.transactions.model.EnrichedTransaction
import com.dgsd.khelius.transactions.response.EnrichedTransactionResponseBody

/**
 * Maps a raw json response object into a higher-level model object exposed by the library
 */
internal object TokenTransferFactory {

  fun create(
    response: EnrichedTransactionResponseBody.TokenTransferResponseBody
  ): EnrichedTransaction.TokenTransfer {
    return EnrichedTransaction.TokenTransfer(
      fromUserAccount = response.fromUserAccount?.ifBlank { null },
      toUserAccount = response.toUserAccount,
      fromTokenAccount = response.fromTokenAccount?.ifBlank { null },
      toTokenAccount = response.toTokenAccount,
      mint = response.mint,
      amount = response.tokenAmount,
      tokenStandard = TokenStandardFactory.create(response.tokenStandard)
    )
  }
}