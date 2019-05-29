package tdc.edu.vn.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button img_play;
    ImageView img_main;
    boolean isPlay = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEvent();
    }
    public void setControl(){
        img_play = findViewById(R.id.img_play);
        img_main = findViewById(R.id.img_main);
    }
    public void setEvent(){
        img_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isPlay == true){
                    Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
                    img_main.startAnimation(animation);
                    img_play.setBackgroundResource(R.drawable.state_pause);
                    isPlay = false;
                }
                else{
                    isPlay = true;
                    img_main.clearAnimation();
                    img_play.setBackgroundResource(R.drawable.state_start);
                }
            }
        });
    }
}
