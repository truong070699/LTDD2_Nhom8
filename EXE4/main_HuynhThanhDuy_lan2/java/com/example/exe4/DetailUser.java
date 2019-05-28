package com.example.exe4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class DetailUser extends AppCompatActivity {

    ImageView imgAvatar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_user);

        imgAvatar = findViewById(R.id.imgAvatar);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra(Adapter.BUNDLE);

        int id = bundle.getInt(Adapter.imgSrc);
        imgAvatar.setImageResource(id);
    }
}
