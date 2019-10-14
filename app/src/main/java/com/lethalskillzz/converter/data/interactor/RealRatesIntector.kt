package com.lethalskillzz.converter.data.interactor

import com.lethalskillzz.converter.data.service.RatesService
import io.reactivex.Single
import javax.inject.Inject

class RealRatesIntector @Inject constructor(private val ratesService: RatesService) {

  fun getRates(base: String): Single<RateList> {
    return ratesService.getRates(base)
  }
}