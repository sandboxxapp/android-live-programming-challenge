package com.sandboxx.swapi.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sandboxx.swapi.data.network.ApiInterface
import com.sandboxx.swapi.transportation.TransportationListViewModel
import java.lang.IllegalArgumentException

class SwapiViewModelFactory constructor(private val apiInterface: ApiInterface)
    : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TransportationListViewModel::class.java)) {
            return TransportationListViewModel(apiInterface) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }

}