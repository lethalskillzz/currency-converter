package com.lethalskillzz.converter.ui.main

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.lethalskillzz.converter.R
import com.lethalskillzz.converter.core.base.activity.AppActivity
import com.lethalskillzz.converter.databinding.ActivityMainBinding
import com.lethalskillzz.converter.ui.adapter.OnBaseChangedListener
import com.lethalskillzz.converter.ui.adapter.CurrencyAdapter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppActivity<MainViewModel, ActivityMainBinding>() {

  @Inject
  lateinit var factory: ViewModelProvider.Factory

  private lateinit var adapter: CurrencyAdapter

  override fun createViewModel(): MainViewModel = ViewModelProviders.of(getActivity(), factory).get(
      MainViewModel::class.java)

  override fun setViewModel(binding: ActivityMainBinding, viewModel: MainViewModel) {
    binding.viewModel = viewModel
  }

  override val layoutResourceId: Int
    get() = R.layout.activity_main

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    adapter = CurrencyAdapter(object : OnBaseChangedListener {
      override fun onAmountChanged(symbol: String, amount: Float) {
        viewModel.getRates(symbol, amount)
      }
    })

    setupView()

    setupViewModel()

    viewModel.getRates(DEFAULT_BASE, DEFAULT_AMOUNT)
  }

  private fun setupView() {
    textViewTitle.text = getText(R.string.title_main)
    recyclerViewCurrency.setHasFixedSize(true)
    recyclerViewCurrency.layoutManager = LinearLayoutManager(getContext())
  }

  private fun setupViewModel() {
    viewModel.showLoader.observe(getActivity(), Observer {
      if (it != null && it) showLoader()
      else hideLoader()
    })

    viewModel.responseLiveData.observe(getActivity(), Observer { response->
      if(response.errorMessage != null){
        Snackbar.make(root, response.errorMessage.text, Snackbar.LENGTH_LONG).show()
      } else {
        adapter.updateRates(requireNotNull(response.currencies))
        recyclerViewCurrency.adapter = adapter
      }
    })

    viewModel.amountLiveData.observe(getActivity(), Observer {
      adapter.updateAmount(requireNotNull(viewModel.amountLiveData.value))
    })
  }

  companion object {
    const val DEFAULT_BASE = "EUR"
    const val DEFAULT_AMOUNT = 1F
  }
}