package com.lethalskillzz.converter.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.lethalskillzz.converter.core.base.viewmodel.AppViewModelFactory
import com.lethalskillzz.converter.di.ViewModelKey
import com.lethalskillzz.converter.ui.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * All ViewModel classes that uses Dagger2 injection, must be declared here to support constructor injection,
 * otherwise app will give following exception on runtime access:
 * IllegalArgumentException: "unknown model call class"
 */

@Module
abstract class ViewModelModule {
  @Binds
  abstract fun provideViewModelFactory(factory: AppViewModelFactory): ViewModelProvider.Factory

  @Binds
  @IntoMap
  @ViewModelKey(MainViewModel::class)
  abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel
}