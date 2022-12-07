<h1 align="center">kHelius - Kotlin library for Helius</h1>

kHelius is a kotlin library for interacting the various [Helius](https://docs.helius.xyz/) API endpoints.

It's intended to be used in any Kotlin JVM environment (such as on Android)

### CLI Usage

The repo contains a `khelius-cli` module which exposes functionality of the library for use as a CLI.

There is a top-level script - [`khelius.sh`](https://github.com/dlgrech/khelius/tree/main/khelius.sh) - which can be used to run various commands.

See the [`khelius-cli`](https://github.com/dlgrech/khelius/tree/main/khelius-cli) module for more info/examples.

### Quickstart

**Grab native SOL balance of an account**

```kotlin
val balanceApi = BalanceApi("HELIUS_API_KEY")
val balanceSummary = balanceApi.getBalanceSummary("ACCOUNT_HASH")

println(balanceSummary.nativeBalance)
```

**Grab Solana Name Services (SNS) names of an account**

```kotlin
val nameApi = NameApi("HELIUS_API_KEY")
val namesSummary = nameApi.getNames("ACCOUNT_HASH")

println(namesSummary.names)
```

**Grab NFTs for an account**

```kotlin
val nftApi = NftApi("HELIUS_API_KEY")
val nftSummary = nftApi.getNfts("ACCOUNT_HASH")

println(nftSummary.nfts)
```

**Grab enhanced transaction history**

```kotlin
val transactionsApi = EnhancedTransactionsApi("HELIUS_API_KEY")
val transactions = transactionsApi.getTransactionHistory("ACCOUNT_HASH")

for (transaction in transactions) {
  println(transaction.signature)
}
```

### Installation

The library is split into different top-level gradle targets, depending on what parts of the API you need to access:

```groovy
implementation "io.github.dlgrech:khelius-balance:<LATEST-VERSION>"
implementation "io.github.dlgrech:khelius-name:<LATEST-VERSION>"
implementation "io.github.dlgrech:khelius-nft:<LATEST-VERSION>"
implementation "io.github.dlgrech:khelius-transactions:<LATEST-VERSION>"
```

The latest version can be grabbed by [looking on maven central](https://search.maven.org/search?q=io.github.dlgrech)