package com.google.hangout.myapp.sqlite.database.Controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.google.hangout.myapp.R;

public class dinner extends AppCompatActivity {

    public static final String Extra_Message ="finediner";
    public static final String quantity ="findiner12";
    public static final String pricePerItem ="finediner123";

    public final static String EXTRA_MESSAGE ="Pasan Kamburugamuwa";

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

                final ElegantNumberButton elegantNumberButton = (ElegantNumberButton) findViewById(R.id.myButton1);
                elegantNumberButton.setRange(0, 20);
                Intent b1 = new Intent(dinner.this,hoppers.class);
                String number = elegantNumberButton.getNumber();
                double elenumber = Double.parseDouble(number);
                if(elenumber==0 ){

                    Toast.makeText(dinner.this,"Quantity must be greater than zero",Toast.LENGTH_SHORT).show();
                }
                else if(elenumber>10){
                    Toast.makeText(dinner.this,"Not sufficient storage to supply your order",Toast.LENGTH_SHORT).show();
                }

                else{

                    TextView txtView = (TextView) findViewById(R.id.hoppersPrice);
                    double d1 = Double.parseDouble(txtView.getText().toString());
                    final double salesTaxPerItem = d1 * 10.0 / 100.0;
                    double salesTax  = salesTaxPerItem*elenumber;
                    String qty = String.valueOf(elenumber);
                    b1.putExtra(quantity,number);
                    String salesTax1 = String.valueOf(salesTax);
                    b1.putExtra(Extra_Message, salesTax1);
                    b1.putExtra(pricePerItem,txtView.getText().toString());

                    startActivity(b1);
                }
            }
        });





        but2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                final ElegantNumberButton elegantNumberButton2 = (ElegantNumberButton) findViewById(R.id.myButton2);
                elegantNumberButton2.setRange(0, 20);
                Intent b2 = new Intent(dinner.this,kottu.class);
                String number = elegantNumberButton2.getNumber();
                double elenumber = Double.parseDouble(number);
                if(elenumber==0 ){

                    Toast.makeText(dinner.this,"Quantity must be greater than zero",Toast.LENGTH_SHORT).show();
                }
                else if(elenumber>10){
                    Toast.makeText(dinner.this,"Not sufficient storage to supply your order",Toast.LENGTH_SHORT).show();
                }

                else{

                    TextView txtView = (TextView) findViewById(R.id.kottuPrice);
                    double d1 = Double.parseDouble(txtView.getText().toString());
                    final double salesTaxPerItem = d1 * 10.0 / 100.0;
                    double salesTax  = salesTaxPerItem*elenumber;
                    String qty = String.valueOf(elenumber);
                    b2.putExtra(quantity,number);
                    String salesTax1 = String.valueOf(salesTax);
                    b2.putExtra(Extra_Message, salesTax1);
                    b2.putExtra(pricePerItem,txtView.getText().toString());

                    startActivity(b2);
                }


            }

        });





        but3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                final ElegantNumberButton elegantNumberButton3 = (ElegantNumberButton) findViewById(R.id.myButton3);
                elegantNumberButton3.setRange(0, 20);
                Intent b3 = new Intent(dinner.this,noodles.class);
                String number = elegantNumberButton3.getNumber();
                double elenumber = Double.parseDouble(number);
                if(elenumber==0 ){

                    Toast.makeText(dinner.this,"Quantity must be greater than zero",Toast.LENGTH_SHORT).show();
                }
                else if(elenumber>10){
                    Toast.makeText(dinner.this,"Not sufficient storage to supply your order",Toast.LENGTH_SHORT).show();
                }

                else{

                    TextView txtView = (TextView) findViewById(R.id.noodleprice);
                    double d1 = Double.parseDouble(txtView.getText().toString());
                    final double salesTaxPerItem = d1 * 10.0 / 100.0;
                    double salesTax  = salesTaxPerItem*elenumber;
                    String qty = String.valueOf(elenumber);
                    b3.putExtra(quantity,number);
                    String salesTax1 = String.valueOf(salesTax);
                    b3.putExtra(Extra_Message, salesTax1);
                    b3.putExtra(pricePerItem,txtView.getText().toString());

                    startActivity(b3);
                }
            }

        });


        but4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                final ElegantNumberButton elegantNumberButton4 = (ElegantNumberButton) findViewById(R.id.myButton4);
                elegantNumberButton4.setRange(0, 20);
                Intent b4 = new Intent(dinner.this,stringhoppers.class);
                String number = elegantNumberButton4.getNumber();
                double elenumber = Double.parseDouble(number);
                if(elenumber==0 ){

                    Toast.makeText(dinner.this,"Quantity must be greater than zero",Toast.LENGTH_SHORT).show();
                }
                else if(elenumber>10){
                    Toast.makeText(dinner.this,"Not sufficient storage to supply your order",Toast.LENGTH_SHORT).show();
                }

                else{

                    TextView txtView = (TextView) findViewById(R.id.stringhopperprice);
                    double d1 = Double.parseDouble(txtView.getText().toString());
                    final double salesTaxPerItem = d1 * 10.0 / 100.0;
                    double salesTax  = salesTaxPerItem*elenumber;
                    String qty = String.valueOf(elenumber);
                    b4.putExtra(quantity,number);
                    String salesTax1 = String.valueOf(salesTax);
                    b4.putExtra(Extra_Message, salesTax1);
                    b4.putExtra(pricePerItem,txtView.getText().toString());

                    startActivity(b4);
                }
            }

        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinner);
        init();
    }
}
