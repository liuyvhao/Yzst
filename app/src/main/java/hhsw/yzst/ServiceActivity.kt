package hhsw.yzst

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import hhsw.adapter.ServiceAdapter
import hhsw.util.ActiivtyStack
import kotlinx.android.synthetic.main.activity_service.*
import java.util.ArrayList

/**
 * 服务指南
 */
class ServiceActivity : AppCompatActivity() {
    var serviceList = ArrayList<String>()
    lateinit var adapter: ServiceAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)
        ActiivtyStack.getScreenManager().pushActivity(this)
        initView()
        initData()
    }

    fun initView() {
        back.setOnClickListener { finish() }

        adapter = ServiceAdapter(serviceList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    private fun initData(){
        serviceList.add("社会服务承诺书")
        serviceList.add("原州水投操作指南")
        serviceList.add("业务办理地址")
        serviceList.add("用水申请业务办理流程")
        serviceList.add("用水性质变更办理流程")
        serviceList.add("销售业务办理流程")
        serviceList.add("预存水费业务")
        serviceList.add("短信服务业务")

        adapter.notifyDataSetChanged()
    }

    override fun onDestroy() {
        super.onDestroy()
        ActiivtyStack.getScreenManager().popActivity(this)
    }
}
