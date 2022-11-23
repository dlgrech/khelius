package com.dgsd.khelius.transactions.factory

import com.dgsd.khelius.transactions.model.ProgramInfo
import com.dgsd.khelius.transactions.model.SwapEventInfo
import com.dgsd.khelius.transactions.response.EnrichedTransactionResponseBody.EventResponseBody.SwapEventResponseBody

/**
 * Maps a raw json response object into a higher-level model object exposed by the library
 */
internal object SwapEventFactory {

  fun create(
    response: SwapEventResponseBody
  ): SwapEventInfo {
    return SwapEventInfo(
      tokenInputs = response.tokenInputs.orEmpty().map(TokenAmountFactory::create),
      tokenOutputs = response.tokenInputs.orEmpty().map(TokenAmountFactory::create),
      tokenFees = response.tokenInputs.orEmpty().map(TokenAmountFactory::create),
      nativeInput = create(response.nativeInput),
      nativeOutput = create(response.nativeInput),
      nativeFees = response.nativeFees.orEmpty().map(::create),
      innerSwaps = response.innerSwaps.orEmpty().map(::create),
    )
  }

  private fun create(
    response: SwapEventResponseBody.NativeAmountResponseBody
  ): SwapEventInfo.NativeAmount {
    return SwapEventInfo.NativeAmount(
      response.account,
      response.amount
    )
  }

  private fun create(
    response: SwapEventResponseBody.InnerSwapResponseBody
  ): SwapEventInfo.InnerSwap {
    return SwapEventInfo.InnerSwap(
      tokenInputs = response.tokenInputs.orEmpty().map(TokenTransferFactory::create),
      tokenOutputs = response.tokenOutputs.orEmpty().map(TokenTransferFactory::create),
      tokenFees = response.tokenFees.orEmpty().map(TokenTransferFactory::create),
      nativeFees = response.nativeFees.orEmpty().map(NativeTransferFactory::create),
      programInfo = response.programInfo?.let(::create),
    )
  }

  private fun create(
    response: SwapEventResponseBody.InnerSwapResponseBody.ProgramInfoResponseBody
  ): ProgramInfo {
    return ProgramInfo(
      account = response.account,
      source = TransactionSourceFactory.create(response.source),
      programName = response.programName,
      instructionName = response.instructionName,
    )
  }
}