package com.mesum.airquality.model

import com.squareup.moshi.Json
import java.lang.reflect.Type


data class AirQuality(@Json(name = "stations")val airQualityData : List<AirQualityData>)

data class AirQualityData(
    @Json(name = "CO")
    val CO : Double,
    val NO2 : Double,
    val OZONE : Double,
    val PM10 : Double,
    val PM25 : Double,
    val SO2 : Double,
    val city : String,
    val countryCode : String,
    val lat : Double,
    val lng : Double,
    val placeName: String,
    val postalCode : String,
    val state : String,
    val updatedAt : String,
    val AQI : String,
    val aqiInfo : aqiInfo

)

data class aqiInfo (val pollutant: String, val concentration : Double, val category: String)
