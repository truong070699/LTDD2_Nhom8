package tdc.edu.vn.myapplication;

import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //khai bao bien
    ImageView imageView1;
    ImageButton imgbtnPlay, imgbtnStop, imgbtnPrev, imgNext;
    TextView tenbaihat, tgdau, tgcuoi;
    SeekBar seekBar;
    ArrayList<Song> arrayList1;
    MediaPlayer mediaPlayer;
    int position = 0;
    int tgbaihat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setControl();
        khoitao();
        setEvent();
    }




    private void setControl() {
        imageView1 = (ImageView) findViewById(R.id.img_baihat);
        imgbtnPlay = (ImageButton) findViewById(R.id.imgbtn_play);
        imgbtnStop = (ImageButton) findViewById(R.id.imgbtn_stop);
        imgbtnPrev = (ImageButton) findViewById(R.id.imgbtn_prev);
        imgNext = (ImageButton) findViewById(R.id.imgbtn_next);

        tenbaihat = (TextView) findViewById(R.id.tv_tenbaihat);
        tgdau = (TextView) findViewById(R.id.tv_dau);
        tgcuoi = (TextView) findViewById(R.id.tv_cuoi);

        seekBar = (SeekBar) findViewById(R.id.seekBar);
    }

    private void khoitao() {
        arrayList1 = new ArrayList<>();
        arrayList1.add(new Song("Yêu người như anh", R.drawable.yeunguoinhuanh, R.raw.yeunguoinhuanh));
        arrayList1.add(new Song("Anh ơi ở lại", R.drawable.anhoiolai, R.raw.anhoiolai));
        arrayList1.add(new Song("Cảm giác lúc ấy sẽ ra sao", R.drawable.camgiac, R.raw.camgiaclucay));
        arrayList1.add(new Song("Đời là thế thôi", R.drawable.doilathethoi, R.raw.doilathethoi));
        arrayList1.add(new Song("Anh có tài mà", R.drawable.anhcotaima, R.raw.b4));
    }

    private void play() {
        mediaPlayer = MediaPlayer.create(MainActivity.this, arrayList1.get(position).getFile());
        tenbaihat.setText(arrayList1.get(position).getTenbaihat());
        imageView1.setImageResource(arrayList1.get(position).getHinh());

    }

    private void setEvent() {
        //khoi tao bai hat
        play();

        imgbtnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    imgbtnPlay.setImageResource(R.drawable.ic_play);
                } else {
                    mediaPlayer.start();
                    imgbtnPlay.setImageResource(R.drawable.ic_pause);
                }
                setTime();
                updateTime();
            }
        });

        imgbtnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                mediaPlayer.release();
                imgbtnPlay.setImageResource(R.drawable.ic_play);
                //khoi tao lai bai hat
                play();
                setTime();
                updateTime();
            }
        });

        imgNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position++;
                if (position > arrayList1.size() -1){
                    position = 0;
                }
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
                //khoi tao lai bai hat
                play();
                mediaPlayer.start();
                imgbtnPlay.setImageResource(R.drawable.ic_pause);
                setTime();
                updateTime();
            }
        });

        imgbtnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position--;
                if (position < 0){
                    position = arrayList1.size() -1;
                }
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
                //khoi tao lai bai hat
                play();
                mediaPlayer.start();
                imgbtnPlay.setImageResource(R.drawable.ic_pause);
                setTime();
                updateTime();
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(seekBar.getProgress());
            }
        });

        Animation animation = AnimationUtils.loadAnimation(this,R.anim.quay);
        imageView1.startAnimation(animation);


    }

    private void setTime(){
        SimpleDateFormat dinhDangGio = new SimpleDateFormat("mm:ss");
        tgcuoi.setText(dinhDangGio.format(mediaPlayer.getDuration()) + "");

        //lay tong thoi gian 1 bai hat
        seekBar.setMax(mediaPlayer.getDuration());
    }

    private void updateTime(){
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat dinhDangGio = new SimpleDateFormat("mm:ss");
                tgdau.setText(dinhDangGio.format(mediaPlayer.getCurrentPosition()) + "");


                seekBar.setProgress(mediaPlayer.getCurrentPosition());

                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        position++;
                        if (position > arrayList1.size() - 1){
                            position = 0;
                        }
                        if (mediaPlayer.isPlaying()){
                            mediaPlayer.stop();
                        }

                        //khoi tao lai bai hat
                        mediaPlayer = MediaPlayer.create(MainActivity.this, arrayList1.get(position).getFile());
                        tenbaihat.setText(arrayList1.get(position).getTenbaihat());
                        imageView1.setImageResource(arrayList1.get(position).getHinh());
                        mediaPlayer.start();
                        imgbtnPlay.setImageResource(R.drawable.ic_pause);
                        setTime();
                        updateTime();
                    }
                });
                handler.postDelayed(this,500);
            }
        }, 100);
    }

}
