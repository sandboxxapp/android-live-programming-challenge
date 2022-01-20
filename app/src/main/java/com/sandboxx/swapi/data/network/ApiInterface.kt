package com.sandboxx.swapi.data.network

import com.sandboxx.swapi.data.json.VehicleJson
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("https://swapi.dev/api/vehicles/")
    fun vehiclesList() : Call<List<VehicleJson>>
}