package com.dgsd.khelius.common.factory

import com.dgsd.khelius.common.model.NftEventInfo
import com.dgsd.khelius.common.response.NftEventResponseBody

/**
 * Maps a raw json response object into a higher-level model object exposed by the library
 */
object NftEventFactory {

  fun create(
    response: NftEventResponseBody
  ): NftEventInfo {
    return NftEventInfo(
      description = response.description?.ifBlank { null },
      signature = response.signature,
      type = NftEventTypeFactory.create(response.type),
      source = TransactionSourceFactory.create(response.source),
      amount = response.amount,
      fee = response.fee,
      feePayer = response.feePayer,
      slot = response.slot,
      timestamp = response.timestamp,
      saleType = SaleTypeFactory.create(response.saleType),
      buyer = response.buyer?.ifBlank { null },
      seller = response.seller?.ifBlank { null },
      staker = response.staker?.ifBlank { null },
      nfts = response.nfts.orEmpty().map(NftEventFactory::create)
    )
  }

  private fun create(
    response: NftEventResponseBody.NftTokenResponseBody
  ): NftEventInfo.Token {
    return NftEventInfo.Token(
      mint = response.mint,
      tokenStandard = TokenStandardFactory.create(response.tokenStandard)
    )
  }
}