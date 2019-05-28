package tdc.edu.vn.test;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.PhepTinhViewHolder> {
    private List<pheptinh> pheptinhList;
    private Activity activity;

    public Adapter(Activity activity,List<pheptinh> pheptinhList) {
        this.activity = activity;
        this.pheptinhList = pheptinhList;
    }
    public class PhepTinhViewHolder extends RecyclerView.ViewHolder {
        private TextView soA;
        private TextView soB;
        private TextView ketqua;
        private ImageView icon;

        public PhepTinhViewHolder(View itemView) {
            super(itemView);
            soA = (TextView) itemView.findViewById(R.id.soA);
            soB = (TextView) itemView.findViewById(R.id.soB);
            ketqua = (TextView) itemView.findViewById(R.id.ketqua);
            icon = (ImageView) itemView.findViewById(R.id.img);

        }
    }
    @Override
    public PhepTinhViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        /** Get layout */
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listview_item_row,parent,false);
        return new PhepTinhViewHolder(view);
    }
    @Override
    public void onBindViewHolder(PhepTinhViewHolder holder, final int position) {
        /** Set Value*/
        final pheptinh pheptinh = pheptinhList.get(position);
        holder.soA.setText(pheptinh.getSoA());
        holder.soB.setText(pheptinh.getSoB());
        holder.ketqua.setText(pheptinh.getKetqua());
        holder.icon.setImageResource(pheptinh.getIcon());
        /*Sự kiện click vào item*/
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeItem(position);
                Toast.makeText(activity, pheptinh.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public int getItemCount() {
        return pheptinhList.size();
    }

    public void removeItem(int position){
        pheptinhList.remove(position);
        notifyItemRemoved(position);
    }

}