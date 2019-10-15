package com.lethalskillzz.converter.di.modules

import com.lethalskillzz.converter.data.interactor.RatesInteractor
import com.lethalskillzz.converter.data.interactor.RealRatesInteractor
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {
  @Binds
  internal abstract fun bindRatesInteractor(realRatesIntector: RealRatesInteractor): RatesInteractor
}