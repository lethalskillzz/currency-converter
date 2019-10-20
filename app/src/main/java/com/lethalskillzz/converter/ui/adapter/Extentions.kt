package com.lethalskillzz.converter.ui.adapter

import android.content.Context
import java.util.Locale

fun Float.format() : String = String.format(Locale.getDefault(), "%.2f", this)

fun getCurrencyNameResId(context: Context, symbol: String) =
    context.resources.getIdentifier("currency_name_$symbol", "string",
        context.packageName)

fun getCurrencyFlagResId(context: Context, symbol: String) = context.resources.getIdentifier(
    "ic_" + symbol + "_flag", "drawable", context.packageName)