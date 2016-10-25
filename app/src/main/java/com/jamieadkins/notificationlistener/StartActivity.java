package com.jamieadkins.notificationlistener;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.jamieadkins.notificationlistener.models.CaughtNotification;

/**
 * Created by jamiea on 25/10/16.
 */

public class StartActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.RECEIVE_BOOT_COMPLETED) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.RECEIVE_BOOT_COMPLETED}, 1234);
        }

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.BIND_NOTIFICATION_LISTENER_SERVICE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.BIND_NOTIFICATION_LISTENER_SERVICE}, 1235);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        TextView dataView = (TextView) findViewById(R.id.tv_data);
        dataView.setText(CaughtNotification.listAll(CaughtNotification.class).size() + "");
    }
}
