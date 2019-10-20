package com.lethalskillzz.converter.data.interactor

import com.lethalskillzz.converter.data.model.CurrencyList
import io.reactivex.Single

interface CurrencyInteractor {
  fun getRates(base: String): Single<CurrencyList>
}