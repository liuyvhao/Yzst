package hhsw.util

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Gravity
import hhsw.yzst.R
import kotlinx.android.synthetic.main.dialog_pay.*

class PayDialog(context: Context) : Dialog(context, R.style.ActionSheetDialogStyle) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_pay)
        this.window.setGravity(Gravity.BOTTOM)
        close.setOnClickListener { dismiss() }
    }
}