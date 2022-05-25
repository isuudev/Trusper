package com.isuu.trusper.model.net

import com.blankj.utilcode.util.AppUtils
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

class HttpClient(val okHttpClient: OkHttpClient, private val retrofit: Retrofit, val moshi: Moshi) {

    fun <T> create(serviceClass: Class<T>): T {
        return retrofit.create(serviceClass)
    }

    class Builder {
        private var moshi: Moshi? = null
        private var okHttpClient: OkHttpClient? = null
        private var retrofit: Retrofit? = null

        private val moshiBuilder: Moshi.Builder = Moshi.Builder()
        private val okHttpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
        private val retrofitBuilder: Retrofit.Builder = Retrofit.Builder()

        private var baseUrl: String? = null

        fun moshi(moshi: Moshi): Builder {
            this.moshi = moshi
            return this
        }

        fun okHttpClient(okHttpClient: OkHttpClient): Builder {
            this.okHttpClient = okHttpClient
            return this
        }

        fun retrofit(retrofit: Retrofit): Builder {
            this.retrofit = retrofit
            return this
        }

        fun baseUrl(baseUrl: String): Builder {
            this.baseUrl = baseUrl
            return this
        }

        fun builder(blok: (moshiBuilder: Moshi.Builder, okHttpClientBuilder: OkHttpClient.Builder, retrofitBuilder: Retrofit.Builder) -> Unit): Builder {
            blok(moshiBuilder, okHttpClientBuilder, retrofitBuilder)
            return this
        }

        fun build(): HttpClient {
            val baseUrl = this.baseUrl ?: ""
            val moshi = this.moshi ?: moshiBuilder.build()
            val okHttpClient = this.okHttpClient ?: okHttpClientBuilder
                .addInterceptor(HttpLoggingInterceptor().apply {
                    level = if (AppUtils.isAppDebug()) {
                        HttpLoggingInterceptor.Level.BODY
                    } else {
                        HttpLoggingInterceptor.Level.NONE
                    }
                }).addInterceptor(AuthInterceptor()).build()

            val retrofit = this.retrofit ?: retrofitBuilder
                .client(okHttpClient)
                .baseUrl(baseUrl)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create(moshi).asLenient())
                .build()

            return HttpClient(okHttpClient, retrofit, moshi)
        }
    }
}