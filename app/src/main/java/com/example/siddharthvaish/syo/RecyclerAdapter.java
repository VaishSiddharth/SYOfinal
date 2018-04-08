package com.example.siddharthvaish.syo;

/**
 * Created by Siddharth Vaish on 4/8/2018.
 */import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by csa on 3/7/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyHoder>{

    List<product> list;
    Context context;

    public RecyclerAdapter(List<product> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyHoder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.card,parent,false);
        MyHoder myHoder = new MyHoder(view);


        return myHoder;
    }

    @Override
    public void onBindViewHolder(MyHoder holder, final int position) {
        final product mylist = list.get(position);
        holder.price.setText(mylist.getPrice());
        //holder.img.setImageURI(mylist.getImage());
        holder.email.setText(mylist.getEmail());
        holder.address.setText(mylist.getAdress());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context,sellproductinfo.class);

                // passing data to the book activity
                intent.putExtra("Price",list.get(position).getPrice());
                intent.putExtra("Address",list.get(position).getAdress());
                intent.putExtra("Email",list.get(position).getEmail());
                intent.putExtra("Name",list.get(position).getName());
                intent.putExtra("Phone",list.get(position).getPhone());
                intent.putExtra("Condition",list.get(position).getCondition());
                intent.putExtra("Category",list.get(position).getCategory());
                intent.putExtra("Specification",list.get(position).getSpecification());
                // start the activity
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {

        int arr = 0;

        try{
            if(list.size()==0){

                arr = 0;

            }
            else{

                arr=list.size();
            }



        }catch (Exception e){



        }

        return arr;

    }

    class MyHoder extends RecyclerView.ViewHolder {
        TextView price,email,address;
        CardView cardView ;
        ImageView img;

        public MyHoder(View itemView) {
            super(itemView);
            img=(ImageView)itemView.findViewById(R.id.overflow);
            price = (TextView) itemView.findViewById(R.id.price);
            email= (TextView) itemView.findViewById(R.id.vemail);
            address= (TextView) itemView.findViewById(R.id.vaddress);
            cardView = (CardView) itemView.findViewById(R.id.card_view);

        }

    }

}