package hhsw.yzst

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import hhsw.util.ActiivtyStack
import kotlinx.android.synthetic.main.activity_center.*
import org.jetbrains.anko.startActivity

/**
 * 我的
 */
class CenterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_center)
        ActiivtyStack.getScreenManager().pushActivity(this)
        initView()
    }

    private fun initView(){
        setting.setOnClickListener { startActivity<SettingActivity>() }
        personal.setOnClickListener { startActivity<PersonalActivity>() }
        uImg.setImageURI("https://i03piccdn.sogoucdn.com/3c28af542f2d49f7-fe9c78d2ff4ac332-e0dbc0ff02ba5632b59b775d435f572a_qq")
        name.text="刘宇豪"
        var p="15291879667"
        var c=p.substring(3,9)
        phone.text=p.replace(c,"******")
        bind.setOnClickListener { startActivity<BindHouseActivity>() }
        opinion.setOnClickListener { startActivity<OpinionActivity>() }

        search.setOnClickListener { startActivity<SearchActivity>() }
        record.setOnClickListener { startActivity<RecordActivity>() }
        service.setOnClickListener { startActivity<ServiceActivity>() }
    }

    override fun onDestroy() {
        super.onDestroy()
        ActiivtyStack.getScreenManager().popActivity(this)
    }
}
