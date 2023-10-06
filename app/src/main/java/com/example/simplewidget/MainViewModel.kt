package com.example.simplewidget

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.simplewidget.response.WeatherItem
import com.example.simplewidget.response.WeatherResponse
import com.example.simplewidget.retrofit.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {
    private val _weatherItem = MutableLiveData<WeatherItem>()
    val weatherItem:LiveData<WeatherItem> = _weatherItem

    init {
        getWeather()
    }

    fun getWeather(town: String = "Jakarta") {
        val client = ApiConfig.getApiService().getWeather()
        client.enqueue(object : Callback<WeatherResponse> {
            override fun onResponse(
                call: Call<WeatherResponse>,
                response: Response<WeatherResponse>
            ) {
                if (response.isSuccessful) {

                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }
            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {

            }
        })
    }

    companion object{
        private const val TAG = "MainViewModel"
    }
}