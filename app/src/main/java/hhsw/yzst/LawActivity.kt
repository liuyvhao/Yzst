package hhsw.yzst

import android.graphics.Canvas
import android.graphics.Rect
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import hhsw.adapter.LawAdapter
import hhsw.pojo.Law
import hhsw.util.ActiivtyStack
import kotlinx.android.synthetic.main.activity_law.*
import java.util.ArrayList

/**
 * 政府法规
 */
class LawActivity : AppCompatActivity() {
    var lawList = ArrayList<Law>()
    private lateinit var adapter: LawAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_law)
        ActiivtyStack.getScreenManager().pushActivity(this)
        initView()
        initData()
    }

    fun initView() {
        back.setOnClickListener { finish() }

        adapter = LawAdapter(lawList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        recyclerView.addItemDecoration(object : RecyclerView.ItemDecoration() {

            override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
                super.onDraw(c, parent, state)
                c.drawColor(resources.getColor(R.color.viewBg))
            }

            override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
                super.getItemOffsets(outRect, view, parent, state)
                outRect.set(0,5,0,5)
            }
        })
    }

    private fun initData() {
        lawList.add(Law("https://i04picsos.sogoucdn.com/a38baa75ebd10d0d", "固原市生活饮用水二次供水管理和卫生监督规定", "陕西省西安市人民政府;2004年8月15日;地方法律法规汇编", "今天 08:53"))
        lawList.add(Law("https://i04picsos.sogoucdn.com/a38baa75ebd10d0d", "宁夏省城市饮用水水源保护区环境保护条例", "陕西省人民政府;2002年3月28日;地方法律法规汇编", "昨天 11:20"))
        lawList.add(Law("https://i04picsos.sogoucdn.com/a38baa75ebd10d0d", "固原市城市饮用水水源保护区污染防治管理规定", "陕西省西安市人民政府;2004年8月15日;地方法律法规汇编", "9月28日 08:53"))
        lawList.add(Law("https://i04picsos.sogoucdn.com/a38baa75ebd10d0d", "固原市生活饮用水二次供水管理和卫生监督规定", "陕西省西安市人民政府;2004年8月15日;地方法律法规汇编", "8月16日 08:53"))
        lawList.add(Law("https://i04picsos.sogoucdn.com/a38baa75ebd10d0d", "宁夏省城市饮用水水源保护区环境保护条例", "陕西省西安市人民政府;2004年8月15日;地方法律法规汇编", "7月11日 08:53"))
        lawList.add(Law("https://i04picsos.sogoucdn.com/a38baa75ebd10d0d", "固原市城市饮用水水源保护区污染防治管理规定", "陕西省西安市人民政府;2004年8月15日;地方法律法规汇编", "7月03日 08:53"))
        lawList.add(Law("https://i04picsos.sogoucdn.com/a38baa75ebd10d0d", "固原市生活饮用水二次供水管理和卫生监督规定", "陕西省西安市人民政府;2004年8月15日;地方法律法规汇编", "6月18日 08:53"))

        adapter.notifyDataSetChanged()
    }

    override fun onDestroy() {
        super.onDestroy()
        ActiivtyStack.getScreenManager().popActivity(this)
    }
}
