package com.example.exe4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class VideoList extends AppCompatActivity {

    LinearLayout video1,video2,video3;
    TextView txtVideo1,txtVideo2,txtVideo3;

    public static final String BUNDLE = "bundle";
    public static final String TIEUDE = "bundle";
    public static final String ID = "id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_list);
        setControl();
        setEvent();
    }
    public void setControl(){
        video1 = findViewById(R.id.video1);
        video2 = findViewById(R.id.video2);
        video3 = findViewById(R.id.video3);
        txtVideo1 = findViewById(R.id.txtVideo1);
        txtVideo2 = findViewById(R.id.txtVideo2);
        txtVideo3 = findViewById(R.id.txtVideo3);
    }

    public void setEvent(){
        video1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chuyenTrang(1,txtVideo1.getText().toString());
            }
        });
        video2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chuyenTrang(2,txtVideo2.getText().toString());
            }
        });
        video3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chuyenTrang(3,txtVideo3.getText().toString());
            }
        });
    }

    public void chuyenTrang(int id,String tieuDe){
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        Bundle bundle = new Bundle();

        bundle.putInt(ID,id);
        bundle.putString(TIEUDE,tieuDe);
        intent.putExtra(BUNDLE,bundle);
        startActivity(intent);
    }
}
