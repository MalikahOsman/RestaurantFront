package com.example.osman.restaurantmsandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuOptions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_options);
    }

    //Button food = (Button) findViewById(R.id.menuBtn);


   /* food.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            Intent i = new Intent(getApplicationContext(), FoodMenu.class);
            startActivity(i);

        }
    });*/

}

