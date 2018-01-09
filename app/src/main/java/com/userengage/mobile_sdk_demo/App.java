package com.userengage.mobile_sdk_demo;

import android.app.Application;

import com.userengage.userengagesdk.UserEngage;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initUserEngage();
    }

    /**
     * Configure UserEngage instance.
     */
    private void initUserEngage() {
        UserEngage userEngage = new UserEngage.Builder()
                .context(this)
                .apiKey("123")
                .trackActivities()
                .build();
    }
}
