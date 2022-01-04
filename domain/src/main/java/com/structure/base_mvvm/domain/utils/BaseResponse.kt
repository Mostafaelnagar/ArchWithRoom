package com.structure.base_mvvm.domain.utils

data class BaseResponse<T>(
  val data: T,
  val status_code: Int,
  val success: Int,
  val status_message: String = "",
)