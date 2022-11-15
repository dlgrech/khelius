package com.dgsd.khelius.balance.factory

import com.dgsd.khelius.balance.model.TokenBalance
import com.dgsd.khelius.balance.response.TokenBalanceResponseBody

/**
 * Maps a raw json response object into a higher-level model object exposed by the library
 */
internal object TokenBalanceFactory {

  fun create(responseBody: TokenBalanceResponseBody): TokenBalance {
    return TokenBalance(
      account = responseBody.tokenAccount,
      mint = responseBody.mint,
      balance = responseBody.amount,
      decimals = responseBody.decimals
    )
  }
}