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

public class Adapter2 extends RecyclerView.Adapter<Adapter.allstudents> {
    Context context;
    List<Model2>model2List;

    public Adapter2(Context context, List<Model2> model2List) {
        this.context = context;
        this.model2List = model2List;
    }
@NonNull
@Override
public Adapter.allstudents onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout.contents,parent,false);
    Adapter.allstudents allstudents = new Adapter.allstudents(view);
    return allstudents;
}

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull Adapter.allstudents holder, int position) {
        Model2 model2 = model2List.get(position);
        holder.regno.setText("ADM no: "+model2.getRegno());
        holder.fullname.setText("Name: "+model2.getFullname());
        holder.gender.setText("Gender: "+model2.getGender());
        holder.program.setText("Program: "+model2.getRegno());
        holder.college.setText("College: "+model2.getCollege());
        holder.date.setText("Date of registration"+model2.getDate());
    }

    @Override
    public int getItemCount() {
        return model2List.size();
    }

    public static class allstudents extends RecyclerView.ViewHolder {
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
