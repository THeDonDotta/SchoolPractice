package com.example.practiceschool.model

import com.example.practiceschool.data.SchoolDetails
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

interface SchoolApi {

    companion object {
        private const val BASE_URL = "https://data.cityofnewyork.us"

        fun getInstance(): SchoolApi {
            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create()
        }
    }

    @GET("/resource/f9bf-2cp4.json")
    suspend fun getSchools(): List<SchoolDetails>

}