package com.dgsd.khelius.transactions.model

/**
 * @see <a href="https://app.swaggerhub.com/apis-docs/Helius/HeliusAPI/1.0.0#/ProgramInfo">Helius API Docs</a>
 */
data class ProgramInfo(
  val account: String,
  val source: TransactionSource,
  val programName: String,
  val instructionName: String?,
)