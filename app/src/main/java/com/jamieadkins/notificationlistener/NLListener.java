package com.jamieadkins.notificationlistener;

import android.content.Intent;
import android.os.IBinder;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;

import com.jamieadkins.notificationlistener.models.CaughtNotification;

/**
 * Service that listens to notifications.
 */

public class NLListener extends NotificationListenerService {

    @Override
    public IBinder onBind(Intent intent) {
        Log.d("JAMIEA", "Listener bound");
        return super.onBind(intent);
    }

    @Override
    public void onNotificationPosted(StatusBarNotification statusBarNotification) {
        CaughtNotification notification = new CaughtNotification(statusBarNotification);
        notification.save();
        Log.d("JAMIEA", "New notification from " + statusBarNotification.getPackageName());
    }
}
