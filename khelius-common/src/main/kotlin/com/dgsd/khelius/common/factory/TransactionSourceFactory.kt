package com.dgsd.khelius.common.factory

import com.dgsd.khelius.common.model.TransactionSource
import com.dgsd.khelius.common.response.TransactionSourceResponse

/**
 * Maps a raw json response object into a higher-level model object exposed by the library
 */
object TransactionSourceFactory {

  @TransactionSourceResponse
  fun create(source: TransactionSource): String {
    return when (source) {
      TransactionSource.FORM_FUNCTION -> TransactionSourceResponse.EXCHANGE_ART
      TransactionSource.EXCHANGE_ART -> TransactionSourceResponse.EXCHANGE_ART
      TransactionSource.CANDY_MACHINE_V2 -> TransactionSourceResponse.CANDY_MACHINE_V2
      TransactionSource.CANDY_MACHINE_V1 -> TransactionSourceResponse.CANDY_MACHINE_V1
      TransactionSource.SOLANART -> TransactionSourceResponse.SOLANART
      TransactionSource.SOLSEA -> TransactionSourceResponse.SOLSEA
      TransactionSource.MAGIC_EDEN -> TransactionSourceResponse.MAGIC_EDEN
      TransactionSource.HOLAPLEX -> TransactionSourceResponse.HOLAPLEX
      TransactionSource.METAPLEX -> TransactionSourceResponse.METAPLEX
      TransactionSource.OPENSEA -> TransactionSourceResponse.OPENSEA
      TransactionSource.SOLANA_PROGRAM_LIBRARY -> TransactionSourceResponse.SOLANA_PROGRAM_LIBRARY
      TransactionSource.ANCHOR -> TransactionSourceResponse.ANCHOR
      TransactionSource.W_SOL -> TransactionSourceResponse.W_SOL
      TransactionSource.PHANTOM -> TransactionSourceResponse.PHANTOM
      TransactionSource.SYSTEM_PROGRAM -> TransactionSourceResponse.SYSTEM_PROGRAM
      TransactionSource.STAKE_PROGRAM -> TransactionSourceResponse.STAKE_PROGRAM
      TransactionSource.COINBASE -> TransactionSourceResponse.COINBASE
      TransactionSource.CORAL_CUBE -> TransactionSourceResponse.CORAL_CUBE
      TransactionSource.HEDGE -> TransactionSourceResponse.HEDGE
      TransactionSource.LAUNCH_MY_NFT -> TransactionSourceResponse.LAUNCH_MY_NFT
      TransactionSource.GEM_BANK -> TransactionSourceResponse.GEM_BANK
      TransactionSource.GEM_FARM -> TransactionSourceResponse.GEM_FARM
      TransactionSource.DEGODS -> TransactionSourceResponse.DEGODS
      TransactionSource.BLOCKSMITH_LABS -> TransactionSourceResponse.BLOCKSMITH_LABS
      TransactionSource.YAWWW -> TransactionSourceResponse.YAWWW
      TransactionSource.ATADIA -> TransactionSourceResponse.ATADIA
      TransactionSource.SOLPORT -> TransactionSourceResponse.SOLPORT
      TransactionSource.HYPERSPACE -> TransactionSourceResponse.HYPERSPACE
      TransactionSource.DIGITAL_EYES -> TransactionSourceResponse.DIGITAL_EYES
      TransactionSource.TENSOR -> TransactionSourceResponse.TENSOR
      TransactionSource.BIFROST -> TransactionSourceResponse.BIFROST
      TransactionSource.JUPITER -> TransactionSourceResponse.JUPITER
      TransactionSource.MERCURIAL_STABLE_SWAP -> TransactionSourceResponse.MERCURIAL_STABLE_SWAP
      TransactionSource.SABER -> TransactionSourceResponse.SABER
      TransactionSource.SERUM -> TransactionSourceResponse.SERUM
      TransactionSource.STEP_FINANCE -> TransactionSourceResponse.STEP_FINANCE
      TransactionSource.CROPPER -> TransactionSourceResponse.CROPPER
      TransactionSource.RAYDIUM -> TransactionSourceResponse.RAYDIUM
      TransactionSource.ALDRIN -> TransactionSourceResponse.ALDRIN
      TransactionSource.CREMA -> TransactionSourceResponse.CREMA
      TransactionSource.LIFINITY -> TransactionSourceResponse.LIFINITY
      TransactionSource.CYKURA -> TransactionSourceResponse.CYKURA
      TransactionSource.ORCA -> TransactionSourceResponse.ORCA
      TransactionSource.MARINADE -> TransactionSourceResponse.MARINADE
      TransactionSource.STEPN -> TransactionSourceResponse.STEPN
      TransactionSource.SENCHA_EXCHANGE -> TransactionSourceResponse.SENCHA_EXCHANGE
      TransactionSource.SAROS -> TransactionSourceResponse.SAROS
      TransactionSource.ENGLISH_AUCTION_AUCTION -> TransactionSourceResponse.ENGLISH_AUCTION_AUCTION
      TransactionSource.FOXY -> TransactionSourceResponse.FOXY
      TransactionSource.ZETA -> TransactionSourceResponse.ZETA
      TransactionSource.FOXY_STAKING -> TransactionSourceResponse.FOXY_STAKING
      TransactionSource.HADESWAP -> TransactionSourceResponse.HADESWAP
      TransactionSource.UNKNOWN -> TransactionSourceResponse.UNKNOWN
    }
  }

