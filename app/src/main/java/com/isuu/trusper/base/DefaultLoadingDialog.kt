package com.isuu.trusper.base

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import com.isuu.trusper.R

class DefaultLoadingDialog(context: Context) : Dialog(context, R.style.DefaultLoadingDialog) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_loading_default)
        setCanceledOnTouchOutside(false)
        setCancelable(false)
    }
}