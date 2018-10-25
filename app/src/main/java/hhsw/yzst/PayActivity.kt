package hhsw.yzst

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import hhsw.adapter.PayAdapter
import hhsw.util.ActiivtyStack
import kotlinx.android.synthetic.main.activity_pay.*
import org.jetbrains.anko.startActivity
import java.util.ArrayList

/**
 * 在线交费
 */
class PayActivity : AppCompatActivity() {
    var payList=ArrayList<String>()
    lateinit var adapter:PayAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pay)
        ActiivtyStack.getScreenManager().pushActivity(this)
        initView()
        initData()
    }

    fun initView(){
        back.setOnClickListener { finish() }
        uImg.setImageURI("https://i03piccdn.sogoucdn.com/3c28af542f2d49f7-fe9c78d2ff4ac332-e0dbc0ff02ba5632b59b775d435f572a_qq")
        number.setSelection(number.text.length)
        number.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (number.text.toString()=="15291879667")
                    name.visibility=View.VISIBLE
                else
                    name.visibility=View.GONE

            }

        })

        adapter=PayAdapter(payList)
        recyclerView.layoutManager=GridLayoutManager(this,3)
        recyclerView.adapter=adapter


        search.setOnClickListener { startActivity<SearchActivity>() }
        record.setOnClickListener { startActivity<RecordActivity>() }
    }

    private fun initData(){
        payList.add("10元")
        payList.add("20元")
        payList.add("30元")
        payList.add("50元")
        payList.add("100元")
        payList.add("200元")
        payList.add("300元")
        payList.add("500元")
        adapter.notifyDataSetChanged()
    }

    override fun onDestroy() {
        super.onDestroy()
        ActiivtyStack.getScreenManager().popActivity(this)
    }
}
