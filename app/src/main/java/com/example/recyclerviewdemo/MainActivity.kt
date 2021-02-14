package com.example.recyclerviewdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val examplelist=generatedummyList(500)
        recycler_view.adapter=Exampleadapter(examplelist)
        recycler_view.layoutManager=LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)

    }
    private fun generatedummyList(size:Int):List<Exampleitem>{
        val list=ArrayList<Exampleitem>()
        for(i in 0 until size){
            val drawable=when(i%3){
                0->R.drawable.ic_android
                1->R.drawable.ic_box
                else ->R.drawable.ic_tv
            }
        val item =Exampleitem(drawable,"item$i","Line2")
        list+=item
    }
    return list
}
}