package com.google.hangout.myapp.sqlite.database.Controller;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.hangout.myapp.R;
import com.google.hangout.myapp.sqlite.database.utils.DatabaseHelper;

public class OrderDetails extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText editText_Name,editText_address1,editText_notices,editText_tele1,editText_ID1;
    TextView textView_id;

    Button btnSubmit,btnUpdate,btnDelete,btnView,addItems1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        myDb = new DatabaseHelper(this);
        Intent receiveIntent = this.getIntent();

        //all are working well,tested

        final String type = receiveIntent.getStringExtra(biriyani.type1);
        final String quantity = receiveIntent.getStringExtra(biriyani.quantity1);
        final String price = receiveIntent.getStringExtra(biriyani.price1);

        editText_ID1 =(EditText)findViewById(R.id.editText_ID);
        editText_Name = (EditText)findViewById(R.id.editText_name);
        editText_address1=(EditText)findViewById(R.id.editText_address);
        editText_notices =(EditText)findViewById(R.id.editText_notice);
        editText_tele1 =(EditText)findViewById(R.id.editText_tele);

        //editText_id1 =(EditText)findViewById(R.id.editText_id);
        btnSubmit = (Button)findViewById(R.id.submit);
        btnUpdate = (Button)findViewById(R.id.update);
        btnDelete = (Button)findViewById(R.id.delete);
        btnView = (Button)findViewById(R.id.viewDetails);
        addItems1 = (Button)findViewById(R.id.addItems);


        addItems1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){

                Intent b1 = new Intent(OrderDetails.this,MainActivity.class);
                startActivity(b1);


            }


        });


        addData();
        viewAll();
        deleteData();
        updateData();
    }

    public void updateData(){

        btnUpdate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean isUpdate = myDb.updateData(editText_ID1.getText().toString(),editText_Name.getText().toString(),
                                editText_address1.getText().toString(),editText_tele1.getText().toString());

                        if(isUpdate == true){
                            Toast.makeText(OrderDetails.this,"Data Update", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(OrderDetails.this,"Data not update",Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
    }

    public void deleteData(){
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Integer deleteRows = myDb.deleteData(editText_ID1.getText().toString());
                if(deleteRows > 0){
                    Toast.makeText(OrderDetails.this,"Data Deleted Succesfully ", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(OrderDetails.this,"Data not Deleted Succesfully",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


    public void addData() {
        Intent receiveIntent = this.getIntent();
        final String type = receiveIntent.getStringExtra(biriyani.type1);
        final String quantity = receiveIntent.getStringExtra(biriyani.quantity1);
        final String price = receiveIntent.getStringExtra(biriyani.price1);

        btnSubmit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean isInserted = myDb.insertData(editText_Name.getText().toString(),
                                editText_address1.getText().toString(),
                                editText_notices.getText().toString(),
                                type,quantity,price,
                                editText_tele1.getText().toString());
                        if (isInserted == true) {
                            Toast.makeText(OrderDetails.this, "Data Inserted ", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(OrderDetails.this, "Data not inserted", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
    }


    public void viewAll( ) {
            btnView.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Cursor res = myDb.getAllData();
                            if (res.getCount() == 0) {

                                //show message
                                showMessage("Error", "No Data Found");
                                return;
                            }

                            StringBuffer buffer = new StringBuffer();
                            while (res.moveToNext()) {
                                buffer.append("ID :" + res.getString(0) + "\n"); //
                                buffer.append("Item :" + res.getString(4) + "\n");  //
                                buffer.append("Quantity :" + res.getString(5) + "\n"); //
                                buffer.append("Price :" + res.getString(6) + "\n");  //
                                buffer.append("Receiver Name :" + res.getString(1) + "\n");
                                buffer.append("Tele :" + res.getString(7) + "\n");  //
                                buffer.append("Address :" + res.getString(2) + "\n");
                                buffer.append("Notices :" +res.getString(3)+"\n");


                            }
                            showMessage("Data", buffer.toString());

                        }
                    }

            );
    }

    public void showMessage(String title,String message){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();

    }


}
