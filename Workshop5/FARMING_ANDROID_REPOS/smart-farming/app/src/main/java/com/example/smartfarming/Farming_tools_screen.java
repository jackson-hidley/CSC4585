package com.example.smartfarming;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Farming_tools_screen extends AppCompatActivity {

    RecyclerView rcv1;
    RecyclerView.LayoutManager layoutManager;
    ImageView ivback;
    Farmingadapter farmingadapter;
    ArrayList<model1> myListdata =new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farming_tools_screen);

        rcv1=(RecyclerView)findViewById(R.id.recview1);
        ivback=(ImageView)findViewById(R.id.ivback);

        rcv1.setLayoutManager(new GridLayoutManager(this,2));


        rcv1.setAdapter(new Farmingadapter(Farming_tools_screen.this));

        creatFarmingWithTools();

        ivback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Farming_tools_screen.this,Dashboard_screen.class));
            }
        });

    }

    private void creatFarmingWithTools()
    {
        model1 ob1=new model1();
        ob1.setName("Sickle");
        ob1.setPrice("Price:136.00");
        ob1.setImg1(R.drawable.sickle);
        myListdata.add(ob1);

        model1 ob2=new model1();
        ob2.setName("Hoe");
        ob2.setPrice("Price:789.00");
        ob2.setImg1(R.drawable.hoe);
        myListdata.add(ob2);

        model1 ob3=new model1();
        ob3.setName("Axe");
        ob3.setPrice("Price:1000.00");
        ob3.setImg1(R.drawable.axe2);
        myListdata.add(ob3);

        model1 ob4=new model1();
        ob4.setName("Plough");
        ob4.setPrice("Price:1100.00");
        ob4.setImg1(R.drawable.plough);
        myListdata.add(ob4);

        model1 ob5=new model1();
        ob5.setName("Pump");
        ob5.setPrice("Price:1,239.00");
        ob5.setImg1(R.drawable.pump);
        myListdata.add(ob5);

        model1 ob6=new model1();
        ob6.setName("Irrigation pipe");
        ob6.setPrice("Price:650.00");
        ob6.setImg1(R.drawable.pipe);
        myListdata.add(ob6);

        model1 ob7=new model1();
        ob7.setName("Mattock");
        ob7.setPrice("Price:595.00");
        ob7.setImg1(R.drawable.mattock);
        myListdata.add(ob7);

        model1 ob8=new model1();
        ob8.setName("Rake");
        ob8.setPrice("Price:509.00");
        ob8.setImg1(R.drawable.rake);
        myListdata.add(ob8);

        model1 ob9=new model1();
        ob9.setName("Small rake");
        ob9.setPrice("Price:475.00");
        ob9.setImg1(R.drawable.small_rake);
        myListdata.add(ob9);

        model1 ob10=new model1();
        ob10.setName("Tractor");
        ob10.setPrice("Price:7,15,057.00");
        ob10.setImg1(R.drawable.tractor);
        myListdata.add(ob10);

        model1 ob11=new model1();
        ob11.setName("Thresher");
        ob11.setPrice("Price:57,642.00");
        ob11.setImg1(R.drawable.thresher);
        myListdata.add(ob11);

        model1 ob12=new model1();
        ob12.setName("Seeds driller ");
        ob12.setPrice("Price:10,200.00");
        ob12.setImg1(R.drawable.seeds);
        myListdata.add(ob12);

        model1 ob13=new model1();
        ob13.setName("Watering pump ");
        ob13.setPrice("Price:500.00");
        ob13.setImg1(R.drawable.water_pumpp);
        myListdata.add(ob13);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mainmenu,menu);
        MenuItem item=menu.findItem(R.id.search_menu);

        SearchView searchView=(SearchView)item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                farmingadapter.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    public class Farmingadapter extends RecyclerView.Adapter<Farmingadapter.Myviewholder> implements Filterable
    {

        ArrayList<model1> backup;
        Context ctx;

        public Farmingadapter(Context ctx) {
            this.ctx=ctx;
           // backup=new ArrayList<>(myListdata);
        }

        @NonNull
        @Override
        public Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
        {

            View view=LayoutInflater.from(ctx).inflate(R.layout.single_raw_general,parent,false);
            return new Myviewholder(view);

        }

        @Override
        public void onBindViewHolder(@NonNull Myviewholder holder, int position)
        {
             holder.tvname.setText(myListdata.get(position).getName());
            holder.tvprice.setText(myListdata.get(position).getPrice());
            holder.ivlaunch.setImageResource(myListdata.get(position).getImg1());

            holder.card1.setBackgroundColor(Color.parseColor(AppConstant.bgColor[position]));
            holder.card1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(Farming_tools_screen.this,Buyitem.class));

                }
            });


        }

        @Override
        public int getItemCount() {
            return myListdata.size();
        }

        @Override
        public Filter getFilter() {

            return filter;
        }

        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence keyword) {
                ArrayList<model1> filtereddata=new ArrayList<>();

                if (keyword.toString().isEmpty())
                    filtereddata.addAll(backup);
                else
                {
                    for (model1 obj : backup)
                    {
                        if (obj.getName().toString().toLowerCase().contains(keyword.toString().toLowerCase()))
                            filtereddata.add(obj);
                    }
                }
                FilterResults results=new FilterResults();
                results.values=filtereddata;
                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results)
            {
                myListdata.clear();
                myListdata.addAll((ArrayList<model1>)results.values);
                notifyDataSetChanged();

            }
        };

        public class Myviewholder extends RecyclerView.ViewHolder{

            ImageView ivlaunch;
            TextView tvname,tvprice;
            CardView card1;

            public Myviewholder(@NonNull View itemView) {

                super(itemView);
                ivlaunch=(ImageView)itemView.findViewById(R.id.ivlaunch);
                tvname=(TextView)itemView.findViewById(R.id.tvname);
                tvprice=(TextView)itemView.findViewById(R.id.tvprice);
                card1=itemView.findViewById(R.id.card1);
            }
        }
    }
}