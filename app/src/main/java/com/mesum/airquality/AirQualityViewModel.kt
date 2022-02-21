package com.mesum.airquality

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.*
import com.mesum.airquality.model.AirQuality
import com.mesum.airquality.repository.AirQualityRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class AirQualityViewModel(val application: Application) : ViewModel() {

    private val airQualityRepository = AirQualityRepository(application.applicationContext)
  private  var _airQuality: MutableLiveData<AirQuality>? = MutableLiveData<AirQuality>()
    val airQuality: LiveData<AirQuality> get() = _airQuality!!

    var airQualityData: LiveData<String> = MutableLiveData()


    fun getAirQuality(city: String) =

        try {
            viewModelScope.launch {
                _airQuality?.value = airQualityRepository.getAirQuality(city)
                Log.d("AirQualityResult", "Success")
                Log.d("AirQualityResult", "${airQuality.value}")
            }


        } catch (e: Exception) {
            Log.d("AirQualityResult", "${e.message}")
            Toast.makeText(application.applicationContext, "Load Failed", Toast.LENGTH_SHORT).show()
        }


    /**
     * Factory for constructing DevByteViewModel with parameter
     */
    class Factory(val app: Application) : ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(AirQualityViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return AirQualityViewModel(app) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")

        }
    }
}
