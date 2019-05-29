package com.example.ldd2tuan2;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.PhepTinhviewHolder> {
    private List<pheptinh> pheptinhList;
    private Activity activity;

    public Adapter(Activity activity, List<pheptinh> pheptinhList) {
        this.activity = activity;
        this.pheptinhList = pheptinhList;
    }

    public class PhepTinhviewHolder extends RecyclerView.ViewHolder {
        private TextView SoA;
        private TextView SoB;
        private TextView KQ;
        private ImageView icon;

        public PhepTinhviewHolder(@NonNull View itemView) {
            super(itemView);
            SoA = (TextView) itemView.findViewById(R.id.txtma);
            SoB = (TextView) itemView.findViewById(R.id.txtTen);
            icon = (ImageView) itemView.findViewById(R.id.image);
        }
    }

    @NonNull
    @Override
    public PhepTinhviewHolder onCreateViewHolder(ViewGroup parent, int vewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view, parent, false);
        return new PhepTinhviewHolder(view);

    }

    @Override
    public void onBindViewHolder(PhepTinhviewHolder holder, final int position) {
        final pheptinh pheptinh = pheptinhList.get(position);
        holder.SoA.setText(pheptinh.getMa());
        holder.SoB.setText(pheptinh.getTen());
        holder.icon.setImageResource(pheptinh.getImg());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeItem(position);
                Toast.makeText(activity, "Xoa Thanh Cong", Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public int getItemCount() {
        return pheptinhList.size();
    }

    public void removeItem(int position) {
        pheptinhList.remove(position);
        notifyItemRemoved(position);
    }


}
