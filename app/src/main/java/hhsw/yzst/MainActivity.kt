package hhsw.yzst

import android.Manifest
import android.app.Activity
import android.app.TabActivity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.view.KeyEvent
import android.widget.RadioGroup
import android.widget.TabHost
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : TabActivity(), RadioGroup.OnCheckedChangeListener {
    lateinit var mTabHost: TabHost
    //点击关闭的初始时间
    private var exitTime: Long = 0

    companion object {
        var mainActivity: Activity? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.READ_EXTERNAL_STORAGE), 10)
        }
        mainActivity = this


        //实例化选项卡
        mTabHost = this.tabHost
        //添加选项卡
        mTabHost?.addTab(mTabHost?.newTabSpec("home")?.setIndicator("home")
                ?.setContent(Intent(this, HomeActivity::class.java)))

        mTabHost?.addTab(mTabHost?.newTabSpec("webSite")?.setIndicator("webSite")
                ?.setContent(Intent(this, WebsiteActivity::class.java)))

        mTabHost?.addTab(mTabHost?.newTabSpec("center")?.setIndicator("center")
                ?.setContent(Intent(this, CenterActivity::class.java)))

        radioGroup.setOnCheckedChangeListener(this)
        radioGroup.check(R.id.home)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        when (checkedId) {
            R.id.home -> {
                window.statusBarColor = resources.getColor(R.color.colorPrimary)
                mTabHost?.setCurrentTabByTag("home")
            }
            R.id.webSite -> {
                window.statusBarColor = Color.WHITE
                mTabHost?.setCurrentTabByTag("webSite")
            }
            R.id.center -> {
                window.statusBarColor = resources.getColor(R.color.colorPrimary)
                mTabHost?.setCurrentTabByTag("center")
            }
        }
    }


    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        if (requestCode == 10) {

        } else
            super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun dispatchKeyEvent(event: KeyEvent): Boolean {
        if (event.keyCode == KeyEvent.KEYCODE_BACK
                && event.action == KeyEvent.ACTION_DOWN
                && event.repeatCount == 0) {
            //具体的操作代码
            if (System.currentTimeMillis() - exitTime > 2000) {
                toast("再次点击退出！")
                exitTime = System.currentTimeMillis()
            } else {
                finish()
            }
        }
        return true
    }
}
