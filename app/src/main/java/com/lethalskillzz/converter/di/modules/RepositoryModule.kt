package com.lethalskillzz.converter.di.modules

import com.lethalskillzz.converter.data.interactor.RatesInteractor
import com.lethalskillzz.converter.data.interactor.RealRatesIntector
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

  @Binds
  abstract fun bindRatesInteractor(realRatesIntector: RealRatesIntector): RatesInteractor
}