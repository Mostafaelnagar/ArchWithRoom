package com.structure.base_mvvm.presentation.base.utils

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.structure.base_mvvm.presentation.R
import com.tapadoo.alerter.Alerter

fun showMessage(context: Context, message: String?) {
  Toast.makeText(
    context,
    message ?: context.resources.getString(R.string.some_error),
    Toast.LENGTH_SHORT
  )
    .show()
}

fun showNoInternetAlert(activity: Activity) {
  Alerter.create(activity)
    .setTitle(activity.resources.getString(R.string.connection_error))
    .setText(activity.resources.getString(R.string.no_internet))
    .setIcon(R.drawable.ic_no_internet)
    .setBackgroundColorRes(R.color.red)
    .enableClickAnimation(true)
    .enableSwipeToDismiss()
    .show()
}

fun showNoApiErrorAlert(activity: Activity, message: String) {
  Alerter.create(activity)
    .setText(message)
    .setIcon(R.drawable.ic_api_warning)
    .setBackgroundColorRes(R.color.red)
    .enableClickAnimation(true)
    .enableSwipeToDismiss()
    .show()
}

fun showLoadingDialog(activity: Activity?, hint: String?): Dialog? {
  if (activity == null || activity.isFinishing) {
    return null
  }
  val progressDialog = Dialog(activity)
  progressDialog.show()
  if (progressDialog.window != null) {
    progressDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
  }
  progressDialog.setContentView(R.layout.progress_dialog)
  val tvHint = progressDialog.findViewById<TextView>(R.id.tv_hint)
  if (hint != null && !hint.isEmpty()) {
    tvHint.visibility = View.VISIBLE
    tvHint.text = hint
  } else {
    tvHint.visibility = View.GONE
  }

  progressDialog.setCancelable(false)
  progressDialog.setCanceledOnTouchOutside(false)
  progressDialog.show()

  return progressDialog
}

fun hideLoadingDialog(mProgressDialog: Dialog?, activity: Activity?) {
  if (activity != null && !activity.isFinishing && mProgressDialog != null && mProgressDialog.isShowing) {
    mProgressDialog.dismiss()
  }
}
