package com.example.interview_prep

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.interview_prep.retrofit.ResponseData
import com.squareup.picasso.Picasso

class ItemRecylerAdapter(var data: List<ResponseData?>, private val cellClickListener: CellClickListener) :  RecyclerView.Adapter<ItemRecylerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_view, parent, false)
        return  ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.title.text = item?.title
        Picasso.get()
            .load(item?.thumbnailUrl)
            .resize(250, 250)
            .centerCrop()
            .into(holder.imageView)
        holder.imageView.setOnClickListener {
            cellClickListener.onCellClickListener(item)
        }



    }

    override fun getItemCount(): Int {
       return  data.size
    }
    inner class  ViewHolder( itemView: View): RecyclerView.ViewHolder(itemView){
        var title: TextView = itemView.findViewById(R.id.titleView)
      var imageView: ImageView = itemView.findViewById(R.id.iconImage)
    }
}

interface CellClickListener {
    fun onCellClickListener(data: ResponseData?)
}