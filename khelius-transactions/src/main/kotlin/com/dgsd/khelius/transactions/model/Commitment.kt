package com.dgsd.khelius.transactions.model

/**
 * How finalized a transaction is
 *
 * @see <a href="https://app.swaggerhub.com/apis-docs/Helius/HeliusAPI/1.0.0#/Commitment">Helius API Docs</a>
 */
enum class Commitment {
  FINALIZED,
  CONFIRMED,
}