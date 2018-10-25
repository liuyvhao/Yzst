package hhsw.yzst

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import hhsw.util.ActiivtyStack
import kotlinx.android.synthetic.main.activity_bind_house.*

/**
 * 我的绑定
 */
class BindHouseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bind_house)
        ActiivtyStack.getScreenManager().pushActivity(this)
        initView()
    }

    fun initView(){
        back.setOnClickListener { finish() }
    }

    override fun onDestroy() {
        super.onDestroy()
        ActiivtyStack.getScreenManager().popActivity(this)
    }
}
