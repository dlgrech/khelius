package com.dgsd.khelius.name.factory

import com.dgsd.khelius.name.model.NamesSummary
import com.dgsd.khelius.name.response.GetNamesResponseBody

/**
 * Maps a raw json response object into a higher-level model object exposed by the library
 */
internal object NamesFactory {

  fun create(
    account: String,
    response: GetNamesResponseBody
  ): NamesSummary {
    return NamesSummary(
      account = account,
      names = response.domains.orEmpty()
    )
  }
}