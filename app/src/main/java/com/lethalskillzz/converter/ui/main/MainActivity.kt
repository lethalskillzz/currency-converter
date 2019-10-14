package com.lethalskillzz.converter.ui.main

import android.Manifest
import android.app.PendingIntent.getActivity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.lethalskillzz.converter.R
import com.lethalskillzz.converter.core.base.activity.AppActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.dimen
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
  }
}