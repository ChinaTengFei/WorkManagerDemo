package com.ittengfei.workmanagerstudy;

import android.support.annotation.NonNull;
import android.util.Log;

import androidx.work.Worker;

/**
 * Created by Administrator on 2018/5/21.
 */

public class MyWorker extends Worker {
    private static final String TAG = "MyWorker";
    @NonNull
    @Override
    public WorkerResult doWork() {
        Log.d(TAG, "doWork() called");
        return WorkerResult.SUCCESS;
    }
}
