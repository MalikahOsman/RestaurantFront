package com.example.osman.restaurantmsandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.osman.restaurantmsandroid.domain.Customer;


public class Login extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button btnlogin = (Button) findViewById(R.id.loginButton);

        final EditText fname = (EditText) findViewById(R.id.customerNameTxt);
        final EditText lname = (EditText)findViewById(R.id.customerNumberTxt);
        final EditText idlong = (EditText)findViewById(R.id.idlong);


        btnlogin.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                String firstName = fname.getText().toString();
                String lastName = lname.getText().toString();
                Long longId = Long.parseLong(idlong.getText().toString());


                Customer myClient = new Customer.Builder()
                        .id(longId)
                        .custName(firstName)
                        .custNum(lastName)
                        .build();

                Intent myIntent = new Intent(view.getContext(),Preview.class);
                myIntent.putExtra("ClientValue",myClient);

                startActivity(myIntent);
            }
        });



    }



}
