package hhsw.yzst

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import hhsw.util.ActiivtyStack
import kotlinx.android.synthetic.main.activity_register_pwd.*
import org.jetbrains.anko.startActivity

/**
 * 注册(填写密码)
 */
class RegisterPwdActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_pwd)
        ActiivtyStack.getScreenManager().pushActivity(this)
        initView()
    }

    private fun initView() {
        back.setOnClickListener { finish() }
        phone.text=intent.getStringExtra("phone")
        next.setOnClickListener {
            startActivity<RegisterIdentityActivity>()
            overridePendingTransition(R.anim.activity_fade, R.anim.activity_hold)
            finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        ActiivtyStack.getScreenManager().popActivity(this)
    }
}
