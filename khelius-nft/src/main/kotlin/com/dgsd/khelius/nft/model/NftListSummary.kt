package com.dgsd.khelius.nft.model

data class NftListSummary(
  val numberOfPages: Int,
  val nfts: List<Nft>,
)