package com.example.libcalculagasto

import com.google.gson.annotations.SerializedName

data class Currencies(
    @SerializedName("name")
    var name : String,
    @SerializedName("bid")
    var bid : Double
)
