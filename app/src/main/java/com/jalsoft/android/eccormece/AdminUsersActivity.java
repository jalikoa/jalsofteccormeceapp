package com.jalsoft.android.eccormece;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.RelativeLayout;
import java.util.ArrayList;
import java.util.List;

public class AdminUsersActivity extends AppCompatActivity {
    RelativeLayout relativeLayout;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_users2);
        recyclerView = findViewById(R.id.recycle);
        relativeLayout = findViewById(R.id.mainLayout);
        List<usersModel> list;
        list = new ArrayList<>();
        UsersAdapter UsersAdapter = new UsersAdapter(this,list);
        recyclerView.setAdapter(UsersAdapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        int j = 30;
        for (int i=0;i<j;i+=1) {
            list.add(new usersModel("123/ghaiu/hui","ceojalsoft","male","0714192260","I am an engineer","Kenya","March Sunday 10 2022"));
        }
    }

}