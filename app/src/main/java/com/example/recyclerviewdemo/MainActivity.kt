package com.example.recyclerviewdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random


class MainActivity : AppCompatActivity(), Exampleadapter.onItemClickListener {
    private val examplelist = generatedummyList(500)
    private val adapter = Exampleadapter(examplelist, this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)

    }

    fun insertitem(view: View) {
        val index = Random.nextInt(8)
        val newitem = Exampleitem(
                R.drawable.ic_android, "New Item at position $index",
                "Line 2"
        )
        examplelist.add(index, newitem)
        adapter.notifyItemInserted(index)
    }

    fun removeitem(view: View) {
        val index = Random.nextInt(8)
        examplelist.removeAt(index)
        adapter.notifyItemRemoved(index)
    }

    override fun onItemClick(position: Int) {
        Toast.makeText(this, "item $position clicked", Toast.LENGTH_SHORT).show()
        val clickedItem: Exampleitem = examplelist[position]
        clickedItem.text1 = "clicked"
        adapter.notifyItemChanged(position)
    }

    private fun generatedummyList(size: Int): ArrayList<Exampleitem> {
        val list = ArrayList<Exampleitem>()
        for (i in 0 until size) {
            val drawable = when (i % 3) {
                0 -> R.drawable.ic_android
                1 -> R.drawable.ic_box
                else -> R.drawable.ic_tv
            }
            val item = Exampleitem(drawable, "item$i", "Line2")
            list += item
        }
        return list
    }
}