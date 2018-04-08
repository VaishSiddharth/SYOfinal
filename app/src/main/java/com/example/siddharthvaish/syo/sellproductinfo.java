package com.example.siddharthvaish.syo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class sellproductinfo extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference myRef ;
    List<product> list;
    String name;
    String price;
    String email;
    String address;
    String Phone;
    String category;
    String specification;
    String condition;
    TextView name1;
    TextView price1;
    TextView email1;
    TextView address1;
    TextView Phone1;
    TextView category1;
    TextView specification1;
    TextView condition1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sellproductinfo);
        name1 = (TextView) findViewById(R.id.nameview);
        price1 = (TextView) findViewById(R.id.priceview);
        email1 = (TextView) findViewById(R.id.emailview);
        address1 = (TextView) findViewById(R.id.addressview);
        Phone1 = (TextView) findViewById(R.id.phoneview);
        category1 = (TextView) findViewById(R.id.categoryview);
        specification1 = (TextView) findViewById(R.id.specificationview);
        condition1 = (TextView) findViewById(R.id.conditionview);
        Intent intent = getIntent();
        price = intent.getExtras().getString("Price");
        name = intent.getExtras().getString("Name");
        email = intent.getExtras().getString("Email");
        Phone = intent.getExtras().getString("Phone");
        address = intent.getExtras().getString("Address");
        specification = intent.getExtras().getString("Specification");
        category = intent.getExtras().getString("Category");
        condition = intent.getExtras().getString("Condition");
        //name1.setText(Title);
                /*name1 = (TextView) findViewById(R.id.nameview);
                price1 = (TextView) findViewById(R.id.priceview);
                email1 = (TextView) findViewById(R.id.emailview);
                address1 = (TextView) findViewById(R.id.addressview);
                Phone1 = (TextView) findViewById(R.id.phoneview);
                category1 = (TextView) findViewById(R.id.categoryview);
                specification1 = (TextView) findViewById(R.id.specificationview);
                condition1 = (TextView) findViewById(R.id.conditionview);*/




                //name1.setText(name);
        price1.setText(price);
        email1.setText(email);
        address1.setText(address);
        Phone1.setText(Phone);
        name1.setText(name);
        category1.setText(category);
        condition1.setText(condition);
        specification1.setText(specification);

                //Phone1.setText(Phone);
                //category1.setText(category);
                //specification1.setText(specification);
                //condition1.setText(condition);
    }
    public void buy(View view)
    {
        Intent intin=new Intent (this,MainActivity.class);
        myRef.child(myRef.getKey()).removeValue();
    }
}
