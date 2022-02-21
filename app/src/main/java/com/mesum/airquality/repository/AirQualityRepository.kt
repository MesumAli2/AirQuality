package com.mesum.airquality.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mesum.airquality.AirQuality
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher

class AirQualityRepository (context: Context){

    suspend fun getAirQuality(city: String) : com.mesum.airquality.model.AirQuality {
        var airQuality : com.mesum.airquality.model.AirQuality
        withContext(Dispatchers.IO) {
             airQuality = AirQuality.airQualityApiService.getAirQuality(
            "$city")
        }
        return airQuality
    }

}