package com.example.osman.restaurantmsandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Osman on 2016-09-02.
 */
public class RestaurantWelcome extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurant_welcome);

        Button menu = (Button) findViewById(R.id.menuBtn);


        menu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MenuOptions.class);
                startActivity(i);

            }
        });

    }
}
