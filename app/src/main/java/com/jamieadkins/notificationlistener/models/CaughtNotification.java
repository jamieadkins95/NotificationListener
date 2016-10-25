package com.jamieadkins.notificationlistener.models;

import android.service.notification.StatusBarNotification;

import com.orm.SugarRecord;
import com.orm.dsl.Table;

/**
 * Created by jamiea on 25/10/16.
 */
@Table
public class CaughtNotification extends SugarRecord {
    private long id;

    private int mNotificationId;
    private String mPackageName;
    private long mPostTime;
    private String mTag;
    private String mStringRepresentation;

    public CaughtNotification() {
        // Empty constructor required for ORM.
    }

    public CaughtNotification(StatusBarNotification notification) {
        mNotificationId = notification.getId();
        mPackageName = notification.getPackageName();
        mPostTime = notification.getPostTime();
        mTag = notification.getTag();
        mStringRepresentation = notification.toString();
    }

    public Long getId() {
        return id;
    }
}
