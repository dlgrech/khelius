package com.dgsd.khelius.cli.name

import com.dgsd.khelius.cli.util.newOkHttpClient
import com.dgsd.khelius.name.NameApi
import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.requireObject
import com.github.ajalt.clikt.core.subcommands
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

/**
 * Parent command for functionality related to the Helius Balance API
 */
class NameCommand private constructor() : CliktCommand(
  name = "name",
  help = "Interact with the Helius name API"
) {

  private val apiKey by requireObject<String>()

  override fun run() {
    currentContext.obj = NameApi(apiKey, newOkHttpClient())
  }

  companion object {

    fun create(): NameCommand {
      return NameCommand().subcommands(
        GetNamesCommand()
      )
    }
  }
}