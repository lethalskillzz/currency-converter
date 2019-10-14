package com.lethalskillzz.converter.core.base.viewmodel

import androidx.lifecycle.ViewModel
import com.lethalskillzz.android.core.SingleLiveEvent
import io.reactivex.disposables.CompositeDisposable

abstract class AppViewModel : ViewModel() {
  internal val showLoader by lazy { SingleLiveEvent<Boolean>() }
  internal val toastMessage by lazy { SingleLiveEvent<String>() }

  internal val compositeDisposable by lazy { CompositeDisposable() }

  override fun onCleared() {
    super.onCleared()
    compositeDisposable.dispose()
  }
}