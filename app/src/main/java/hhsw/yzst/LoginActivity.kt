package hhsw.yzst

import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import hhsw.util.ActiivtyStack
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity

/**
 * 登录
 */
class LoginActivity : AppCompatActivity() {
    companion object {
        var loginActivity: Activity? = null
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        window.statusBarColor = Color.WHITE
        ActiivtyStack.getScreenManager().pushActivity(this)
        initView()
    }

    private fun initView() {
        loginActivity = this
        close.setOnClickListener { finish() }
        uImg.setImageURI("https://i03piccdn.sogoucdn.com/3c28af542f2d49f7-fe9c78d2ff4ac332-e0dbc0ff02ba5632b59b775d435f572a_qq")
        phone.setSelection(phone.text.length)
        login.setOnClickListener {
            startActivity<MainActivity>()
            overridePendingTransition(R.anim.activity_fade, R.anim.activity_hold)
            finish()
        }
        register.setOnClickListener { startActivity<RegisterActivity>("phone" to phone.text.toString()) }
        forget.setOnClickListener { startActivity<ForgetActivity>("phone" to phone.text.toString()) }
    }

    override fun onDestroy() {
        super.onDestroy()
        ActiivtyStack.getScreenManager().popActivity(this)
    }
}
