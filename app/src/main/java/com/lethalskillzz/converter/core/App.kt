package com.lethalskillzz.converter.core

import android.app.Activity
import android.content.Context
import androidx.multidex.MultiDexApplication
import com.lethalskillzz.converter.BuildConfig
import com.lethalskillzz.converter.R
import com.lethalskillzz.converter.di.components.DaggerAppComponent
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class App : MultiDexApplication(), HasActivityInjector {

  companion object {

    @get:Synchronized
    lateinit var instance: App

    fun getApp(activity: Activity): App {
      return activity.application as App
    }

    fun getApp(context: Context): App {
      return context.applicationContext as App
    }
  }

  @Inject
  lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>

  override fun activityInjector(): AndroidInjector<Activity> {
    return dispatchingActivityInjector
  }

  override fun onCreate() {
    super.onCreate()

    instance = this

    DaggerAppComponent.builder()
        .application(this)
        .build()
        .inject(this)

    Logger.addLogAdapter(object : AndroidLogAdapter(
        PrettyFormatStrategy.newBuilder()
            .showThreadInfo(true)
            .methodCount(3)
            .methodOffset(0)
            .tag(getString(R.string.app_name))
            .build()
    ) {
      override fun isLoggable(priority: Int, tag: String?): Boolean {
        return BuildConfig.DEBUG
      }
    })
  }
}