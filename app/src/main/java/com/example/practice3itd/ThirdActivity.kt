package com.example.practice3itd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)

        recyclerview.layoutManager = LinearLayoutManager(this)

        val data = ArrayList<itemsModelView>()

        for (i in 1..20){
            data.add(itemsModelView(R.drawable.xdd, "Item " + i))
        }

        val adapter = CustomAdapter(data)
        recyclerview.adapter = adapter
    }
}