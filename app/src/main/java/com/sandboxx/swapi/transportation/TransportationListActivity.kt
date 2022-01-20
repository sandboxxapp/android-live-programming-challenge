package com.sandboxx.swapi.transportation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sandboxx.swapi.R
import com.sandboxx.swapi.common.SwapiViewModelFactory
import com.sandboxx.swapi.data.network.ApiInterface

class TransportationListActivity : AppCompatActivity() {
    private lateinit var adapter: TransportationListAdapter
    private lateinit var recyclerView: RecyclerView

    private lateinit var viewModel: TransportationListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModelFactory = SwapiViewModelFactory(ApiInterface.getInstance())
        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(TransportationListViewModel::class.java)

        adapter = TransportationListAdapter()

        recyclerView = findViewById(R.id.rc_transports)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        viewModel
            .vehicles
            .observe(this, { data ->
                adapter.addAll(data)
            })

        viewModel
            .errorMessage
            .observe(this, { errorMessage ->
                showError(errorMessage)
            })

        viewModel.loadVehicles()
    }

    private fun showError(errorMessage: String) {
        Toast
            .makeText(this, errorMessage, Toast.LENGTH_LONG)
            .show()
    }
}