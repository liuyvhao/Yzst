package hhsw.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import hhsw.pojo.Record
import hhsw.yzst.R
import kotlinx.android.synthetic.main.item_record.view.*
import java.util.ArrayList

class RecordAdapter(var recordList:ArrayList<Record>):RecyclerView.Adapter<RecordAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_record,parent,false))

    override fun getItemCount()=recordList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.item_title_record.visibility=View.GONE
        if (position==0||recordList[position].year!=recordList[position-1].year){
            holder.itemView.item_title_record.visibility=View.VISIBLE
        }

        holder.itemView.item_year.text=recordList[position].year
        holder.itemView.item_water.text=recordList[position].water
        holder.itemView.item_pay.text=recordList[position].pay
        holder.itemView.img.setImageURI(recordList[position].img)
        holder.itemView.name.text=recordList[position].name
        holder.itemView.time.text=recordList[position].time
        holder.itemView.money.text=recordList[position].money

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}