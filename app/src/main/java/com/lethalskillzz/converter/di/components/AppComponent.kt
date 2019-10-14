package com.lethalskillzz.converter.di.components

import android.app.Application
import com.lethalskillzz.converter.core.App
import com.lethalskillzz.converter.di.builders.ActivityBuilder
import com.lethalskillzz.converter.di.modules.AppModule
import com.lethalskillzz.converter.di.modules.RepositoryModule
import com.lethalskillzz.converter.di.modules.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidInjectionModule::class,
      AppModule::class,
      ActivityBuilder::class,
      ViewModelModule::class,
      RepositoryModule::class]
)
interface AppComponent {

  fun inject(app: App)

  @Component.Builder
  interface Builder {

    @BindsInstance
    fun application(application: Application): Builder

    fun build(): AppComponent
  }
}