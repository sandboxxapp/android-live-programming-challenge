package com.sandboxx.swapi.transportation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sandboxx.swapi.R

class TransportationListActivity : AppCompatActivity() {
    private lateinit var adapter: TransportationListAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = TransportationListAdapter()

        recyclerView = findViewById(R.id.rc_transports)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
}