package com.example.smartfarming;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Dashboard_screen extends AppCompatActivity
{
    RecyclerView rcv;
    myadapter adapter;
    ImageView iv_menu;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_screen);

        rcv=(RecyclerView)findViewById(R.id.recview);
        iv_menu=(ImageView) findViewById(R.id.iv_menu);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        rcv.setLayoutManager(new LinearLayoutManager(this));
        
        adapter=new myadapter(dataqueue());
        rcv.setAdapter(adapter);

        iv_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
                
    }
    
    public ArrayList<model> dataqueue()
    {
        ArrayList<model> holder=new ArrayList<>();

        model ob1=new model();
        ob1.setHeader("Farming Tools");
        ob1.setDesc("View All");
        ob1.setImgname(R.drawable.farm_tools);
        holder.add(ob1);

        model ob2=new model();
        ob2.setHeader("Gardening Tools");
        ob2.setDesc("View All");
        ob2.setImgname(R.drawable.gardening);
        holder.add(ob2);

        model ob3=new model();
        ob3.setHeader("Grains Seeds");
        ob3.setDesc("View All");
        ob3.setImgname(R.drawable.grains);
        holder.add(ob3);

        model ob4=new model();
        ob4.setHeader("Vegetables Seeds");
        ob4.setDesc("View All");
        ob4.setImgname(R.drawable.vegetable);
        holder.add(ob4);

        model ob5=new model();
        ob5.setHeader("Fruits Seeds");
        ob5.setDesc("View All");
        ob5.setImgname(R.drawable.fruits);
        holder.add(ob5);

        model ob6=new model();
        ob6.setHeader("Flowers Plants");
        ob6.setDesc("View All");
        ob6.setImgname(R.drawable.flower_plants);
        holder.add(ob6);


        return holder;
        
    }

    public class myadapter extends RecyclerView.Adapter<myadapter.myviewholder>

    {
        ArrayList<model> data;




        public myadapter(ArrayList<model> data)
        {
            this.data = data;

        }

        @NonNull
        @Override
        public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            LayoutInflater inflater=LayoutInflater.from(parent.getContext());
            View view=inflater.inflate(R.layout.single_raw_dashboard,parent,false);
            return new myviewholder(view);

        }

        @Override
        public void onBindViewHolder(@NonNull myviewholder holder, int position)
        {


            holder.t1.setText(data.get(position).getHeader());
            holder.t2.setText(data.get(position).getDesc());
           // holder.t2.setTextColor(Color.parseColor(AppConstant.bgColor1[position]));
            holder.img.setImageResource(data.get(position).getImgname());
            holder.card.setBackgroundColor(Color.parseColor(AppConstant.bgColor[position]));
            holder.t2.setBackgroundColor(Color.parseColor(AppConstant.bgColor1[position]));

            holder.t2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(Dashboard_screen.this,Farming_tools_screen.class));
                }
            });


        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        public class myviewholder extends RecyclerView.ViewHolder
        {

            ImageView img;
            TextView t1,t2;
            CardView card;

            public myviewholder(@NonNull View itemView)
            {
                super(itemView);
                img=(ImageView)itemView.findViewById(R.id.img1);
                t1=(TextView)itemView.findViewById(R.id.t1);
                t2=(TextView)itemView.findViewById(R.id.t2);
                card=itemView.findViewById(R.id.card);
            }


        }


    }

}