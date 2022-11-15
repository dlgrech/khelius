package com.dgsd.khelius.balance

import com.dgsd.khelius.balance.model.BalanceSummary
import com.dgsd.khelius.core.network.HeliusApi
import okhttp3.OkHttpClient

/**
 * Creates a default [BalanceApi] instance
 */
fun BalanceApi(
  apiKey: String,
  okHttpClient: OkHttpClient = OkHttpClient()
): BalanceApi {
  val heliusApi = HeliusApi(apiKey, okHttpClient)
  return BalanceApiImpl(heliusApi)
}

/**
 * Wrapper for the Helius Balances API
 *
 * @see <a href="https://docs.helius.xyz/api-reference/balances-api">Helius API Docs</a>
 */
interface BalanceApi {

  /**
   * Retrieve the native balance and token balances for a given address.
   *
   * @see <a href="https://docs.helius.xyz/api-reference/balances-api">Helius API Docs</a>
   */
  suspend fun getBalanceSummary(account: String): BalanceSummary
}