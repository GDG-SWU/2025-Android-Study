package com.example.a2025_android_study.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.a2025_android_study.R
import com.example.a2025_android_study.model.Plant
import com.example.a2025_android_study.model.Post


//28강
//class CustomAdapter(private val dataSet : ArrayList<Post>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
//
//    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
//
//        val textView : TextView
//
//        init {
//            textView = view.findViewById(R.id.textView)
//        }
//
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.ViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.text_row_item, parent, false)
//
//        return ViewHolder(view)
//
//    }
//
//    override fun onBindViewHolder(holder: CustomAdapter.ViewHolder, position: Int) {
//
//        holder.textView.text = dataSet[position].title
//
//    }
//    override fun getItemCount(): Int {
//        return dataSet.size
//    }
//}


//29강
class CustomAdapter(val context :Context, val dataSet : List<Plant>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val textView : TextView = view.findViewById(R.id.textArea)
        val imageView : ImageView = view.findViewById(R.id.imageArea)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.text_row_item, parent, false)

        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: CustomAdapter.ViewHolder, position: Int) {

        holder.textView.text = dataSet[position].name
        Glide.with(context)
            .load(dataSet[position].imageUrl)
            .into(holder.imageView)

    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

}