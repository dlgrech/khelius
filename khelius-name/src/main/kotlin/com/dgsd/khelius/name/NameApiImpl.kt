package com.dgsd.khelius.name

import com.dgsd.khelius.core.network.HeliusApi
import com.dgsd.khelius.name.factory.NamesFactory
import com.dgsd.khelius.name.model.NamesSummary
import com.dgsd.khelius.name.response.GetNamesResponseBody

private const val NAMES_REQUEST_PATH_TEMPLATE = "/v0/addresses/%s/names"

/**
 * Default implementation of the [NameApi] interface
 */
internal class NameApiImpl(
  private val heliusApi: HeliusApi
) : NameApi {

  override suspend fun getNames(account: String): NamesSummary {
    val requestPath = String.format(NAMES_REQUEST_PATH_TEMPLATE, account)

    val response = heliusApi.get(requestPath, GetNamesResponseBody::class.java)

    return NamesFactory.create(account, response)
  }
}