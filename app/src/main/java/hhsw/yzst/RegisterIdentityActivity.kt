package hhsw.yzst

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import hhsw.util.ActiivtyStack
import kotlinx.android.synthetic.main.activity_register_identity.*
import org.jetbrains.anko.startActivity

/**
 * 注册(身份验证)
 */
class RegisterIdentityActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_identity)
        ActiivtyStack.getScreenManager().pushActivity(this)
        initView()
    }

    private fun initView() {
        back.setOnClickListener { finish() }
        submit.setOnClickListener {
            startActivity<MainActivity>()
            overridePendingTransition(R.anim.activity_fade, R.anim.activity_hold)
            finish()
            LoginActivity.loginActivity!!.finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        ActiivtyStack.getScreenManager().popActivity(this)
    }
}
