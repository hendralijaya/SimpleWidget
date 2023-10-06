package com.example.simplewidget

import android.appwidget.AppWidgetManager
import android.content.ComponentName
import android.content.Context
import android.widget.RemoteViews
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.simplewidget.response.WeatherResponse
import com.example.simplewidget.retrofit.ApiConfig
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UpdateWeatherWorker(context: Context, workerParams: WorkerParameters) : CoroutineWorker(context, workerParams) {
    override suspend fun doWork(): Result {
        val appWidgetManager = AppWidgetManager.getInstance(applicationContext)
        val ids = appWidgetManager.getAppWidgetIds(ComponentName(applicationContext, SimpleWidget::class.java))

        val weather = getWeather()
        ids.forEach { id ->
            updateAppWidget(applicationContext, appWidgetManager, id, weather)
        }

        return Result.success()
    }

    private suspend fun getWeather(town: String = "Jakarta"): WeatherResponse {
        return withContext(Dispatchers.IO) {
            val client = ApiConfig.getApiService().getWeather()
            val response = client.execute()
            if (response.isSuccessful) {
                response.body()!!
            } else {
                throw RuntimeException("Response not successful: ${response.message()}")
            }
        }
    }

    private fun updateAppWidget(context: Context, appWidgetManager: AppWidgetManager, appWidgetId: Int, weather: WeatherResponse) {
        val views = RemoteViews(context.packageName, R.layout.simple_widget)
        val weatherMain = weather.weather?.get(0)?.main
        val location = weather.name
        val temperature = (weather.main?.temp as Double?)!! - 273.15
        val formattedTemperature = String.format("%.2f", temperature)
        val temperatureMinimal = (weather.main?.tempMin as Double?)!! - 273.15
        val formattedTemperatureMin = String.format("%.2f", temperatureMinimal)
        val temperatureMaximal = (weather.main?.tempMax as Double?)!! - 273.15
        val formattedTemperatureMax = String.format("%.2f", temperatureMaximal)
        views.setTextViewText(R.id.tvIndicator, weatherMain) // replace with actual data
        views.setTextViewText(R.id.tvTown, location)
        views.setTextViewText(R.id.tvCelcius, "$formattedTemperature°")
        views.setTextViewText(R.id.tvCelciusLow, "$formattedTemperatureMin°")
        views.setTextViewText(R.id.tvCelciusMax, "$formattedTemperatureMax°")
        appWidgetManager.updateAppWidget(appWidgetId, views)
    }
}