  fun create(@TransactionSourceResponse response: String): TransactionSource {
    return when (response) {
      TransactionSourceResponse.FORM_FUNCTION -> TransactionSource.EXCHANGE_ART
      TransactionSourceResponse.EXCHANGE_ART -> TransactionSource.EXCHANGE_ART
      TransactionSourceResponse.CANDY_MACHINE_V2 -> TransactionSource.CANDY_MACHINE_V2
      TransactionSourceResponse.CANDY_MACHINE_V1 -> TransactionSource.CANDY_MACHINE_V1
      TransactionSourceResponse.SOLANART -> TransactionSource.SOLANART
      TransactionSourceResponse.SOLSEA -> TransactionSource.SOLSEA
      TransactionSourceResponse.MAGIC_EDEN -> TransactionSource.MAGIC_EDEN
      TransactionSourceResponse.HOLAPLEX -> TransactionSource.HOLAPLEX
      TransactionSourceResponse.METAPLEX -> TransactionSource.METAPLEX
      TransactionSourceResponse.OPENSEA -> TransactionSource.OPENSEA
      TransactionSourceResponse.SOLANA_PROGRAM_LIBRARY -> TransactionSource.SOLANA_PROGRAM_LIBRARY
      TransactionSourceResponse.ANCHOR -> TransactionSource.ANCHOR
      TransactionSourceResponse.W_SOL -> TransactionSource.W_SOL
      TransactionSourceResponse.PHANTOM -> TransactionSource.PHANTOM
      TransactionSourceResponse.SYSTEM_PROGRAM -> TransactionSource.SYSTEM_PROGRAM
      TransactionSourceResponse.STAKE_PROGRAM -> TransactionSource.STAKE_PROGRAM
      TransactionSourceResponse.COINBASE -> TransactionSource.COINBASE
      TransactionSourceResponse.CORAL_CUBE -> TransactionSource.CORAL_CUBE
      TransactionSourceResponse.HEDGE -> TransactionSource.HEDGE
      TransactionSourceResponse.LAUNCH_MY_NFT -> TransactionSource.LAUNCH_MY_NFT
      TransactionSourceResponse.GEM_BANK -> TransactionSource.GEM_BANK
      TransactionSourceResponse.GEM_FARM -> TransactionSource.GEM_FARM
      TransactionSourceResponse.DEGODS -> TransactionSource.DEGODS
      TransactionSourceResponse.BLOCKSMITH_LABS -> TransactionSource.BLOCKSMITH_LABS
      TransactionSourceResponse.YAWWW -> TransactionSource.YAWWW
      TransactionSourceResponse.ATADIA -> TransactionSource.ATADIA
      TransactionSourceResponse.SOLPORT -> TransactionSource.SOLPORT
      TransactionSourceResponse.HYPERSPACE -> TransactionSource.HYPERSPACE
      TransactionSourceResponse.DIGITAL_EYES -> TransactionSource.DIGITAL_EYES
      TransactionSourceResponse.TENSOR -> TransactionSource.TENSOR
      TransactionSourceResponse.BIFROST -> TransactionSource.BIFROST
      TransactionSourceResponse.JUPITER -> TransactionSource.JUPITER
      TransactionSourceResponse.MERCURIAL_STABLE_SWAP -> TransactionSource.MERCURIAL_STABLE_SWAP
      TransactionSourceResponse.SABER -> TransactionSource.SABER
      TransactionSourceResponse.SERUM -> TransactionSource.SERUM
      TransactionSourceResponse.STEP_FINANCE -> TransactionSource.STEP_FINANCE
      TransactionSourceResponse.CROPPER -> TransactionSource.CROPPER
      TransactionSourceResponse.RAYDIUM -> TransactionSource.RAYDIUM
      TransactionSourceResponse.ALDRIN -> TransactionSource.ALDRIN
      TransactionSourceResponse.CREMA -> TransactionSource.CREMA
      TransactionSourceResponse.LIFINITY -> TransactionSource.LIFINITY
      TransactionSourceResponse.CYKURA -> TransactionSource.CYKURA
      TransactionSourceResponse.ORCA -> TransactionSource.ORCA
      TransactionSourceResponse.MARINADE -> TransactionSource.MARINADE
      TransactionSourceResponse.STEPN -> TransactionSource.STEPN
      TransactionSourceResponse.SENCHA_EXCHANGE -> TransactionSource.SENCHA_EXCHANGE
      TransactionSourceResponse.SAROS -> TransactionSource.SAROS
      TransactionSourceResponse.ENGLISH_AUCTION_AUCTION -> TransactionSource.ENGLISH_AUCTION_AUCTION
      TransactionSourceResponse.FOXY -> TransactionSource.FOXY
      TransactionSourceResponse.ZETA -> TransactionSource.ZETA
      TransactionSourceResponse.FOXY_STAKING -> TransactionSource.FOXY_STAKING
      TransactionSourceResponse.HADESWAP -> TransactionSource.HADESWAP
      else -> TransactionSource.UNKNOWN
    }
  }
}