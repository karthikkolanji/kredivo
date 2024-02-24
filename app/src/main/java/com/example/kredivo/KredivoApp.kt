package com.example.kredivo

import android.app.Application
import com.example.core.extensions.debug
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import timber.log.Timber.DebugTree

@HiltAndroidApp
class KredivoApp : Application() {

    override fun onCreate() {
        super.onCreate()
        debug {
            Timber.plant(DebugTree())
        }
    }
}