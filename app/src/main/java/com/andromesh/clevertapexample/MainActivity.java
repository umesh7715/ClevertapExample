package com.andromesh.clevertapexample;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.clevertap.android.sdk.CleverTapAPI;

import java.util.HashMap;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button productButton;
    private CleverTapAPI clevertapDefaultInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productButton = findViewById(R.id.button);

        clevertapDefaultInstance = CleverTapAPI.getDefaultInstance(getApplicationContext());


        productButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                HashMap<String, Object> profileUpdate = new HashMap<>();

                profileUpdate.put("Name", "Umesh Saravane");
                profileUpdate.put("Email", "dk-ume7715@gmail.com");

                clevertapDefaultInstance.pushProfile(profileUpdate);

                // event with properties
                HashMap<String, Object> prodViewedAction = new HashMap<>();
                prodViewedAction.put("Product Name", "CleverTap");
                prodViewedAction.put("Product Image", "https://d35fo82fjcw0y8.cloudfront.net/2018/07/26020307/customer-success-clevertap.jpg");
                prodViewedAction.put("Product ID", 1);

                clevertapDefaultInstance.pushEvent("Product Viewed", prodViewedAction);

            }
        });

    }
}
