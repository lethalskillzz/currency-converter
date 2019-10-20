package com.lethalskillzz.converter.ui.main

import androidx.lifecycle.MutableLiveData
import com.lethalskillzz.converter.core.base.viewmodel.AppViewModel
import com.lethalskillzz.converter.data.interactor.CurrencyInteractor
import com.lethalskillzz.converter.data.model.Currency
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import android.content.Context
import com.lethalskillzz.converter.R
import com.lethalskillzz.converter.core.base.activity.SnackBarMessage
import retrofit2.HttpException
import java.io.IOException

class MainViewModel @Inject constructor(private val context: Context, private val currencyInteractor: CurrencyInteractor) : AppViewModel() {

  private var currentBase: String = ""
  private var isLoaded = false

  val responseLiveData by lazy { MutableLiveData<ResponseWrapper>() }
  val amountLiveData by lazy { MutableLiveData<Float>() }

  fun getRates(base: String, amount: Float) {
    if (base.equals(currentBase, ignoreCase = true)) {
      amountLiveData.postValue(amount)
    } else {
      currentBase = base.toUpperCase()
      compositeDisposable.add(
            currencyInteractor.getRates(base)
                .doOnSubscribe {
                  if (!isLoaded) {
                    showLoader.postValue(true)
                  }
                }
                .doAfterTerminate {
                  if (!isLoaded) {
                  showLoader.postValue(false)
                } }
                .delay(1, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .repeatUntil {!base.equals(currentBase, ignoreCase = true) }
                .subscribe({ rateList ->
                  val currencies = ArrayList<Currency>()
                  currencies.add(Currency(rateList.base, 1.0F))
                  currencies.addAll(rateList.rates.map { Currency(it.key, it.value) })
                  responseLiveData.postValue(ResponseWrapper(currencies, null))
                  isLoaded = true
                }, { throwable ->
                  responseLiveData.postValue(ResponseWrapper(null, getErrorMessage(throwable)))
                  throwable.printStackTrace()
                })
      )
    }
  }

  private fun getErrorMessage(throwable: Throwable): SnackBarMessage {
    if (throwable is HttpException) {
      return SnackBarMessage(context.getString(R.string.error_msg_server))
    }
    return if (throwable is IOException) {
      SnackBarMessage(context.getString(R.string.error_msg_network))
    } else {
      SnackBarMessage(context.getString(R.string.error_msg_network_generic))
    }
  }
}