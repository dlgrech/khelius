package com.dgsd.khelius.balance.factory

import com.dgsd.khelius.balance.model.BalanceSummary
import com.dgsd.khelius.balance.response.BalanceSummaryResponseBody

/**
 * Maps a raw json response object into a higher-level model object exposed by the library
 */
internal object BalanceSummaryFactory {

  fun create(
    account: String,
    response: BalanceSummaryResponseBody,
  ): BalanceSummary {
    return BalanceSummary(
      account = account,
      nativeBalance = response.nativeBalance,
      tokens = response.tokens.orEmpty().map(TokenBalanceFactory::create)
    )
  }
}