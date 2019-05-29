package tdc.edu.vn.myapplication1;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    SensorManager sensorManager;
    private Sensor accelerometer;
    private float vibrateThreshold = 0;
    LinearLayout view;
    ImageView img,img2,img3;
    ArrayList<Integer> kq = new ArrayList<>();
    TextView TV;
    String ketqua,ketqua2,ketqua3 ;
    private float lastX, lastY, lastZ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setcontrol();
        setSensor();
    }

    private void setcontrol() {
        view = (LinearLayout) findViewById(R.id.Layout);
        img = (ImageView) findViewById(R.id.hinh);
        TV = (TextView)findViewById(R.id.ketqua);

    }

public int getramdon(int max,int min)
{
    return(int)(Math.random()*(max-min) + min);
}
public void Vtri1()
{
  Integer index =  getramdon(9,0);
  if(index==0)
  {
      img.setImageResource(R.drawable.carlos);
      ketqua = " Roberto Carlos\n" +
              "Tên đầy đủ : \tRoberto Carlos da Silva\n" +
              "Ngày sinh : \t10 tháng 4, 1973 (46 tuổi)\n" +
              "Nơi sinh : \tGarça, São Paulo, Brasil\n" +
              "Chiều cao : \t1,68 m (5 ft 6 in)\n" +
              "Vị trí : \tHậu vệ cánh trái ";
  }
  else if(index==1)
  {
      img.setImageResource(R.drawable.cruyff);
      ketqua = "Johan Cruyff\n" +
              "Tên đầy đủ : \tHendrik Johannes Cruijff\n" +
              "Ngày sinh : \t25 tháng 4 năm 1947\n" +
              "Nơi sinh : \tAmsterdam, Hà Lan\n" +
              "Ngày mất : \t24 tháng 3 năm 2016 (68 tuổi)\n" +
              "Nơi mất : \tBarcelona, Tây Ban Nha\n" +
              "Chiều cao : \t1,80 m (5 ft 11 in)\n" +
              "Vị trí : \tTiền vệ tấn công / Tiền đạo";

  }
  else if(index ==2)
  {
      img.setImageResource(R.drawable.maldini);
      ketqua = "Paolo Maldini\n" +
              "Tên đầy đủ : \tPaolo Cesare Maldini\n" +
              "Ngày sinh : \t26 tháng 6, 1968 (50 tuổi)\n" +
              "Nơi sinh: \tMilano, Ý\n" +
              "Chiều cao : \t1,86 m (6 ft 1 in)\n" +
              "Vị trí : \tHậu vệ ";
  }
  else if(index ==3)
  {
      img.setImageResource(R.drawable.maradona);
      ketqua = "Diego Maradona\n" +
              "Tên đầy đủ : \tDiego Armando Maradona Franco\n" +
              "Ngày sinh : \t30 tháng 10, 1960 (58 tuổi)\n" +
              "Nơi sinh : \tLanús, Buenos Aires, Argentina\n" +
              "Chiều cao: \t1,65 m (5 ft 5 in)\n" +
              "Vị trí: \tTiền vệ công," +
              "Hộ công ";
  }
  else if(index == 4)
  {
      img.setImageResource(R.drawable.pele);
      ketqua = "Pele\n" +
              "Ngày sinh : \t23 tháng 10, 1940 (78 tuổi)\n" +
              "Nơi sinh : \tEdson Arantes do Nascimento\n" +
              "Chiều cao: \t1,73 m\n" +
              "Vị trí: \tTiền vệ công," +
              "Tiền đạo ";
  }
  else if(index == 5)
  {
      img.setImageResource(R.drawable.ronaldinho);
      ketqua = " Ronaldinho\n" +
              "Tên đầy đủ : \tRonaldo de Assis Moreira\n" +
              "Ngày sinh : \t21 tháng 3, 1980 (39 tuổi)\n" +
              "Nơi sinh : \tPorto Alegre, Brazil\n" +
              "Chiều cao : \t1,81 m (5 ft 11 1⁄2 in\n" +
              "Vị trí : \tTiền vệ / Tiền đạo ";
  }
  else if(index == 6)
  {
      img.setImageResource(R.drawable.ronaldo);
      ketqua = " Ronaldo\n" +
              "Tên đầy đủ : \tRonaldo Luis Nazário de Lima\n" +
              "Ngày sinh : \t18 tháng 9, 1976 (42 tuổi)\n" +
              "Nơi sinh : \tRio de Janeiro, Brasil\n" +
              "Chiều cao : \t1,83 m\n" +
              "Vị trí : \tTiền đạo ";
  }
  else if(index == 7)
  {
      img.setImageResource(R.drawable.vieira);
      ketqua = " Vieira\n" +
              "Tên đầy đủ : \tPatrick Vieira\n" +
              "Ngày sinh : \t23 tháng 6, 1976 (42 tuổi)\n" +
              "Nơi sinh : \tDakar, Sénégal\n" +
              "Chiều cao : \t1,93 m (6 ft 4 in)\n" +
              "Vị trí : \tTiền vệ ";
  }
  else if(index == 8)
  {
      img.setImageResource(R.drawable.yashin);
      ketqua = " Yashin\n" +
              "Tên đầy đủ : \tLev Ivanovich Yashin\n" +
              "Ngày sinh : \t22 tháng 10 năm 1929\n" +
              "Nơi sinh : \tMoskva, Liên Xô\n" +
              "Ngày mất : \t20 tháng 3 năm 1990 (60 tuổi)\n" +
              "Nơi mất : \tMoskva, Liên Xô\n" +
              "Chiều cao : \t1,89 m (6 ft 2 in)\n" +
              "Vị trí : \tThủ môn ";
  }
}


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
            Vtri1();
            TV.setText(ketqua);
            //img.setImageResource(R.drawable.ip);
            //view.setBackgroundColor(Color.RED);
        }
        if (deltaY > vibrateThreshold) {
            Vtri1();
            TV.setText(ketqua);
            //img.setImageResource(R.drawable.ip);
            //view.setBackgroundColor(Color.YELLOW);

        }
        if (deltaZ > vibrateThreshold) {
            Vtri1();
            TV.setText(ketqua);
            //img.setImageResource(R.drawable.ip);
            //view.setBackgroundColor(Color.BLUE);

        }
        lastX = event.values[0];
        lastY = event.values[1];
        lastZ = event.values[2];

    }
}
