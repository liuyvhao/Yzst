package hhsw.yzst

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import hhsw.util.ActiivtyStack
import kotlinx.android.synthetic.main.activity_forget.*
import org.jetbrains.anko.startActivity

/**
 * 忘记密码(短信验证)
 */
class ForgetActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget)
        ActiivtyStack.getScreenManager().pushActivity(this)
        initView()
    }

    private fun initView() {
        back.setOnClickListener { finish() }
        phone.setText(intent.getStringExtra("phone"))
        phone.setSelection(phone.text.length)
        next.setOnClickListener {
            startActivity<ForgetUpdateActivity>("phone" to phone.text.toString())
            overridePendingTransition(R.anim.activity_fade,R.anim.activity_hold)
            finish()
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        ActiivtyStack.getScreenManager().popActivity(this)
    }
}
