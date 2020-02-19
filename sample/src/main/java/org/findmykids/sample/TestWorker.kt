package org.findmykids.sample

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import org.findmykids.geo.common.utils.ProcessUtil


class TestWorker(
    appContext: Context,
    workerParams: WorkerParameters
) : Worker(appContext, workerParams) {

    override fun doWork(): Result {
        Log.d("TestWorker", ProcessUtil.getProcessName())
        return Result.success()
    }
}