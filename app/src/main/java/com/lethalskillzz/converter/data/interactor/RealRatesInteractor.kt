package com.lethalskillzz.converter.data.interactor

import com.lethalskillzz.converter.data.model.RateList
import com.lethalskillzz.converter.data.service.RatesService
import io.reactivex.Single
import javax.inject.Inject

class RealRatesInteractor @Inject constructor(private val ratesService: RatesService) : RatesInteractor {
  override fun getRates(base: String): Single<RateList> {
    return ratesService.getRates(base)
  }
}