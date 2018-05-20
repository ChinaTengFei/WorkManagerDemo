package com.ittengfei.workmanagerstudy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.concurrent.TimeUnit;

import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WorkManager instance = WorkManager.getInstance();
        PeriodicWorkRequest.Builder builder = new PeriodicWorkRequest.Builder(MyWorker.class, 1, TimeUnit.SECONDS);
        instance.enqueue(builder.build());
    }
}
