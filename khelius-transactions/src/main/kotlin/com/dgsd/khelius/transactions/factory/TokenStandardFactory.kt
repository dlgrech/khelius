package com.dgsd.khelius.transactions.factory

import com.dgsd.khelius.transactions.model.TokenStandard
import com.dgsd.khelius.transactions.response.TokenStandardResponse

/**
 * Maps a raw json response object into a higher-level model object exposed by the library
 */
internal object TokenStandardFactory {

  fun create(@TokenStandardResponse response: String): TokenStandard {
    return when (response) {
      TokenStandardResponse.NON_FUNGIBLE -> TokenStandard.NON_FUNGIBLE
      TokenStandardResponse.FUNGIBLE -> TokenStandard.FUNGIBLE
      TokenStandardResponse.FUNGIBLE_ASSET -> TokenStandard.FUNGIBLE_ASSET
      TokenStandardResponse.NON_FUNGIBLE_EDITION -> TokenStandard.NON_FUNGIBLE_EDITION
      else -> error("Unknown token standard: $response")
    }
  }
}