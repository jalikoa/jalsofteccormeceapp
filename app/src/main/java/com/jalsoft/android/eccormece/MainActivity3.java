package com.jalsoft.android.eccormece;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {
    RecyclerView recyclerView;
    LinearLayout errorLayout;
    ImageButton searchBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        recyclerView = findViewById(R.id.recycle);
        errorLayout = findViewById(R.id.errorLayout);
        searchBtn = findViewById(R.id.search_btn);
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(errorLayout,"Coming soon",Snackbar.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
                startActivity(intent);
            }
        });
        List<Model2> model2List;
        model2List = new ArrayList<>();
        Adapter2 adapter2 = new Adapter2(this,model2List);
        recyclerView.setAdapter(adapter2);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        int ghai = 50;
        for (int i = 0; i < ghai; i++) {
            model2List.add(new Model2("6394/ceoJalsoft","Calvince Owino","Male","Engineering","Moi university","Sunday 12 Aug 2013"));
            model2List.add(new Model2("2094/ceoJalsoft","Mercy Chelagat","female","Medicine(surgery)","Kenyatta university","Friday 12 Aug 2020"));
            model2List.add(new Model2("6889/ceoJalsoft","James Ogweno","Male","Enducation arts","University os Nairobi","Tuesday 12 Dec 2017"));
        }
    }
}