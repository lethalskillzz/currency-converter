package com.lethalskillzz.converter.di.modules

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {

  @Binds
  abstract fun bindApplicationContext(application: Application): Context
}