package com.dgsd.khelius.transactions.factory

import com.dgsd.khelius.transactions.model.SaleType
import com.dgsd.khelius.transactions.response.SaleTypeResponse

/**
 * Maps a raw json response object into a higher-level model object exposed by the library
 */
internal object SaleTypeFactory {

  fun create(
    @SaleTypeResponse response: String,
  ): SaleType {
    return when (response) {
      SaleTypeResponse.AUCTION -> SaleType.AUCTION
      SaleTypeResponse.INSTANT_SALE -> SaleType.INSTANT_SALE
      SaleTypeResponse.OFFER -> SaleType.OFFER
      SaleTypeResponse.GLOBAL_OFFER -> SaleType.GLOBAL_OFFER
      SaleTypeResponse.MINT -> SaleType.MINT
      else -> SaleType.UNKNOWN
    }
  }
}