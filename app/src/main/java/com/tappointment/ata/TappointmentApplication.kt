package com.tappointment.ata

import android.app.Application
import com.tappointment.ata.model.RepositoryFactory

class TappointmentApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        RepositoryFactory.init(applicationContext)
    }
}