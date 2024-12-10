package com.jalsoft.android.eccormece;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SocialAdapter extends RecyclerView.Adapter<SocialAdapter.socialholder> {
    Context context;
    List<SocialModel> timelist;

    public SocialAdapter(Context context, List<SocialModel> timelist) {
        this.context = context;
        this.timelist = timelist;
    }

    @NonNull
    @Override
    public socialholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.social_holder,parent,false);
        socialholder socialholder = new socialholder(view);
        return socialholder;
    }

    @Override
    public void onBindViewHolder(@NonNull socialholder holder, int position) {
        SocialModel model = timelist.get(position);
        holder.postedTime.setText(model.getPostedTime());
        holder.postedBy.setText("By: "+model.getPostedBy());
    }

    @Override
    public int getItemCount() {
        return timelist.size();
    }

    public static class socialholder extends RecyclerView.ViewHolder {
    TextView postedBy,postedTime;
        public socialholder(@NonNull View itemView) {
            super(itemView);
            postedBy = itemView.findViewById(R.id.postedBy);
            postedTime = itemView.findViewById(R.id.postedTime);
        }
    }
}
