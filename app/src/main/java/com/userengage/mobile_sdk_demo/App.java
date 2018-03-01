package com.userengage.mobile_sdk_demo;

import android.app.Application;

import com.userengage.userengagesdk.UserEngage;
import com.userengage.userengagesdk.notifications.NotificationAction;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
                .apiKey("<api key generated in Userengage web panel>")
                .baseUrl("https://app.userengage.com/api/sdk/v1/") //use only if you have self hosted UE engine
                .notificationRoutes(getRoutesAction())
                .trackActivities()
                .build();
    }

    private static List<NotificationAction> getRoutesAction(){

        Set<String> intentKeys = new HashSet<>();

        List<NotificationAction> actionList = new ArrayList<>();

        actionList.add(new NotificationAction(MainActivity.class, intentKeys));

        return actionList;
    }
}
