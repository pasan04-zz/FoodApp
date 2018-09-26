package com.google.hangout.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class breakfast_time extends AppCompatActivity {

    public Button but1;
    public Button but2;
    public Button but3;
    public Button but4;

    public void init(){

        but1 = (Button)findViewById(R.id.button1);
        but2 = (Button)findViewById(R.id.button2);
        but3 = (Button)findViewById(R.id.button3);
        but4 = (Button)findViewById(R.id.button4);

        but1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){

                Intent b1 = new Intent(breakfast_time.this,paymentOption.class);
                startActivity(b1);


            }


        });
        but2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){

                Intent b2 = new Intent(breakfast_time.this,paymentOption.class);
                startActivity(b2);


            }


        });
        but3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){

                Intent b3 = new Intent(breakfast_time.this,paymentOption.class);
                startActivity(b3);


            }


        });
        but4.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){

                Intent b4 = new Intent(breakfast_time.this,paymentOption.class);
                startActivity(b4);


            }


        });

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakfast_time);
        init();
    }
}
