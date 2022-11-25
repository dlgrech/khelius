package com.dgsd.khelius.common.response

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
annotation class TokenStandardResponse {
  companion object {
    const val NON_FUNGIBLE = "NonFungible"
    const val FUNGIBLE = "Fungible"
    const val FUNGIBLE_ASSET = "FungibleAsset"
    const val NON_FUNGIBLE_EDITION = "NonFungibleEdition"
  }
}