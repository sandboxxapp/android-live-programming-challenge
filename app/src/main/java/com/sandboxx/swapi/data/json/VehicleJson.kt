package com.sandboxx.swapi.data.json

import com.squareup.moshi.Json

data class VehicleJson(@field:Json(name = "name") val name: String,
                       @field:Json(name = "model") val model: String,
                       @field:Json(name = "url") val url: String,
                       @field:Json(name = "cargo_capacity") val cargoCapacity: String)
