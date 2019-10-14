package com.lethalskillzz.converter.data.interactor

import com.lethalskillzz.converter.data.model.RateList
import io.reactivex.Single

interface RatesInteractor {

  fun getRates(base: String): Single<RateList>

}