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
                .apiKey("wUfNyt2BL21ooUEtKGkA5sG8hlevjvtVL8ZqBbmTSSoWffdK26j2JeFKeCnfeF2c")
                .baseUrl("http://10.0.2.2:8000/") //use only if you have self hosted UE engine
                .trackActivities()
                .build();
    }
}
