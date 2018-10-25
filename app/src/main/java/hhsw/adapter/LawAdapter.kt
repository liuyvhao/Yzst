package hhsw.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import hhsw.pojo.Law
import hhsw.yzst.R
import kotlinx.android.synthetic.main.item_law.view.*
import java.util.ArrayList

class LawAdapter(var lawList: ArrayList<Law>) : RecyclerView.Adapter<LawAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_law, parent, false))

    override fun getItemCount()=lawList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.img.setImageURI(lawList[position].img)
        holder.itemView.name.text=lawList[position].name
        holder.itemView.info.text=lawList[position].info
        holder.itemView.time.text=lawList[position].time
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}