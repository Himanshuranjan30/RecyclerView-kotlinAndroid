package com.example.recyclerviewdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class Exampleadapter(private val examplelist:List<Exampleitem>):RecyclerView.Adapter<Exampleadapter.ExampleViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
       var itemView=LayoutInflater.from(parent.context).inflate(R.layout.example_item,
       parent,false
               )

        return ExampleViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
     val currentitem=examplelist[position]
        holder.imageView.setImageResource(currentitem.imageResource)
        holder.textview1.text=currentitem.text1
        holder.textview2.text=currentitem.text2

    }

    override fun getItemCount(): Int {
        return examplelist.size
    }

    class ExampleViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
      val imageView: ImageView =itemView.findViewById(R.id.image_view)
        val textview1:TextView=itemView.findViewById(R.id.text_view1)
        val textview2:TextView=itemView.findViewById(R.id.text_view2)
    }
}