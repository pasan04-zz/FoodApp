package com.google.hangout.myapp.sqlite.database.Controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.hangout.myapp.R;


//Lunch

public class MainActivity extends AppCompatActivity {

    public Button but1;
    public Button but2;
    public Button but3;

    public void init(){

        but1 = (Button)findViewById(R.id.but1);
        but2 = (Button)findViewById(R.id.but2);
        but3 = (Button)findViewById(R.id.but3);

        but1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){

                Intent b1 = new Intent(MainActivity.this,breakfast.class);
                startActivity(b1);
                Toast.makeText(MainActivity.this,"You have chosen Breakfast!",Toast.LENGTH_SHORT).show();


            }


        });
        but2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){

                Intent b2 = new Intent(MainActivity.this,lunch.class);
                startActivity(b2);
                Toast.makeText(MainActivity.this,"You have chosen Lunch!",Toast.LENGTH_SHORT).show();


            }


        });
        but3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){

                Intent b3 = new Intent(MainActivity.this,dinner.class);
                startActivity(b3);
                Toast.makeText(MainActivity.this,"You have chosen Dinner!",Toast.LENGTH_SHORT).show();


            }


        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }
}
