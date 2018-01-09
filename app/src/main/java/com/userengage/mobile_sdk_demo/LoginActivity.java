package com.userengage.mobile_sdk_demo;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.userengage.userengagesdk.UserEngage;
import com.userengage.userengagesdk.customer.Customer;
import com.userengage.userengagesdk.customer.CustomerManager;
import com.userengage.userengagesdk.customer.CustomerUpdateCallback;
import com.userengage.userengagesdk.customer.RegisterResponse;

import java.util.UUID;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    public static final String TAG = LoginActivity.class.getSimpleName();

    private EditText firstNameText, lastNameText, emailText, passwordText, customNumberAttributeText, customTextAttributeText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.activity_login);
        // Set up the login form.

        findViewById(R.id.sing_in_button).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });

        firstNameText = findViewById(R.id.name);
        lastNameText = findViewById(R.id.last_name);
        emailText = findViewById(R.id.email);
        customNumberAttributeText = findViewById(R.id.custom_number_attribute);
        customTextAttributeText = findViewById(R.id.custom_string_attribute);
    }

    private void attemptLogin() {

        String id = UUID.randomUUID().toString();

        String firstName = firstNameText.getText().toString();
        String lastName = lastNameText.getText().toString();
        String email = emailText.getText().toString();
        String custom_attribute_one = customTextAttributeText.getText().toString();

        int custom_attribute_two = 0;
        try{
            custom_attribute_two = Integer.valueOf(customNumberAttributeText.getText().toString());
        }
        catch (NumberFormatException e){
            Log.e(TAG, "attemptLogin: ", e);
        }

        String fcmToken = FirebaseInstanceId.getInstance().getToken();

                Customer customer = new Customer()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .attr("custom_attribute_one", custom_attribute_one)
                .attr("custom_attribute_two", custom_attribute_two);

        UserEngage.getInstance().register(customer, fcmToken, new CustomerUpdateCallback() {
            @Override
            public void onSuccess(RegisterResponse response) {
                startActivity(MainActivity.createMainActivityIntent(getApplicationContext(), "custom_attribute"));
            }

            @Override
            public void onFailure(Throwable throwable) {
                Log.e(TAG, "onFailure: ", throwable);
                Toast.makeText(getApplicationContext(), R.string.error_register, Toast.LENGTH_SHORT).show();
                startActivity(MainActivity.createMainActivityIntent(getApplicationContext(), "custom_attribute"));

            }
        });
    }

}

