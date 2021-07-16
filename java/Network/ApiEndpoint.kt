package com.pedro.fragmentapplication.Network

import com.pedro.fragmentapplication.Model.ModelSecond
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndpoint {
    @GET("top-headlines?country=id&category=science&apiKey=")
    fun getDataApi() : Call<ModelSecond>

}