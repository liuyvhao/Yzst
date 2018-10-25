package hhsw.yzst

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import hhsw.util.ActiivtyStack
import kotlinx.android.synthetic.main.activity_search.*
import java.util.ArrayList

/**
 * 水费查询
 */
class SearchActivity : AppCompatActivity() {
    var xVals = ArrayList<String>()
    var yVals = ArrayList<Entry>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        ActiivtyStack.getScreenManager().pushActivity(this)
        initView()
        initData()
    }

    fun initView() {
        back.setOnClickListener { finish() }

        lineChart.setTouchEnabled(false)
        lineChart.xAxis.setDrawGridLines(false)
        lineChart.axisRight.setDrawGridLines(false)
        lineChart.axisLeft.setDrawGridLines(true)
        lineChart.axisLeft.enableGridDashedLine(10f, 10f, 0f)
        lineChart.axisRight.isEnabled = false
    }

    private fun initData() {
        xVals.add("6月")
        xVals.add("7月")
        xVals.add("8月")
        xVals.add("9月")
        xVals.add("10月")

        yVals.add(Entry(0f, 120f))
        yVals.add(Entry(1f, 150f))
        yVals.add(Entry(2f, 220f))
        yVals.add(Entry(3f, 160f))
        yVals.add(Entry(4f, 250f))

        var xAxis = lineChart.xAxis
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.setLabelCount(xVals.size, true)
        xAxis.setValueFormatter { value, axis ->
            return@setValueFormatter xVals[value.toInt() % xVals.size]
        }
        xAxis.setAvoidFirstLastClipping(false)

        var dataSet = LineDataSet(yVals, "金额")
        dataSet.color = resources.getColor(R.color.colorPrimary)
        dataSet.setDrawFilled(true)
        dataSet.valueTextSize = 10f
        var data = LineData(dataSet)
        lineChart.data = data

        lineChart.description.text = "月使用额"
        lineChart.animateY(500)
    }

    override fun onDestroy() {
        super.onDestroy()
        ActiivtyStack.getScreenManager().popActivity(this)
    }
}
