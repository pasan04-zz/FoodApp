package com.google.hangout.myapp.sqlite.database.Controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.hangout.myapp.R;

public class paymentOption extends AppCompatActivity {

    public Button but1;


    public void init(){

        but1 = (Button)findViewById(R.id.button1);


        but1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){

                Intent b1 = new Intent(paymentOption.this,payment.class);
                startActivity(b1);


            }


        });



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_option);
        init();
    }
}
