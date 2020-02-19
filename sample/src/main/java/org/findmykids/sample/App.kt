package org.findmykids.sample

import androidx.multidex.MultiDexApplication
import org.findmykids.geo.api.GeoPlatformSettings


class App : MultiDexApplication() {
    override fun onCreate() {
        GeoPlatformSettings.init(baseContext, SampleGeoExtension())
        GeoPlatformSettings.enableLogSaver(baseContext)
        super.onCreate()
    }
}