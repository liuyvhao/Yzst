package hhsw.yzst

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import hhsw.adapter.RecordAdapter
import hhsw.pojo.Record
import hhsw.util.ActiivtyStack
import kotlinx.android.synthetic.main.activity_record.*
import java.util.ArrayList

/**
 * 交费记录
 */
class RecordActivity : AppCompatActivity() {
    var recordList = ArrayList<Record>()
    lateinit var adapter: RecordAdapter
    var mCurrentPosition = 0
    var mSuspensionHeight = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_record)
        ActiivtyStack.getScreenManager().pushActivity(this)
        initView()
        initData()
    }

    fun initView() {
        back.setOnClickListener { finish() }
        adapter = RecordAdapter(recordList)
        var linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = adapter
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                var view = linearLayoutManager.findViewByPosition(mCurrentPosition + 1);

                if (recordList[mCurrentPosition].year!=recordList[mCurrentPosition+1].year){
                    if (view!!.top <= mSuspensionHeight) {
                        record_title.y = -(mSuspensionHeight - view!!.top).toFloat()
                    } else {
                        record_title.y = 0f
                    }
                }

                if (mCurrentPosition != linearLayoutManager.findFirstVisibleItemPosition()) {
                    mCurrentPosition = linearLayoutManager.findFirstVisibleItemPosition()
                    record_title.y = 0f

                    year.text=recordList[mCurrentPosition].year
                    water.text=recordList[mCurrentPosition].water
                    pay.text=recordList[mCurrentPosition].pay

                }

            }

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                mSuspensionHeight = record_title.height
            }
        })

    }

    private fun initData() {
        for (i in 0..4) {
            var year = ""
            when (i) {
                0 -> year = "今年"
                1 -> year = "2017年"
                2 -> year = "2016年"
                3 -> year = "2015年"
                4 -> year = "2014年"
            }
            recordList.add(Record(year, "4652L", "￥516.66", "https://i04picsos.sogoucdn.com/3aae2250e6ac3c6b", "张易售水厅-线下支付", "今天 08:53", "￥200.0"))
            recordList.add(Record(year, "4652L", "￥516.66", "https://i03picsos.sogoucdn.com/241e7c4cb211ab94", "在线支付时间:2018-08-25", "8月25日 13:13", "￥250.0"))
            recordList.add(Record(year, "4652L", "￥516.66", "https://i04picsos.sogoucdn.com/238173ca960b2fe5", "售水机08号:2018-06-15", "6月15日 10:08", "￥300.0"))
            recordList.add(Record(year, "4652L", "￥516.66", "https://i03picsos.sogoucdn.com/241e7c4cb211ab94", "在线支付时间:2018-03-26", "3月26日 12:28", "￥100.0"))
        }
        adapter.notifyDataSetChanged()

        if (recordList.size!=0){
            year.text=recordList[mCurrentPosition].year
            water.text=recordList[mCurrentPosition].water
            pay.text=recordList[mCurrentPosition].pay
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        ActiivtyStack.getScreenManager().popActivity(this)
    }
}
