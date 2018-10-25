package hhsw.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import hhsw.yzst.R
import kotlinx.android.synthetic.main.item_service.view.*
import java.util.ArrayList

class ServiceAdapter(var serviceList: ArrayList<String>) : RecyclerView.Adapter<ServiceAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_service, parent, false))

    override fun getItemCount() = serviceList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.s_name.text=serviceList[position]
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}