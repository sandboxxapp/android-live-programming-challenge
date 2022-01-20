package com.sandboxx.swapi.transportation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sandboxx.swapi.data.json.VehicleJson
import com.sandboxx.swapi.data.json.VehiclesListResult
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
            .enqueue(object: Callback<VehiclesListResult> {
                override fun onResponse(call: Call<VehiclesListResult>,
                                        response: Response<VehiclesListResult>) {
                    val loadedVehicles = response.body()?.results ?: ArrayList()
                    vehicles.value = loadedVehicles
                }

                override fun onFailure(call: Call<VehiclesListResult>,
                                       t: Throwable) {
                    errorMessage.value = t.localizedMessage
                }
            })
    }
}