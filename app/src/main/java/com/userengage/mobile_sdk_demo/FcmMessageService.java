package com.userengage.mobile_sdk_demo;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.userengage.userengagesdk.UserEngage;

/**
 * Remember to add FcmMessageService to AndroidManifest.xml
 */

public class FcmMessageService extends FirebaseMessagingService {


    /**
     * Pass notification data to UserEngage instance.
     * Only notification with UserNotification tag will be processed, there's no need to check that here.
     */
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        UserEngage.getInstance().onNotification(remoteMessage.getData(), getApplicationContext());
        super.onMessageReceived(remoteMessage);
    }
}
