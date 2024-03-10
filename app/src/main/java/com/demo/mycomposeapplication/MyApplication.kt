package com.demo.mycomposeapplication

import android.app.Application
import com.demo.mycomposeapplication.database.AppDataBase
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()

    }
}