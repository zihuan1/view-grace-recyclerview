package com.zihuan.demo

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.zihuan.view.crvlibrary.RecyclerData

/**
 *
 * @Description
 * @author zihuan
 * @date 2019/12/4 11:06
 */
class ReAdapter2() : RecyclerView.Adapter<ReAdapter2.Viewholder2>(), RecyclerData {

    constructor(context: Any?) : this() {
        Log.e("context", context.toString())
    }

    constructor(list: ArrayList<String>, list2: ArrayList<String>) : this() {
        Log.e("数据", " ${list}$list2")
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): Viewholder2 {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.layout, viewGroup, false)
        return Viewholder2(view)
    }

    var mList = ArrayList<String>()
    override fun getItemCount() = mList.size

    override fun onBindViewHolder(holder: Viewholder2, position: Int) {
        var view = holder.itemView
        view.findViewById<TextView>(R.id.tvName).text = mList[position]
        view.setOnClickListener {
            Log.e("点击", "点击$position")
        }
        view.findViewById<ImageView>(R.id.ivTest).setOnClickListener {
            Log.e("点击", "点击子view $position")
        }
    }

    class Viewholder2(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun update(data: List<*>) {
        mList.clear()
        mList.addAll(data as ArrayList<String>)
        Log.e("刷新", "刷新数据")
        notifyDataSetChanged()
    }
}