package com.example.siddharthvaish.syo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class info extends AppCompatActivity {


    EditText name1;
    EditText email1;
    EditText adress1;
    EditText price1;
    EditText specification1;
    EditText phone1;
    Spinner category1;
    Spinner condition1;

    Button addimage1,submit1;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        name1= (EditText)findViewById(R.id.nameid);
        price1=(EditText)findViewById(R.id.priceid);
        email1=(EditText)findViewById(R.id.emailid);
        adress1 = (EditText)findViewById(R.id.addressid);
        specification1=(EditText)findViewById(R.id.specificationid);
        phone1=(EditText)findViewById(R.id.phoneid);
        category1=(Spinner) findViewById(R.id.spinnerid);
        condition1=(Spinner) findViewById(R.id.conditionspinner);
        addimage1=(Button) findViewById(R.id.addimage);
        submit1=(Button)findViewById(R.id.submitbtnid);
        databaseReference = FirebaseDatabase.getInstance().getReference("items");

        addimage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent int3= new Intent(info.this,SelectPicture.class);
                startActivity(int3);

            }
        });

        submit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                additem();

            }
        });

    }
    private void additem()
    {
        String name = name1.getText().toString().trim();
        String price=price1.getText().toString().trim();
        String email= email1.getText().toString().trim();
        String address = adress1.getText().toString().trim();
        String Phone =phone1.getText().toString().trim();
        String category = category1.getSelectedItem().toString();
        String specification =specification1.getText().toString().trim();
        String condition = condition1.getSelectedItem().toString();
        if(!TextUtils.isEmpty(name))
        {
            String id = databaseReference.push().getKey();

            Items items = new Items(id,name,email,address,specification,Phone,category,condition,price);
            databaseReference.child(id).setValue(items);

            Toast.makeText(this,"Item Added", Toast.LENGTH_LONG).show();
        }

        else
        {
            Toast.makeText(this,"You should enter your name", Toast.LENGTH_LONG).show();
        }

    }

}
