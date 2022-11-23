package com.dgsd.khelius.transactions.response

/**
 * The different types of transactions known to the Helius API
 *
 * @see <a href="https://app.swaggerhub.com/apis-docs/Helius/HeliusAPI/1.0.0#/TransactionType">Helius API Docs</a>
 */
@Target(
  AnnotationTarget.TYPE_PARAMETER,
  AnnotationTarget.VALUE_PARAMETER,
  AnnotationTarget.FUNCTION
)
@Retention(AnnotationRetention.SOURCE)
internal annotation class SaleTypeResponse {
  companion object {
    const val AUCTION = "AUCTION"
    const val INSTANT_SALE = "INSTANT_SALE"
    const val OFFER = "OFFER"
    const val GLOBAL_OFFER = "GLOBAL_OFFER"
    const val MINT = "MINT"
    const val UNKNOWN = "UNKNOWN"
  }
}