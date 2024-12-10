package com.jalsoft.android.eccormece;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class FilesList extends AppCompatActivity {
    RecyclerView recyclerView;
    RelativeLayout relativeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_files_list);
        List<FileModel> fileList;
        fileList = new ArrayList<>();
        FileAdapter fileAdapter = new FileAdapter(this,fileList);
        recyclerView = findViewById(R.id.recycle1);
        relativeLayout = findViewById(R.id.mainLayout1);
        recyclerView.setAdapter(fileAdapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        int j = 2;
        for (int i = 0;i < j;i++){

            fileList.add(new FileModel("How to plant a tree in the dry conditions How to plant a tree in the dry conditions.pptx","By Michael Mboya on how to make trees","On September Friday 10 2024"));
            fileList.add(new FileModel("Making the best out of bees.pptx","By Calvince Owino Jalikoa making bees for pollination","12/12/2025"));
            fileList.add(new FileModel("Doing cleaning in an effective way .pptx","By James Momanyi How to do cleaning effectively","On August Monday 10 2014"));
        }
            }
}