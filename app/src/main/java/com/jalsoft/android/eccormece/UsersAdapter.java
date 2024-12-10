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

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.usersClass> {
    Context context;
    List<usersModel> list;

    public UsersAdapter(Context context, List<usersModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public usersClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.users_holder,parent,false);
        usersClass usersClass = new usersClass(view);
        return usersClass;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull usersClass holder, int position) {
        usersModel usersModel = list.get(position);
        holder.regId.setText("Reg Id: "+usersModel.getRegId());
        holder.userName.setText("User Name: "+usersModel.getUserName());
        holder.userGender.setText("Gender: "+usersModel.getGender());
        holder.userPhone.setText("User Phone: "+usersModel.getUserPhone());
        holder.aboutUser.setText("About: "+usersModel.getAbout());
        holder.userCountry.setText("User Country: "+usersModel.getUserCountry());
        holder.registeredDate.setText("Registered: "+usersModel.getRegisteredDate());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public static class usersClass extends RecyclerView.ViewHolder {
        TextView regId,userName,userGender,userPhone,aboutUser,userCountry,registeredDate;
        public usersClass(@NonNull View itemView) {
            super(itemView);

            regId = itemView.findViewById(R.id.regno);
            userName = itemView.findViewById(R.id.fullname);
            userGender = itemView.findViewById(R.id.gender);
            userPhone = itemView.findViewById(R.id.phone);
            aboutUser = itemView.findViewById(R.id.about);
            userCountry = itemView.findViewById(R.id.country);
            registeredDate = itemView.findViewById(R.id.date);

        }
    }
}
