package com.lethalskillzz.converter.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lethalskillzz.converter.R
import com.lethalskillzz.converter.data.model.Currency
import java.util.*
import kotlin.collections.ArrayList

class CurrencyAdapter(private val onBaseChangedListener: OnBaseChangedListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

  private val symbolPosition = ArrayList<String>()
  private val symbolRate = HashMap<String, Currency>()

  private var amount = 1.0F

  fun updateRates(rates: ArrayList<Currency>) {
    if (symbolPosition.isEmpty()) {
      symbolPosition.addAll(rates.map { it.symbol })
    }

    for (rate in rates) {
      symbolRate[rate.symbol] = rate
    }

    notifyItemRangeChanged(0, symbolPosition.size - 1, amount)
  }

  fun updateAmount(amount: Float) {
    this.amount = amount

    notifyItemRangeChanged(0, symbolPosition.size - 1, amount)
  }

  private fun currencyAtPosition(pos: Int): Currency {
    return symbolRate[symbolPosition[pos]]!!
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
    return CurrencyViewHolder(LayoutInflater
        .from(parent.context)
        .inflate(R.layout.item_currency, parent, false), onBaseChangedListener)
  }

  override fun getItemCount(): Int {
    return symbolPosition.size
  }

  override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    (holder as CurrencyViewHolder).bind(OnBindViewWrapper(this, currencyAtPosition(position), symbolPosition, amount))
  }
}