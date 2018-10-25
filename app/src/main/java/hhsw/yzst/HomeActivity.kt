package hhsw.yzst

import android.content.Context
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.ImageView
import com.facebook.drawee.view.SimpleDraweeView
import com.youth.banner.loader.ImageLoader
import hhsw.adapter.BulletinAdapter
import hhsw.pojo.Bulletin
import hhsw.util.ActiivtyStack
import kotlinx.android.synthetic.main.activity_home.*
import org.jetbrains.anko.startActivity
import java.util.ArrayList

/**
 * 主页
 */
class HomeActivity : AppCompatActivity() {
    private var imgList = ArrayList<String>()
    private var bulletinList = ArrayList<Bulletin>()
    lateinit var adapter: BulletinAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        ActiivtyStack.getScreenManager().pushActivity(this)
        initView()
        initData()
    }

    private fun initView() {
        imgList.add("https://i04picsos.sogoucdn.com/023c2f9bfa8fecb7")
        imgList.add("https://i04picsos.sogoucdn.com/073ddcc5b3b75213")
        imgList.add("https://i03picsos.sogoucdn.com/023afce60d61a75e")
        banner.setImageLoader(object : ImageLoader() {
            override fun displayImage(context: Context?, path: Any?, imageView: ImageView?) {
                imageView!!.setImageURI(Uri.parse(path as String))
            }

            override fun createImageView(context: Context?): ImageView {
                return SimpleDraweeView(context)
            }
        })
        banner.setImages(imgList)
        banner.setDelayTime(2000)
        banner.start()


//        situation.setOnClickListener { startActivity<SituationActivity>() }
        search.setOnClickListener { startActivity<SearchActivity>() }
        pay.setOnClickListener { startActivity<PayActivity>() }
        record.setOnClickListener { startActivity<RecordActivity>() }
        law.setOnClickListener { startActivity<LawActivity>() }
        service.setOnClickListener { startActivity<ServiceActivity>() }

        adapter = BulletinAdapter(bulletinList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    private fun initData() {
        bulletinList.add(Bulletin("8月15日 停水公告"))
        bulletinList.add(Bulletin("6月24日 停水公告"))

        adapter.notifyDataSetChanged()
    }

    override fun onDestroy() {
        super.onDestroy()
        ActiivtyStack.getScreenManager().popActivity(this)
    }
}
