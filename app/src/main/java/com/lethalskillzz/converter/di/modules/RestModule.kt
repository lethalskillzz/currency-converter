package com.lethalskillzz.converter.di.modules

import com.lethalskillzz.converter.data.service.RatesService
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
  internal fun providesRatesService(): RatesService {
    return Retrofit.Builder()
        .baseUrl(RatesService.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build().create(RatesService::class.java)
  }
}
