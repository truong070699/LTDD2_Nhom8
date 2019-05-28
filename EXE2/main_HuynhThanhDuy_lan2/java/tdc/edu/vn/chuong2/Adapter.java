package tdc.edu.vn.chuong2;

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

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder>{
    Context context;
    private List<DonDat> donDatList = null;
    int layoutResource;

    final static String TXTTIEUDE = "TIÊU ĐỀ";
    final static String IMGANH = "Hình ảnh";
    final static String BUNDLE="BUNDLE";

    @NonNull
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        View row = inflater.inflate(layoutResource,viewGroup,false);
        return new MyViewHolder(row);
    }

    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {

        myViewHolder.txtTieuDe.setText(donDatList.get(i).getTxtTieuDe());
        myViewHolder.imageView.setImageResource(donDatList.get(i).getImage());

        //xử lý các sự kiện. VD: giữ xóa một item ...
        myViewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                return false;
            }});
        //thêm sự kiện cho nút chi tiết của sản phẩm
        myViewHolder.btnChiTiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,DetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString(TXTTIEUDE,donDatList.get(i).getTxtTieuDe());
                bundle.putInt(IMGANH,donDatList.get(i).getImage());
                intent.putExtra(BUNDLE,bundle);
                v.getContext().startActivity(intent);
            }
        });
    }

    public int getItemCount() {
        return donDatList.size();
    }

    public Adapter(Context context, List<DonDat> donDatList, int layoutResource) {
        this.context = context;
        this.donDatList = donDatList;
        this.layoutResource = layoutResource;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView txtTieuDe;
        Button btnChiTiet;
        public MyViewHolder(View itemView){
            super(itemView);
            txtTieuDe = itemView.findViewById(R.id.txtTieuDe);
            imageView = itemView.findViewById(R.id.image);
            btnChiTiet = itemView.findViewById(R.id.btnChiTiet);
        }
    }
    public void removeItem(int position){
        donDatList.remove(position);
        notifyItemRemoved(position);
    }
}
