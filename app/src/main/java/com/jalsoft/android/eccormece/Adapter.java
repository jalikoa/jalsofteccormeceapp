package com.jalsoft.android.eccormece;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.allstudents> {
    Context context;
    List<Model> modelList;

    public Adapter(Context context, List<Model> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public allstudents onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.contents,parent,false);
        allstudents allstudents = new allstudents(view);
        return allstudents;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull allstudents holder, int position) {
    Model model = modelList.get(position);
        holder.regno.setText("Reg No: "+ model.getRegno());
        holder.fullname.setText("Full Name: "+ model.getFullname());
        holder.gender.setText("Gender: "+ model.getGender());
        holder.program.setText("Programe: "+ model.getProgram());
        holder.college.setText("College: "+ model.getCollege());
        holder.date.setText("Registered: "+ model.getDate());
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    //    This next class will fetch the view holder
    public static class allstudents extends RecyclerView.ViewHolder{
    TextView regno,fullname,gender,program,college,date;
    public allstudents(@NonNull View itemView) {
        super(itemView);
        regno = itemView.findViewById(R.id.regno);
        fullname = itemView.findViewById(R.id.fullname);
        gender = itemView.findViewById(R.id.gender);
        program = itemView.findViewById(R.id.program);
        college = itemView.findViewById(R.id.college);
        date = itemView.findViewById(R.id.date);

    }
}
}
