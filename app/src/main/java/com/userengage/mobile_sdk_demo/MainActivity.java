package com.userengage.mobile_sdk_demo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.userengage.userengagesdk.UserEngage;

public class MainActivity extends AppCompatActivity {

    private static final String ATTRIBUTE_EXTRAS_ID = "ATTRIBUTE_EXTRAS_ID";

    static Intent createMainActivityIntent(Context context, String activity_attribute) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(ATTRIBUTE_EXTRAS_ID, activity_attribute);
        return intent;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.activity_main);
        findViewById(R.id.send_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserEngage.getInstance().sendEvent(new CustomEvent("asd", 137));
            }
        });
    }
}
