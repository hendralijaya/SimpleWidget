package com.example.simplewidget.response

import com.google.gson.annotations.SerializedName

data class WeatherResponse(

	@field:SerializedName("visibility")
	val visibility: Int? = null,

	@field:SerializedName("timezone")
	val timezone: Int? = null,

	@field:SerializedName("main")
	val main: Main? = null,

	@field:SerializedName("clouds")
	val clouds: Clouds? = null,

	@field:SerializedName("sys")
	val sys: Sys? = null,

	@field:SerializedName("dt")
	val dt: Int? = null,

	@field:SerializedName("coord")
	val coord: Coord? = null,

	@field:SerializedName("weather")
	val weather: List<WeatherItem?>? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("cod")
	val cod: Int? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("base")
	val base: String? = null,

	@field:SerializedName("wind")
	val wind: Wind? = null
)

data class WeatherItem(

	@field:SerializedName("icon")
	val icon: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("main")
	val main: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)

data class Main(

	@field:SerializedName("temp")
	val temp: Any? = null,

	@field:SerializedName("temp_min")
	val tempMin: Any? = null,

	@field:SerializedName("humidity")
	val humidity: Int? = null,

	@field:SerializedName("pressure")
	val pressure: Int? = null,

	@field:SerializedName("feels_like")
	val feelsLike: Any? = null,

	@field:SerializedName("temp_max")
	val tempMax: Any? = null
)

data class Coord(

	@field:SerializedName("lon")
	val lon: Any? = null,

	@field:SerializedName("lat")
	val lat: Any? = null
)

data class Sys(

	@field:SerializedName("country")
	val country: String? = null,

	@field:SerializedName("sunrise")
	val sunrise: Int? = null,

	@field:SerializedName("sunset")
	val sunset: Int? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("type")
	val type: Int? = null
)

data class Clouds(

	@field:SerializedName("all")
	val all: Int? = null
)

data class Wind(

	@field:SerializedName("deg")
	val deg: Int? = null,

	@field:SerializedName("speed")
	val speed: Any? = null,

	@field:SerializedName("gust")
	val gust: Any? = null
)
