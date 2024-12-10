package com.jalsoft.android.eccormece;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity4 extends AppCompatActivity {
    RecyclerView recyclerView;
    LinearLayout linearLayout;
    SocialAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        recyclerView = findViewById(R.id.recycle);
        linearLayout = findViewById(R.id.errorLayout);
        List<SocialModel>list;
        list = new ArrayList<>();
        adapter = new SocialAdapter(this,list);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        int j = 30;
        for(int i = 0;i < j;i++){
            list.add(new SocialModel("5 days ago","Jalikoa Ceo Jalsoft"));
        }

    }
}