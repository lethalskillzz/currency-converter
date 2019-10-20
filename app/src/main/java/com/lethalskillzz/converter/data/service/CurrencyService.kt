package com.lethalskillzz.converter.data.service

import com.lethalskillzz.converter.data.model.CurrencyList
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyService {

  companion object {
    const val BASE_URL = "https://revolut.duckdns.org"
  }

  @GET("/latest")
  fun getRates(@Query("base") base: String): Single<CurrencyList>
}