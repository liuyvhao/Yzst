package hhsw.yzst

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import hhsw.util.ActiivtyStack
import kotlinx.android.synthetic.main.activity_update_phone.*
import org.jetbrains.anko.startActivity

/**
 * 更换手机号
 */
class UpdatePhoneActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_phone)
        ActiivtyStack.getScreenManager().pushActivity(this)
        initView()
    }

    fun initView(){
        back.setOnClickListener { finish() }
        phone.text=intent.getStringExtra("phone")
        next.setOnClickListener {
            startActivity<UpdatePhone2Activity>()
            overridePendingTransition(R.anim.activity_fade,R.anim.activity_hold)
            finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        ActiivtyStack.getScreenManager().popActivity(this)
    }
}
