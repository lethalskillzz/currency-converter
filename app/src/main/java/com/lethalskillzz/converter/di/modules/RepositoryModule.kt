package com.lethalskillzz.converter.di.modules

import com.lethalskillzz.converter.data.interactor.CurrencyInteractor
import com.lethalskillzz.converter.data.interactor.RealCurrencyInteractor
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {
  @Binds
  internal abstract fun bindRatesInteractor(realCurrencyIntector: RealCurrencyInteractor): CurrencyInteractor
}