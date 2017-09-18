package com.shuanghua.kandroid_demo1.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.shuanghua.kandroid_demo1.R
import com.shuanghua.kandroid_demo1.bean.ListBean

class NewsAdapter(private val context: Context) : RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {

    private var list: List<ListBean>? = null
    var listener: RecyclerViewClickListener? = null

    fun setData(data: List<ListBean>) {
        list = data
        notifyDataSetChanged()
    }

    fun setOnClick(holder: MyViewHolder) {
        holder.itemView.setOnClickListener {
            listener?.onClick(holder.itemView, holder.layoutPosition, list!![holder.position].url!!)
        }
    }

    fun addOnClickListener(listener: RecyclerViewClickListener) {
        this.listener = listener
    }

    override fun getItemCount() = list?.size ?: 0

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemContent?.text = list!![position].title
        holder.itemTime?.text = list!![position].day
        setOnClick(holder)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int)
            = MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_news, parent, false))

    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        val itemContent = itemView?.findViewById<TextView>(R.id.itemContent)
        val itemTime = itemView?.findViewById<TextView>(R.id.itemTime)
    }

    interface RecyclerViewClickListener {
        fun onClick(view: View, position: Int, url: String)
    }
}
