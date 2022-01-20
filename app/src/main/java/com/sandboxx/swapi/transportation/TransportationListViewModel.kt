package com.sandboxx.swapi.transportation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sandboxx.swapi.data.json.VehicleJson
import com.sandboxx.swapi.data.network.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TransportationListViewModel(private val apiInterface: ApiInterface): ViewModel() {
    var vehicles: MutableLiveData<List<VehicleJson>> = MutableLiveData()
    var errorMessage: MutableLiveData<String> = MutableLiveData()

    fun loadVehicles() {
        apiInterface
            .vehiclesList()
            .enqueue(object: Callback<List<VehicleJson>> {
                override fun onResponse(call: Call<List<VehicleJson>>, response: Response<List<VehicleJson>>) {
                    val loadedVehicles = response.body() ?: ArrayList()
                    vehicles.value = loadedVehicles
                }

                override fun onFailure(call: Call<List<VehicleJson>>, t: Throwable) {
                    errorMessage.value = t.localizedMessage
                }
            })
    }
}