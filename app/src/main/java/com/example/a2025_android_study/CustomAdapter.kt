package com.example.a2025_android_study

import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.view.LayoutInflater
import com.example.a2025_android_study.R
class CustomAdapter(private val dataSet : ArrayList<String>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>(){

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {

        val myText : TextView
        init {
            myText = view.findViewById(R.id.myText)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.text_row_item, parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.myText.text= dataSet[position]
    }

    override fun getItemCount(): Int {

        return dataSet.size
    }
}