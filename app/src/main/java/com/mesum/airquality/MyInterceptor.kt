package com.mesum.airquality

import okhttp3.Interceptor
import okhttp3.Response

class MyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("Content-Type", "application/json")
            .addHeader("x-api-key", "ab0b3d8f581a9ca40c1bd16dc6685b8f98ab97a7ec5a5176a7839e34dd475f48")
            .build()
        return chain.proceed(request)
    }
}