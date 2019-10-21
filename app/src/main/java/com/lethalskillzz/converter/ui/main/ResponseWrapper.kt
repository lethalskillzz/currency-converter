package com.lethalskillzz.converter.ui.main

import com.lethalskillzz.converter.core.base.activity.SnackBarMessage
import com.lethalskillzz.converter.data.model.Currency

data class ResponseWrapper(
  val currencies: ArrayList<Currency>?,
  val errorMessage: SnackBarMessage?
)