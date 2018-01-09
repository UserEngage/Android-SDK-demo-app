package com.userengage.mobile_sdk_demo;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.userengage.userengagesdk.UserEngage;

/**
 * Remember to add FcmTokenService to AndroidManifest.xml
 */

public class FcmTokenService extends FirebaseInstanceIdService {
    /**
     * Notify UserEngage instance about FCM token refresh.
     */
    @Override
    public void onTokenRefresh() {
        UserEngage.getInstance().updateFCMKey(FirebaseInstanceId.getInstance().getToken());
        super.onTokenRefresh();
    }
}
