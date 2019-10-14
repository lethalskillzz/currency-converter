package com.lethalskillzz.converter.core.base.activity

data class SnackBarMessage(var message: String?, var messageType: Int = SNACK_BAR_NORMAL) {
  companion object {
    const val SNACK_BAR_SUCCESS = 1
    const val SNACK_BAR_ERROR = 0
    const val SNACK_BAR_NORMAL = 2
  }
}