package com.example.libcalculagasto

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CalculateSpend() {

    fun returnCurrencyValue(idCurrency: Int) : String{
        val currency : String  = when(idCurrency){
            1 -> "USDT-BRL"  //Dólar turismo
            2 -> "CAD-BRL"  //Dólar canadense
            3 -> "AUD-BRL"  //Dólar australiano
            4 -> "EUR-BRL " //Euro
            5 -> "GBP-BRL " //Libra esterlina
            6 -> "ARS-BRL" //Peso Argentino
            else -> "USDT-BRL"
        }
        return currency
    }

    fun getValue(idCurrency: Int) : Double {
        var value : Double = 0.0
        val retrofitClient = NetworkUtils\
        val url = "https://economia.awesomeapi.com.br/json/daily/${returnCurrencyValue(idCurrency)}/1/"
            .getRetrofitInstance(url)

        val endpoint = retrofitClient.create(Endpoint::class.java)
        val callback = endpoint.getCurrencies()

        callback.enqueue(object : Callback<List<Currencies>> {
            override fun onFailure(call: Call<List<Currencies>>, t: Throwable) {
                print(t.message)
            }

            override fun onResponse(call: Call<List<Currencies>>, response: Response<List<Currencies>>) {
                response.body()?.forEach {
                    value = it.bid.toDouble()
                }
            }
        })

        return value
    }


    fun convertSpend(currencyValuePay: Double, spendValue: Double, idCurrency: Int) : Double{

        var valueExpenditureConverted : Double = 0.0

        if(currencyValuePay == 0.0){
            valueExpenditureConverted = spendValue * getValue(idCurrency)
        }else{
            valueExpenditureConverted = spendValue * currencyValuePay
        }

        return valueExpenditureConverted
    }

}
