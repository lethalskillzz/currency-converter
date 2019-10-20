package com.lethalskillzz.converter.ui.adapter

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lethalskillzz.converter.data.model.Currency
import kotlinx.android.synthetic.main.item_currency.view.*
import kotlin.collections.ArrayList

class CurrencyViewHolder(itemView: View, private val onBaseChangedListener: OnBaseChangedListener) : RecyclerView.ViewHolder(
    itemView) {

  private var imageCurrencyFlag: ImageView = itemView.imageViewCurrencyFlag
  private var textCurrencySymbol: TextView = itemView.textViewCurrencySymbol
  private var textCurrencyName: TextView = itemView.textViewCurrencyName
  private var symbol: String = ""

  var editTextCurrencyAmount: EditText = itemView.editTextCurrencyAmount

  fun bind(onBindView: OnBindViewWrapper) {
    if (symbol != onBindView.currency.symbol) {
      setupViewHolder(onBindView.adapter, onBindView.currency, onBindView.symbolPosition)
      this.symbol = onBindView.currency.symbol
    }

    if (!editTextCurrencyAmount.isFocused) {
      editTextCurrencyAmount.setText((onBindView.currency.rate * onBindView.amount).format())
    }
  }

  private fun setupViewHolder(adapter: CurrencyAdapter, currency: Currency, symbolPosition: ArrayList<String>) {
    val symbol = currency.symbol.toLowerCase()
    val nameId = getCurrencyNameResId(itemView.context, symbol)
    val flagId = getCurrencyFlagResId(itemView.context, symbol)

    textCurrencySymbol.text = currency.symbol
    textCurrencyName.text = itemView.context.getString(nameId)
    imageCurrencyFlag.setImageResource(flagId)

    editTextCurrencyAmount.onFocusChangeListener = View.OnFocusChangeListener { _, hasFocus ->
      if (!hasFocus) {
        return@OnFocusChangeListener
      }
      layoutPosition.takeIf { it > 0 }?.also { currentPosition ->
        symbolPosition.removeAt(currentPosition).also {
          symbolPosition.add(0, it)
        }
        adapter.notifyItemMoved(currentPosition, 0)
      }
    }

    editTextCurrencyAmount.addTextChangedListener(object : TextWatcher {
      override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
      }

      override fun afterTextChanged(p0: Editable?) {
      }

      override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        if (editTextCurrencyAmount.isFocused) {
          onBaseChangedListener.onAmountChanged(symbol, s.toString().toFloat())
        }
      }

    })
  }
}