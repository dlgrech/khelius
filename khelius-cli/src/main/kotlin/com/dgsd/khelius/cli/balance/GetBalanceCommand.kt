package com.dgsd.khelius.cli.balance

import com.dgsd.khelius.balance.BalanceApi
import com.dgsd.khelius.cli.util.accountArgument
import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.requireObject
import kotlinx.coroutines.runBlocking

/**
 * Retrieve a balance of a given Solana Account.
 *
 * This includes the native balance as well as the balance of each different token type
 */
internal class GetBalanceCommand : CliktCommand(
  name = "get",
  help = "Returns the native Solana balance (in lamports) and all token balances for a given address."
) {

  private val balanceApi by requireObject<BalanceApi>()
  private val account by accountArgument()

  override fun run() = runBlocking {
    val balanceSummary = balanceApi.getBalanceSummary(account)
    echo(balanceSummary)
  }
}