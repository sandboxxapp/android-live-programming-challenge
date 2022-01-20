package com.sandboxx.swapi.data.network

import com.sandboxx.swapi.data.json.VehicleJson
import com.squareup.moshi.Moshi
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface ApiInterface {
    @GET("vehicles/")
    fun vehiclesList() : Call<List<VehicleJson>>

    companion object {
        var apiInterface: ApiInterface? = null

        fun getInstance(): ApiInterface {
            if (apiInterface == null) {
                val moshi: Moshi = Moshi
                    .Builder()
                    .build()
                val moshiConverterFactory = MoshiConverterFactory.create(moshi)

                val retrofit = Retrofit
                    .Builder()
                    .baseUrl("https://swapi.dev/api/")
                    .addConverterFactory(moshiConverterFactory)
                    .build()

                apiInterface = retrofit.create(ApiInterface::class.java)
            }

            return apiInterface!!
        }
    }
}