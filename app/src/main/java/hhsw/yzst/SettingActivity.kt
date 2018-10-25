package hhsw.yzst

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import hhsw.util.ActiivtyStack
import hhsw.util.LogOutDialog
import kotlinx.android.synthetic.main.activity_setting.*
import org.jetbrains.anko.startActivity

/**
 * 设置
 */
class SettingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)
        ActiivtyStack.getScreenManager().pushActivity(this)
        initView()
    }

    fun initView() {
        back.setOnClickListener { finish() }
        var p = "15291879667"
        var c = p.substring(3, 9)
        phone.text = p.replace(c, "******")
        updatePhone.setOnClickListener { startActivity<UpdatePhoneActivity>("phone" to phone.text.toString()) }
        updatePwd.setOnClickListener { startActivity<UpdatePwdActivity>() }

        logOut.setOnClickListener {
            var dialog = LogOutDialog(this)
            dialog.show()
            dialog.yes!!.setOnClickListener {
                startActivity<LoginActivity>()
                finish()
                MainActivity.mainActivity!!.finish()
            }
            var dm = DisplayMetrics()
            windowManager.defaultDisplay.getMetrics(dm)
            dialog.window.setLayout(dm.widthPixels, dialog.window.attributes.height)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        ActiivtyStack.getScreenManager().popActivity(this)
    }
}
