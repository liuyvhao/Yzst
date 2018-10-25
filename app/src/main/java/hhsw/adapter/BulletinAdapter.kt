package hhsw.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import hhsw.pojo.Bulletin
import hhsw.yzst.R
import kotlinx.android.synthetic.main.item_bulletin.view.*
import java.util.ArrayList

class BulletinAdapter(var bulletinList: ArrayList<Bulletin>) : RecyclerView.Adapter<BulletinAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_bulletin, parent, false))

    override fun getItemCount() = bulletinList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.title.text = bulletinList[position].title
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}