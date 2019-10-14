package com.lethalskillzz.converter.ui.main

import com.lethalskillzz.converter.core.base.viewmodel.AppViewModel
import com.lethalskillzz.converter.data.interactor.RatesInteractor
import javax.inject.Inject

class MainViewModel @Inject constructor(private val ratesInteractor: RatesInteractor) : AppViewModel() {

}