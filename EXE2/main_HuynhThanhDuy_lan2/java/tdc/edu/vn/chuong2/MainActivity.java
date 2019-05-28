package tdc.edu.vn.chuong2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Parcelable;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.ImageView;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    //Sensor
    SensorManager sensorManager;
    private Sensor accelerometer;
    private float vibrateThreshold = 0;
    LinearLayout view;
    private float lastX, lastY, lastZ;
    // END - Sensor

    //Adapter
    boolean star = true;

    List<DonDat> donDatList = null;
    RecyclerView recyclerView;
    Adapter donDatAdapter;

    AnimationDrawable gyroAnimation;
    ImageView gyroView,gyro,frontGyro;

    Button btnTiep;
    Integer[] arrImg = {R.drawable.mot,R.drawable.hai,R.drawable.ba,R.drawable.bon,R.drawable.nam};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSensor();
        setControl();
        setAdapter();
        setEvent();

    }

    private void setEvent(){
        btnTiep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setStart();
            }
        });
    }
    private void setControl(){
        view = (LinearLayout) findViewById(R.id.Layout);
        frontGyro = findViewById(R.id.frontGyro);
        gyro = findViewById(R.id.gyro);

        btnTiep = findViewById(R.id.btnTiep);
        gyroView = (ImageView) findViewById(R.id.gyro);
        gyroView.setBackgroundResource(R.drawable.animation);
        gyroAnimation = (AnimationDrawable) gyroView.getBackground();
    }

    //sự kiện
    private void setStart(){
        star = true;
        gyroView.setVisibility(View.VISIBLE);
        frontGyro.setVisibility(View.INVISIBLE);
        gyroAnimation.start();
    }
    private void setStop(){
            if(star == true){
                String msg = null;
                Integer index = getRandom(0,4);
                gyroAnimation.stop();
                gyroView.setVisibility(View.INVISIBLE);
                frontGyro.setVisibility(View.VISIBLE);
                frontGyro.setImageResource(arrImg[index]);
                star = false;

                if(index == 0){
                    msg = "Chúc mừng bạn đã trúng một voucher KFC trị giá 100k rp";
                }
                else if(index == 1)
                {
                    msg = "Chúc mừng bạn đã trúng một voucher giảm giá 100k từ ToCoToCo";
                }
                else if(index == 2)
                {
                    msg = "Chúc mừng bạn đã trúng một Samsung S10+";
                }
                else if(index == 3)
                {
                    msg = "Chúc mừng bạn đã trúng một vé xem phim CGV";
                }else {
                    msg = "Chúc bạn may mắn lần sau";
                }
                Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
                addData(new DonDat(arrImg[index],msg));
            }
    }

    //lấy một giá trị bất kỳ từ mảng
    public static int getRandom(int Min, int Max)
    {
        return (int) (Math.random()*(Max-Min))+Min;
    }

    //setSensor
    private void setSensor() {
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        if (sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null) {
            accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            sensorManager.registerListener(this, accelerometer, sensorManager.SENSOR_DELAY_NORMAL);
            vibrateThreshold = accelerometer.getMaximumRange();
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            doihinh(event);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public void doihinh(SensorEvent event) {
        float deltaX = Math.abs(lastX - event.values[0]);
        float deltaY = Math.abs(lastY - event.values[1]);
        float deltaZ = Math.abs(lastZ - event.values[2]);
        if (deltaX > vibrateThreshold) {
            setStop();
        }
        if (deltaY > vibrateThreshold) {
            setStop();

        }
        if (deltaZ > vibrateThreshold) {
            setStop();
        }
        lastX = event.values[0];
        lastY = event.values[1];
        lastZ = event.values[2];

    }

    //set Adapter
    //cài đặt các Adapter và List cho phù hợp123456
    private void setAdapter() {
        recyclerView = findViewById(R.id.recyclerView);
        donDatList = new ArrayList<>();
        donDatAdapter = new Adapter(this,donDatList,R.layout.row);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);//theo chiều ngang
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(donDatAdapter);
    }

    //xử lý sự kiện thêm một đơn đặt vào danh sách
    public void addData(DonDat donDat){
        donDatList.add(donDat);
        donDatAdapter.notifyDataSetChanged();

    }
}

