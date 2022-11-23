package com.dgsd.khelius.transactions.response

/**
 * The different sources of transactions known to the Helius API
 *
 * @see <a href="https://app.swaggerhub.com/apis-docs/Helius/HeliusAPI/1.0.0#/TransactionSource">Helius API Docs</a>
 */
@Target(
  AnnotationTarget.TYPE_PARAMETER,
  AnnotationTarget.VALUE_PARAMETER,
  AnnotationTarget.FUNCTION
)
@Retention(AnnotationRetention.SOURCE)
annotation class CommitmentResponse {
  companion object {
    const val FINALIZED = "finalized"
    const val CONFIRMED = "confirmed"
  }
}