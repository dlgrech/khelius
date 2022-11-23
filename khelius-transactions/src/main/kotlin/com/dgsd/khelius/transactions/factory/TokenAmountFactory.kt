package com.dgsd.khelius.transactions.factory

import com.dgsd.khelius.transactions.model.TokenAmount
import com.dgsd.khelius.transactions.response.TokenAmountResponseBody

/**
 * Maps a raw json response object into a higher-level model object exposed by the library
 */
internal object TokenAmountFactory {

  fun create(
    response: TokenAmountResponseBody
  ): TokenAmount {
    return TokenAmount(
      userAccount = response.userAccount,
      tokenAccount = response.tokenAccount,
      tokenMint = response.mint,
      tokenAmount = response.rawTokenAmount.tokenAmount,
      tokenDecimals = response.rawTokenAmount.decimals,
    )
  }
}