package com.example.exe4;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder>{
    Context context;
    private List<Comment> CommentList = null;
    int layoutResource;

    public static String BUNDLE = "bundle";
    public static String imgSrc = "src";
    @NonNull
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View row = inflater.inflate(layoutResource,viewGroup,false);
        return new MyViewHolder(row);
    }

    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {

        myViewHolder.txtTieuDe.setText(CommentList.get(i).getTxtTieuDe());
        myViewHolder.imageView.setImageResource(CommentList.get(i).getImage());

        //xử lý các sự kiện. VD: giữ xóa một item ...
        myViewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                return false;
            }});
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,DetailUser.class);
                Bundle bundle = new Bundle();

                bundle.putInt(imgSrc,CommentList.get(i).getImage());
                intent.putExtra(BUNDLE,bundle);
                context.startActivity(intent);
            }
        });
    }

    public int getItemCount() {
        return CommentList.size();
    }

    public Adapter(Context context, List<Comment> CommentList, int layoutResource) {
        this.context = context;
        this.CommentList = CommentList;
        this.layoutResource = layoutResource;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView txtTieuDe;
        public MyViewHolder(View itemView){
            super(itemView);
            txtTieuDe = itemView.findViewById(R.id.txtTieuDe);
            imageView = itemView.findViewById(R.id.image);
        }
    }
}
