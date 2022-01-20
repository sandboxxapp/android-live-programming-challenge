package com.sandboxx.swapi.data.json

data class VehiclesListResult(val count: Int,
                              val next: String?,
                              val previous: String?,
                              val results: List<VehicleJson>)
