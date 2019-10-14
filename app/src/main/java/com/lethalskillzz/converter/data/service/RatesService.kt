package com.lethalskillzz.converter.data.service

import com.lethalskillzz.converter.data.model.RateList
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface RatesService {

  companion object {
    const val BASE_URL = "https://revolut.duckdns.org"
  }

  @GET("/latest")
  fun getRates(@Query("base") base: String): Single<RateList>
}