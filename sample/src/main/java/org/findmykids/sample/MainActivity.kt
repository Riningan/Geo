package org.findmykids.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import kotlinx.android.synthetic.main.activity_main.*
import org.findmykids.geo.api.GeoPlatform
import org.findmykids.geo.api.GeoPlatformSettings
import org.findmykids.geo.api.listener.GeoListener
import org.findmykids.geo.common.model.Geo
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (BuildConfig.DEBUG) {
            etMain.setText("N2IwNWU2NWQ3MjcxNDM5ZWMzYTk5NzI3ZTMwZTM1NWNveENiRHg1TjNxS0habE90OWMzN1ZBPT0=")
        }

//        if (GeoPlatform.isActivated(applicationContext)) {
//            btnActivate.isVisible = false
//            btnDeactivate.isVisible = true
//        } else {
//            btnActivate.isVisible = true
//            btnDeactivate.isVisible = false
//        }
        btnActivate.setOnClickListener {
            GeoPlatform.activate(this, "123", etMain.text.toString())
        }
        btnDeactivate.setOnClickListener {
            GeoPlatform.deactivate(this)
        }
        btnSendLog.setOnClickListener {
            GeoPlatform.log(this)
        }
        btnTest.setOnClickListener {
            val work = OneTimeWorkRequestBuilder<TestWorker>()
                .setInitialDelay(60 * 1000, TimeUnit.MILLISECONDS)
                .build()
            WorkManager.getInstance(applicationContext).enqueue(work)
        }
        GeoPlatform.ping(this)
    }

    override fun onResume() {
        super.onResume()
        GeoPlatformSettings.setListener(this, object : GeoListener {
            override fun onNewGeo(geo: Geo) {
                tvLogs.post {
                    tvLogs.text = geo.toShortString()
                }
            }
        })
    }

    override fun onPause() {
        super.onPause()
        GeoPlatformSettings.setListener(this, null)
    }
}
