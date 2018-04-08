package com.example.siddharthvaish.syo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference myRef ;
    List<product> list;
    RecyclerView recycle;
    //Button view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //set();
        //view = (Button) findViewById(R.id.view);
        recycle = (RecyclerView) findViewById(R.id.recycle);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference().child("items");
        //myRef.setValue("Hello, World!");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                list = new ArrayList<product>();
                for(DataSnapshot dataSnapshot1 :dataSnapshot.getChildren()){

                    product value = dataSnapshot1.getValue(product.class);
                    product fire = new product();
                    String price = value.getPrice();
                    String name=value.getName();
                    String phone=value.getPhone();
                    String category=value.getCategory();
                    String specification=value.getSpecification();
                    String condition=value.getCondition();
                    String adress = value.getAdress();
                    String email = value.getEmail();
                    fire.setPrice(price);
                    fire.setEmail(email);
                    fire.setName(name);
                    fire.setPhone(phone);
                    fire.setCategory(category);
                    fire.setCondition(condition);
                    fire.setSpecification(specification);
                    fire.setAdress(adress);
                    list.add(fire);

                }
                RecyclerAdapter recyclerAdapter = new RecyclerAdapter(list,MainActivity.this);
                RecyclerView.LayoutManager recyce = new GridLayoutManager(MainActivity.this,3);
                /// RecyclerView.LayoutManager recyce = new LinearLayoutManager(MainActivity.this);
                // recycle.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
                recycle.setLayoutManager(recyce);
                recycle.setItemAnimator( new DefaultItemAnimator());
                recycle.setAdapter(recyclerAdapter);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Hello", "Failed to read value.", error.toException());
            }
        });



        /*view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                RecyclerAdapter recyclerAdapter = new RecyclerAdapter(list,MainActivity.this);
                RecyclerView.LayoutManager recyce = new GridLayoutManager(MainActivity.this,1);
                /// RecyclerView.LayoutManager recyce = new LinearLayoutManager(MainActivity.this);
                // recycle.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
                recycle.setLayoutManager(recyce);
                recycle.setItemAnimator( new DefaultItemAnimator());
                recycle.setAdapter(recyclerAdapter);




            }
        });*/


    }
    public void but(View view)
    {
        Intent intl= new Intent(this,info.class);
        startActivity(intl);
    }
    public void set(View view)
    {
        ImageView img=(ImageView)findViewById(R.id.overflow) ;
//   Picasso.with(this).load
        Picasso.with(this).load("https://www.google.co.in/imgres?imgurl=https%3A%2F%2F5.imimg.com%2Fdata5%2FWY%2FPF%2FMY-28261032%2Fair-cooler-250x250.jpg&imgrefurl=https%3A%2F%2Fwww.indiamart.com%2Fproddetail%2Ffiber-body-air-cooler-15271581791.html&docid=-zt-oVIJ7cg7WM&tbnid=oqqggUcIRZwBvM%3A&vet=10ahUKEwj6yKbaharaAhUHu48KHS6OBEUQMwiLAigAMAA..i&w=250&h=250&bih=686&biw=1536&q=cooler&ved=0ahUKEwj6yKbaharaAhUHu48KHS6OBEUQMwiLAigAMAA&iact=mrc&uact=8").placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(img,new com.squareup.picasso.Callback(){
                    @Override
                    public void onSuccess()
                    {

                    }
                    @Override
                    public void onError(){}
                });

    }
}