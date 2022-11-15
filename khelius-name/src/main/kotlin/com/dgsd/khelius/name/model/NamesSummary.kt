package com.dgsd.khelius.name.model

/**
 * Represents the different Solana Name Service (SNS) domains that belong to a single account
 */
data class NamesSummary(
  /**
   * The base-58 public key hash for the account this name summary represents
   */
  val account: String,

  /**
   * The list of Solana Name Service domains that belong to this account
   */
  val names: List<String>
)