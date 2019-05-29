package com.example.exe3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView imgXe,imgNguoi,imgLua,imgma;
    Button btnplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEvent();
    }
    public void setControl()
    {
        imgXe =(ImageView) findViewById(R.id.imageView);
        imgNguoi=(ImageView)findViewById(R.id.imageView2);
        imgLua=(ImageView)findViewById(R.id.imageView3);
        imgma=(ImageView)findViewById(R.id.imageView4);
        btnplay =(Button) findViewById(R.id.button2);
    }
    public void setEvent()
    {
        imgLua.setVisibility(View.INVISIBLE);
        imgma.setVisibility(View.INVISIBLE);
        btnplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.xe);
                imgXe.startAnimation(animation);
                final Animation animationNguoi = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.nguoi);
                imgNguoi.startAnimation(animationNguoi);
                final Animation animationLua = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.lua);
                imgLua.startAnimation(animationLua);
                imgLua.setVisibility(View.VISIBLE);
                imgLua.setVisibility(View.INVISIBLE);
                imgXe.setVisibility(View.INVISIBLE);
                imgNguoi.setVisibility(View.INVISIBLE);
                final Animation animationma = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.ma);
                imgma.startAnimation(animationma);
                imgma.setVisibility(View.VISIBLE);
                imgma.setVisibility(View.INVISIBLE);
            }
        });


    }
}
