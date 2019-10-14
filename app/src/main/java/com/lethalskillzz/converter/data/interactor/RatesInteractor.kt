package com.lethalskillzz.converter.data.interactor

import io.reactivex.Single

interface RatesInteractor {

  fun getRates(base: String): Single<RateList>

}