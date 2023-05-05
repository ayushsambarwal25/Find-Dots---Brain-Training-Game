package com.tankarsolutions.finddotsbraintraininggame

import android.app.Application
import com.tankarsolutions.finddotsbraintraininggame.di.repoModule
import com.tankarsolutions.finddotsbraintraininggame.di.roomDBModule
import com.tankarsolutions.finddotsbraintraininggame.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(listOf(roomDBModule, repoModule, viewModelModule))
        }
    }

}