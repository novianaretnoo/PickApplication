package com.example.pickapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pickapp.room.Data
import kotlinx.android.synthetic.main.list_data.view.*

class DataAdapter(private val datas: ArrayList<Data>, private val listener: OnAdapterListener) : RecyclerView.Adapter<DataAdapter.DataViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        return DataViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_data, parent, false)
        )
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val data  = datas[position]
        holder.view.text_title.text = data.code
        holder.view.text_title.setOnClickListener {
            listener.onClick(data)
        }
        holder.view.icon_edit.setOnClickListener {
            listener.onUpdate(data)
        }
        holder.view.icon_delete.setOnClickListener {
            listener.onDelete(data)
        }
    }

    override fun getItemCount() = datas.size

    class DataViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    fun setData(list: List<Data>){
        datas.clear()
        datas.addAll(list)
        notifyDataSetChanged()
    }

    interface OnAdapterListener {
        fun onClick(data : Data)
        fun onUpdate(data : Data)
        fun onDelete(data : Data)
    }
}
