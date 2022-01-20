package com.sandboxx.swapi.transportation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sandboxx.swapi.databinding.ActivityMainBinding

class TransportationListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}