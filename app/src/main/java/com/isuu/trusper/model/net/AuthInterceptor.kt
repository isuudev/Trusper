package com.isuu.trusper.model.net

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response


class AuthInterceptor : Interceptor {
    companion object {

        //header key
        private const val HEADER_HOST = "X-RapidAPI-Host"
        private const val HEADER_KEY = "X-RapidAPI-Key"
        private const val HOST_VALUE = "contextualwebsearch-websearch-v1.p.rapidapi.com"
        private const val KEY_VALUE = "4d13c80f13mshe578bd16a435227p1c13c2jsn23cefafcbaf5"
    }

    private fun addTokenParams(request: Request): Request {
        return request.newBuilder()
            .header(HEADER_HOST,HOST_VALUE)
            .header(HEADER_KEY, KEY_VALUE).build()
    }

    override fun intercept(chain: Interceptor.Chain): Response {

        var request = chain.request()

        request = addTokenParams(request)
        return chain.proceed(request)
    }
}