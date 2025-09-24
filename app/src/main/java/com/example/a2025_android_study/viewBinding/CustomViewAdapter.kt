package com.example.a2025_android_study.viewBinding

import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import android.widget.TextView
import com.example.a2025_android_study.databinding.TextRowItemBinding

class CustomViewAdapter(private val dataSet : ArrayList<String>) : RecyclerView.Adapter<CustomViewAdapter.ViewHolder>(){

    class ViewHolder(binding : TextRowItemBinding) : RecyclerView.ViewHolder(binding.root) {

        val myText : TextView = binding.myText
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = TextRowItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.myText.text= dataSet[position]

    }

    override fun getItemCount(): Int {

        return dataSet.size

    }
}