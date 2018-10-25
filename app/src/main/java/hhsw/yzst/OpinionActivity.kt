package hhsw.yzst

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import hhsw.util.ActiivtyStack
import kotlinx.android.synthetic.main.activity_opinion.*

/**
 * 意见反馈
 */
class OpinionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opinion)
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
