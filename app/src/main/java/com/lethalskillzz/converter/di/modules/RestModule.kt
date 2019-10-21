package com.lethalskillzz.converter.di.modules

import com.lethalskillzz.converter.data.service.CurrencyService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RestModule {
  @Singleton
  @Provides
  internal fun providesRatesService(): CurrencyService {
    return Retrofit.Builder()
        .baseUrl(CurrencyService.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build().create(CurrencyService::class.java)
  }
}
