package com.dgsd.khelius.transactions.factory

import com.dgsd.khelius.transactions.model.EnrichedTransaction
import com.dgsd.khelius.transactions.response.EnrichedTransactionResponseBody

/**
 * Maps a raw json response object into a higher-level model object exposed by the library
 */
internal object EnrichedTransactionFactory {

  fun create(response: EnrichedTransactionResponseBody): EnrichedTransaction {
    return EnrichedTransaction(
      signature = response.signature,
      description = response.description.orEmpty().ifBlank { null },
      type = TransactionTypeFactory.create(response.type),
      source = TransactionSourceFactory.create(response.source),
      fee = response.fee,
      feePayer = response.feePayer,
      timestamp = response.timestamp,
      slot = response.slot,
      nativeTransfers = response.nativeTransfers.orEmpty().map { NativeTransferFactory.create(it) },
      tokenTransfers = response.tokenTransfers.orEmpty().map { TokenTransferFactory.create(it) }
    )
  }
}