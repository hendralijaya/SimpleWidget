package com.example.simplewidget.retrofit

import com.example.simplewidget.BuildConfig
import com.example.simplewidget.response.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("weather?q=Jakarta&appid=${BuildConfig.API_KEY}")
    fun getWeather(): Call<WeatherResponse>
}