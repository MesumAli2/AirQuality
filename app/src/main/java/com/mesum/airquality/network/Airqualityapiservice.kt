package com.mesum.airquality

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mesum.airquality.model.AirQuality
import com.mesum.airquality.model.AirQualityData
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query


private const val BASE_URL =  "https://api.ambeedata.com"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()
private val okHttpClient = OkHttpClient.Builder()
    .addInterceptor(MyInterceptor())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .client(okHttpClient)
    .baseUrl(BASE_URL)
    .build()

interface AirQualityApiService{
    @GET("latest/by-city")
   suspend fun getAirQuality(@Query("city") city : String ) : AirQuality
}

object AirQuality {
     val airQualityApiService : AirQualityApiService by lazy {
        retrofit.create(AirQualityApiService::class.java)
    }
}