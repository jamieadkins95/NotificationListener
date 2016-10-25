package com.jamieadkins.notificationlistener;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by jamiea on 25/10/16.
 */
public class BootBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent notificationIntent = new Intent(context, NLListener.class);
        PendingIntent pendingIntent = PendingIntent.getService(context, 0, notificationIntent, 0);
        alarmManager.set(AlarmManager.RTC, 0, pendingIntent);

        Log.d("JAMIEA", "Boot broadcast received");
    }
}
