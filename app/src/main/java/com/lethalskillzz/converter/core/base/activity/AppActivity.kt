package com.lethalskillzz.converter.core.base.activity

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import com.lethalskillzz.converter.core.base.viewmodel.AppViewModel
import kotlin.properties.Delegates

abstract class AppActivity<ViewModel : AppViewModel, DataBinding : ViewDataBinding> : BaseActivity<DataBinding>() {

  protected var viewModel: ViewModel by Delegates.notNull()

  /**
   * Override to create and set viewModel
   * @return view model instance
   */
  protected abstract fun createViewModel(): ViewModel

  /**
   * Override to set viewModel to dataBinding
   */
  protected abstract fun setViewModel(binding: DataBinding, viewModel: ViewModel)

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    viewModel = createViewModel()
    setViewModel(dataBinding, viewModel)
  }
}