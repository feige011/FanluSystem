package com.sunnyweather.fsystem.activity.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sunnyweather.fsystem.R
import com.sunnyweather.fsystem.model.boardThings


class BulletinboardAdapter(val msgList: ArrayList<boardThings>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val broadText: TextView = view.findViewById(R.id.broad_text)
        val boardAccountName: TextView = view.findViewById(R.id.board_account_name)
        val b: LinearLayout = view.findViewById(R.id.broad_linear_layout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.broad_item, parent, false)
        val viewHolder = ViewHolder(view)
//        val d=R.color.white
        return viewHolder
    }

    override fun getItemCount(): Int = msgList.size

    override fun getItemViewType(position: Int): Int {
        return position
    }

//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.broadText.text=msgList[position].boardName
//        holder.boardAccountName.text=msgList[position].boardAccountName
//    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder) {
            holder.broadText.text = msgList[position].boardName
            holder.boardAccountName.text = msgList[position].boardAccountName
        }

    }

}