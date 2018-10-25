package hhsw.util

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Gravity
import hhsw.yzst.R
import kotlinx.android.synthetic.main.dialog_camera.*

class CameraDialog(context: Context) : Dialog(context, R.style.ActionSheetDialogStyle) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_camera)
        var lp=window.attributes
        lp.y=20
        window.attributes=lp
        this.window.setGravity(Gravity.BOTTOM)
        cancel.setOnClickListener { dismiss() }
    }
}