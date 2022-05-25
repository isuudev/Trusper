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
        private const val KEY_VALUE = "0e9439aa32msh697656698fb33c0p1df924jsn333889b22e30"
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