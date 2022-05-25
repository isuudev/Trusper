package com.isuu.trusper.model.hilt

import com.isuu.trusper.BuildConfig
import com.isuu.trusper.model.Api
import com.isuu.trusper.model.net.API_BASE_URL
import com.isuu.trusper.model.net.AuthInterceptor
import com.isuu.trusper.model.net.HttpClient
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module(includes = [HttpModule.BindsModule::class])
@InstallIn(SingletonComponent::class)
object HttpModule {

    @Provides
    @Singleton
    fun provideHttpClient(
    ): HttpClient {
        val url =
            if (BuildConfig.DEBUG) API_BASE_URL else API_BASE_URL
        return HttpClient.Builder()
            .baseUrl(url)
            .builder { moshiBuilder, okHttpClientBuilder, retrofitBuilder ->
                okHttpClientBuilder.addInterceptor(AuthInterceptor())
            }
            .build()
    }

    @Provides
    @Singleton
    fun provideApi(httpClient: HttpClient): Api {
        return httpClient.create(Api::class.java)
    }

    @Module
    @InstallIn(SingletonComponent::class)
    abstract class BindsModule {
    }
}