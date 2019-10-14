package com.lethalskillzz.converter.ui.main

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.lethalskillzz.converter.R
import com.lethalskillzz.converter.core.base.activity.AppActivity
import com.lethalskillzz.converter.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppActivity<MainViewModel, ActivityMainBinding>() {

  @Inject
  lateinit var factory: ViewModelProvider.Factory

  override fun createViewModel(): MainViewModel = ViewModelProviders.of(getActivity(), factory).get(
      MainViewModel::class.java)

  override fun setViewModel(binding: ActivityMainBinding, viewModel: MainViewModel) {
    binding.viewModel = viewModel
  }

  override val layoutResourceId: Int
    get() = R.layout.activity_main

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    recyclerViewRates.layoutManager = LinearLayoutManager(getContext())
    recyclerViewRates.setHasFixedSize(true)

    viewModel.showLoader.observe(getActivity(), Observer {
      if (it != null && it) showLoader()
      else hideLoader()
    })
  }
}