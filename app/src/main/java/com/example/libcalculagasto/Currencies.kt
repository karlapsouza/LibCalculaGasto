package com.example.libcalculagasto

import com.google.gson.annotations.SerializedName

data class Currencies(
    @SerializedName("code")
    var originalCurrency : String,
    @SerializedName("codein")
    var finalCurrency : String,
    @SerializedName("name")
    var name : String,
    @SerializedName("bid")
    var value : Double
)
