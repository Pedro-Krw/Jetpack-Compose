package com.pedro.fragmentapplication.Network

import com.pedro.fragmentapplication.Model.ModelSecond
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndpoint {
    @GET("top-headlines?country=id&category=science&apiKey=68244cf4cc4d45ad98370eaec6b9dd05")
    fun getDataApi() : Call<ModelSecond>

}