package com.example.osman.restaurantmsandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.osman.restaurantmsandroid.domain.Customer;
import com.example.osman.restaurantmsandroid.repositories.CustomerRepository;
import com.example.osman.restaurantmsandroid.repositories.Impl.CustomerRepositoryImpl;

public class Preview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);

        Button submit =(Button)findViewById(R.id.btnSubmit);

        Intent i = getIntent();

        final Customer myClientCatch = (Customer)i.getSerializableExtra("ClientValue");

        Toast.makeText(Preview.this,myClientCatch.toString(),Toast.LENGTH_LONG).show();

        EditText myEdit = (EditText)findViewById(R.id.displayAlltxt);
        myEdit.setText(myClientCatch.toString());

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CustomerRepository repo = new CustomerRepositoryImpl(getApplicationContext());

                Customer insertedEntity =repo.save(myClientCatch);


                //Call the fourth activity
               Intent myIntent = new Intent(view.getContext(),last.class);
                startActivity(myIntent);

            }
        });

    }
}

