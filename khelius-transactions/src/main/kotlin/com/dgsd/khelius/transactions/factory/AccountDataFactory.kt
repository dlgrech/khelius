package com.dgsd.khelius.transactions.factory

import com.dgsd.khelius.transactions.model.EnrichedTransaction
import com.dgsd.khelius.transactions.response.EnrichedTransactionResponseBody

/**
 * Maps a raw json response object into a higher-level model object exposed by the library
 */
internal object AccountDataFactory {

  fun create(response: EnrichedTransactionResponseBody.AccountDataResponseBody): EnrichedTransaction.AccountData {
    return EnrichedTransaction.AccountData(
      account = response.account,
      nativeBalanceChange = response.nativeBalanceChange,
      tokenBalanceChanges = response.tokenBalanceChanges.orEmpty().map(::create)
    )
  }

  private fun create(
    response: EnrichedTransactionResponseBody.AccountDataResponseBody.TokenBalanceChangesResponseBody
  ): EnrichedTransaction.AccountData.TokenBalanceChange {
    return EnrichedTransaction.AccountData.TokenBalanceChange(
      userAccount = response.userAccount,
      tokenAccount = response.tokenAccount,
      tokenMint = response.mint,
      tokenAmount = response.rawTokenAmount.tokenAmount,
      tokenDecimals = response.rawTokenAmount.decimals
    )
  }
}