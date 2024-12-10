package com.jalsoft.android.eccormece;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FileAdapter extends RecyclerView.Adapter<FileAdapter.fileHolder> {
    Context context;
    List<FileModel> fileList;

    public FileAdapter(Context context, List<FileModel> fileList) {
        this.context = context;
        this.fileList = fileList;
    }

    @NonNull
    @Override
    public fileHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.file_holder,parent,false);
        fileHolder fileHolder = new fileHolder(view);
        return fileHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull fileHolder holder, int position) {
        FileModel fileModel = fileList.get(position);
        holder.fileName.setText(fileModel.getFileName());
        holder.fileDescription.setText(fileModel.getFileDescription());
        holder.dateUploaded.setText(fileModel.getDateFilePosted());
    }

    @Override
    public int getItemCount() {
        return fileList.size();
    }

    public static class fileHolder extends RecyclerView.ViewHolder {
        TextView fileName,fileDescription,dateUploaded;
        public fileHolder(@NonNull View itemView) {
            super(itemView);
            fileName = itemView.findViewById(R.id.fileName);
            fileDescription = itemView.findViewById(R.id.byWho);
            dateUploaded = itemView.findViewById(R.id.postedTime);
        }
    }
}
