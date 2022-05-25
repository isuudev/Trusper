package com.isuu.trusper

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import kotlin.properties.Delegates

@HiltAndroidApp
class App : Application() {

    companion object {

        private var appInstance: App by Delegates.notNull()

        val instance: App
            get() = appInstance

    }

    override fun onCreate() {

        super.onCreate()

        appInstance = this

    }

}