package hhsw.adapter

import android.support.v7.widget.RecyclerView
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import hhsw.util.PayDialog
import hhsw.yzst.R
import kotlinx.android.synthetic.main.item_pay_list.view.*
import org.jetbrains.anko.windowManager
import java.util.ArrayList

class PayAdapter(var payList:ArrayList<String>): RecyclerView.Adapter<PayAdapter.ViewHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_pay_list,parent,false))

    override fun getItemCount()=payList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.btn_pay.text=payList[position]
        holder.itemView.btn_pay.setOnClickListener {
            var dialog=PayDialog(it.context)
            dialog.show()
            var dm = DisplayMetrics()
            it.context.windowManager.defaultDisplay.getMetrics(dm)
            dialog.window.setLayout(dm.widthPixels, dialog.window.attributes.height)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}