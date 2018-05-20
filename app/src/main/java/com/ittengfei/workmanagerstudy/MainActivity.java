package com.ittengfei.workmanagerstudy;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;
import java.util.concurrent.TimeUnit;

import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkStatus;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WorkManager instance = WorkManager.getInstance();
        instance.getStatusesByTag("Hello").observe(this, new Observer<List<WorkStatus>>() {
            @Override
            public void onChanged(@Nullable List<WorkStatus> workStatuses) {
                Log.d(TAG, "onChanged() called with: workStatuses = [" + workStatuses + "]");
                for (WorkStatus workStatu : workStatuses) {
                    Log.i(TAG, "isFinished"+workStatu.getState().isFinished()+"=====onChanged: "+workStatu.getOutputData().getString("a",""));
                }
            }
        });
        PeriodicWorkRequest.Builder builder = new PeriodicWorkRequest.Builder(MyWorker.class, 1, TimeUnit.SECONDS,1,TimeUnit.SECONDS);
        OneTimeWorkRequest hello = new OneTimeWorkRequest.Builder(MyWorker.class).addTag("Hello").build();
        OneTimeWorkRequest oneTimeWorkRequest = hello;
        instance.enqueue(oneTimeWorkRequest);
    }
}
