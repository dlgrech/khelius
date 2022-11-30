package com.dgsd.khelius.nft.model

data class Nft(
  val name: String,
  val tokenAddress: String,
  val collectionName: String?,
  val collectionAddress: String,
  val imageUrl: String?,
  val traits: List<NftTrait>,
)
