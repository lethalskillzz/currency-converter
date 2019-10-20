package com.lethalskillzz.converter.data.interactor

import com.lethalskillzz.converter.data.model.CurrencyList
import com.lethalskillzz.converter.data.service.CurrencyService
import io.reactivex.Single
import javax.inject.Inject

class RealCurrencyInteractor @Inject constructor(private val currencyService: CurrencyService) : CurrencyInteractor {
  override fun getRates(base: String): Single<CurrencyList> {
    return currencyService.getRates(base)
  }
}