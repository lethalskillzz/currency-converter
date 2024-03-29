package com.lethalskillzz.converter.ui.adapter

import com.lethalskillzz.converter.data.model.Currency

data class OnBindViewWrapper(
  val adapter: CurrencyAdapter,
  val currency: Currency,
  val currencyPositions: ArrayList<String>,
  val amount: Float
)