package com.lethalskillzz.converter.di.builders

import com.lethalskillzz.converter.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * All Activity that have been injected, must be declared here,
 * otherwise app will give exception during run-time.
 *
 * Other components like Fragment will have BuilderModule as @ContributesAndroidInjector to parent activities
 *
 * App can give following exceptions during run-time:
 * 1. UninitializedPropertyAccessException: lateinit property has not been initialized
 * 2. IllegalArgumentException: No injector factory bound
 */

@Module
abstract class ActivityBuilder {

  @ContributesAndroidInjector
  abstract fun bindMainActivity(): MainActivity
}