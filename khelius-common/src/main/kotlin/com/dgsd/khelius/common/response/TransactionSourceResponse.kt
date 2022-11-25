package com.dgsd.khelius.common.response

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
annotation class TransactionSourceResponse {
  companion object {
    const val FORM_FUNCTION = "FORM_FUNCTION"
    const val EXCHANGE_ART = "EXCHANGE_ART"
    const val CANDY_MACHINE_V2 = "CANDY_MACHINE_V2"
    const val CANDY_MACHINE_V1 = "CANDY_MACHINE_V1"
    const val UNKNOWN = "UNKNOWN"
    const val SOLANART = "SOLANART"
    const val SOLSEA = "SOLSEA"
    const val MAGIC_EDEN = "MAGIC_EDEN"
    const val HOLAPLEX = "HOLAPLEX"
    const val METAPLEX = "METAPLEX"
    const val OPENSEA = "OPENSEA"
    const val SOLANA_PROGRAM_LIBRARY = "SOLANA_PROGRAM_LIBRARY"
    const val ANCHOR = "ANCHOR"
    const val W_SOL = "W_SOL"
    const val PHANTOM = "PHANTOM"
    const val SYSTEM_PROGRAM = "SYSTEM_PROGRAM"
    const val STAKE_PROGRAM = "STAKE_PROGRAM"
    const val COINBASE = "COINBASE"
    const val CORAL_CUBE = "CORAL_CUBE"
    const val HEDGE = "HEDGE"
    const val LAUNCH_MY_NFT = "LAUNCH_MY_NFT"
    const val GEM_BANK = "GEM_BANK"
    const val GEM_FARM = "GEM_FARM"
    const val DEGODS = "DEGODS"
    const val BLOCKSMITH_LABS = "BLOCKSMITH_LABS"
    const val YAWWW = "YAWWW"
    const val ATADIA = "ATADIA"
    const val SOLPORT = "SOLPORT"
    const val HYPERSPACE = "HYPERSPACE"
    const val DIGITAL_EYES = "DIGITAL_EYES"
    const val TENSOR = "TENSOR"
    const val BIFROST = "BIFROST"
    const val JUPITER = "JUPITER"
    const val MERCURIAL_STABLE_SWAP = "MERCURIAL_STABLE_SWAP"
    const val SABER = "SABER"
    const val SERUM = "SERUM"
    const val STEP_FINANCE = "STEP_FINANCE"
    const val CROPPER = "CROPPER"
    const val RAYDIUM = "RAYDIUM"
    const val ALDRIN = "ALDRIN"
    const val CREMA = "CREMA"
    const val LIFINITY = "LIFINITY"
    const val CYKURA = "CYKURA"
    const val ORCA = "ORCA"
    const val MARINADE = "MARINADE"
    const val STEPN = "STEPN"
    const val SENCHA_EXCHANGE = "SENCHA EXCHANGE"
    const val SAROS = "SAROS"
    const val ENGLISH_AUCTION_AUCTION = "ENGLISH_AUCTION_AUCTION"
    const val FOXY = "FOXY"
    const val FOXY_STAKING = "FOXY_STAKING"
    const val ZETA = "ZETA"
    const val HADESWAP = "HADESWAP"
  }
}