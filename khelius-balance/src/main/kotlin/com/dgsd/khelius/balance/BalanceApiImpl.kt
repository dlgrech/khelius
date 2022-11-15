package com.dgsd.khelius.balance

import com.dgsd.khelius.balance.factory.BalanceSummaryFactory
import com.dgsd.khelius.balance.model.BalanceSummary
import com.dgsd.khelius.balance.response.BalanceSummaryResponseBody
import com.dgsd.khelius.core.network.HeliusApi

private const val BALANCE_REQUEST_PATH_TEMPLATE = "/v0/addresses/%s/balances"

/**
 * Default implementation of the [BalanceApi] interface
 */
internal class BalanceApiImpl(
  private val heliusApi: HeliusApi
) : BalanceApi {

  override suspend fun getBalanceSummary(account: String): BalanceSummary {
    val requestPath = String.format(BALANCE_REQUEST_PATH_TEMPLATE, account)

    val response = heliusApi.get(requestPath, BalanceSummaryResponseBody::class.java)

    return BalanceSummaryFactory.create(account, response)
  }
}