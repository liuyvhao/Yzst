package hhsw.yzst

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import hhsw.util.ActiivtyStack
import hhsw.util.CameraDialog
import kotlinx.android.synthetic.main.activity_personal.*
import org.jetbrains.anko.startActivity

/**
 * 个人信息
 */
class PersonalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal)
        ActiivtyStack.getScreenManager().pushActivity(this)
        initView()
    }

    fun initView(){
        back.setOnClickListener { finish() }
        uImg.setImageURI("https://i03piccdn.sogoucdn.com/3c28af542f2d49f7-fe9c78d2ff4ac332-e0dbc0ff02ba5632b59b775d435f572a_qq")
        name.text="刘宇豪"
        var n="610111199602022055"
        var i=n.substring(6,14)
        identity.text=n.replace(i,"********")
        var p="15291879667"
        var c=p.substring(3,9)
        phone.text=p.replace(c,"******")

        img.setOnClickListener { CameraDialog(this).show() }
        service.setOnClickListener { startActivity<ServiceActivity>() }
    }

    override fun onDestroy() {
        super.onDestroy()
        ActiivtyStack.getScreenManager().popActivity(this)
    }
}
