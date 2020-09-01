package com.example.libcalculagasto

import retrofit2.Call
import retrofit2.http.GET

interface Endpoint {
    @GET("currencies")
    fun getCurrencies() : Call<List<Currencies>>
}