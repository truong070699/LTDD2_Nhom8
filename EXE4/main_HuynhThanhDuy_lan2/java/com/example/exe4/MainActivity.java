package com.example.exe4;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    VideoView videoView;
    MediaController mController;

    //Adapter
    List<Comment> donDatList = null;
    RecyclerView recyclerView;
    Adapter donDatAdapter;

    //thêm
    TextInputEditText txtNoiDung;
    TextView txtTieuDe;
    Button btnGui;


    //2 Array Comment
    int avatars[] = {R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4, R.drawable.a5, R.drawable.a6, R.drawable.a7, R.drawable.a8, R.drawable.a9, R.drawable.a10};
    String comments[] = {"hay qua", "hay", "Tuyệt vời", "Mới xem có 5 lần à", "Cả một tuổi thơ", "Không hay không ăn tiền :))", "thức trắng đêm để hóng", "Cố lên !!!", "Tuyệt quá","Trời ơi tin được không"};

    final int UPDATE_RATE = 1500;

    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setAdapter();
        addData(new Comment(R.drawable.a11, "hay qa"));
        setEvent();


        handler = new Handler();
    }

    @Override
    protected void onResume() {
        super.onResume();

        handler.postDelayed(myRunnable,UPDATE_RATE);
    }

    public void setControl() {
        txtTieuDe = findViewById(R.id.txtTieuDe);
        txtNoiDung = findViewById(R.id.txtNoiDung);
        btnGui = findViewById(R.id.btnGui);
        videoView = findViewById(R.id.videoViewID);

        //set giá trị
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra(VideoList.BUNDLE);
        int id = bundle.getInt(VideoList.ID);

        txtTieuDe.setText(bundle.getString(VideoList.TIEUDE));
        if(id == 1){
            mController = new MediaController(this);
            videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.video1);
        }
        if(id == 2){
            mController = new MediaController(this);
            videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.video3);
        }
        if(id == 3){
            mController = new MediaController(this);
            videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.video2);
        }

        videoView.setMediaController(mController);
        mController.setAnchorView(videoView);
        videoView.start();

    }

    public void setEvent() {
        btnGui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addData(new Comment(R.drawable.a11, txtNoiDung.getText().toString()));
            }
        });
    }


    //set Adapter
    //cài đặt các Adapter và List cho phù hợp123456
    private void setAdapter() {
        recyclerView = findViewById(R.id.recyclerView);
        donDatList = new ArrayList<>();
        donDatAdapter = new Adapter(this, donDatList, R.layout.row);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, true);//theo chiều ngang
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(donDatAdapter);
    }

    //xử lý sự kiện thêm một đơn đặt vào danh sách
    public void addData(Comment donDat) {
        donDatList.add(donDat);
        donDatAdapter.notifyDataSetChanged();
        recyclerView.smoothScrollToPosition(donDatAdapter.getItemCount() - 1);
    }


    //ham random
    public static int generateRandomIntIntRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    private final Runnable myRunnable = new Runnable() {
        @Override
        public void run()
        {
            //Do task
            int avatar = avatars[generateRandomIntIntRange(0, avatars.length - 1)];
            String comment = comments[generateRandomIntIntRange(0, comments.length - 1)];
            addData(new Comment(avatar, comment));
            handler.postDelayed(myRunnable, UPDATE_RATE);
        }
    };
}
