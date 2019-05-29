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
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    SensorManager sensorManager;
    private Sensor accelerometer;
    private float vibrateThreshold = 0;
    LinearLayout view;
    ImageView img,img2,img3;

    TextView TV,kqc,TV2,TV3,kqc2,kqc3,kqc4,kqc5,kqc6;
    Button xkq,btncc;
    ImageButton imgbtn1,imgbtn2,imgbtn3,imgbtn4,imgbtn5,imgbtn6;
    String ketqua,ketqua2,ketqua3 ;
    int kqua1,kqua2,kqua3 ;
    String Vtri1 = "",Vtri2 = "",Vtri3 = "",Vtri4 = "",Vtri5 = "",Vtri6 = "";
            int index1,index2,index3,index4,index5,index6;
    private float lastX, lastY, lastZ;
    Spinner sp,sp2,sp3,sp4,sp5,sp6;
    String getdata,getdata1,getdata2,getdata3,getdata4,getdata5,A;
    int arr[] = {kqua1,kqua2,kqua3};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setcontrol();

        setSensor();
        setvitri();
        ketquachon();
        //TinhTiencc();
        //setKetQua();
        //TinhTien();
    }

    private void setcontrol() {
        view = (LinearLayout) findViewById(R.id.Layout);
        img = (ImageView) findViewById(R.id.hinh);
        img2 = (ImageView) findViewById(R.id.hinh2);
        img3 = (ImageView) findViewById(R.id.hinh3);
        TV = (TextView)findViewById(R.id.ketqua);
        TV2 = (TextView)findViewById(R.id.ketqua2);
        TV3 = (TextView)findViewById(R.id.ketqua3);
        imgbtn1 =(ImageButton) findViewById(R.id.vt1);
        imgbtn2 =(ImageButton) findViewById(R.id.vt2);
        imgbtn3 =(ImageButton) findViewById(R.id.vt3);
        imgbtn4 =(ImageButton) findViewById(R.id.vt4);
        imgbtn5 =(ImageButton) findViewById(R.id.vt5);
        imgbtn6 =(ImageButton) findViewById(R.id.vt6);
        xkq = (Button) findViewById(R.id.xemkq);
       btncc= (Button) findViewById(R.id.dm);
        kqc = (TextView) findViewById(R.id.kqchon);
        kqc2 = (TextView) findViewById(R.id.kqchon2);
        kqc3 = (TextView) findViewById(R.id.kqchon3);
        kqc4 = (TextView) findViewById(R.id.kqchon4);
        kqc5 = (TextView) findViewById(R.id.kqchon5);
        kqc6 = (TextView) findViewById(R.id.kqchon6);
        sp =(Spinner) findViewById(R.id.TNai);
        sp2 =(Spinner) findViewById(R.id.TBau);
        sp3 = (Spinner) findViewById(R.id.TGa);
        sp4 = (Spinner) findViewById(R.id.TCa);
        sp5 = (Spinner) findViewById(R.id.TCua);
        sp6 = (Spinner) findViewById(R.id.TTom);

    }

public int getramdon(int max,int min)
{
    return(int)(Math.random()*(max-min) + min);
}
public void Vtri1()
{
  Integer index =  getramdon(7,1);
  if(index==1)
  {
      img.setImageResource(R.drawable.bau);
      ketqua = " bau ";
      kqua1 =2;
  }
  else if(index==2)
  {
      img.setImageResource(R.drawable.cua);
      ketqua = " cua ";
      kqua1 =5;

  }
  else if(index ==3)
  {
      img.setImageResource(R.drawable.tom);
      kqua1 =6;
      ketqua = " tom ";
  }
  else if(index ==4)
  {
      img.setImageResource(R.drawable.ca);
      ketqua = " ca ";
      kqua1 =4;
  }
  else if(index == 5)
  {
      img.setImageResource(R.drawable.nai);
      ketqua = " Nai";
      kqua1 =1;
  }
  else if(index == 6)
  {
      img.setImageResource(R.drawable.ga);
      ketqua = " Ga ";
      kqua1 =3;
  }
}
    public void Vtri2() {
        Integer index = getramdon(7, 1);
        if (index == 1) {
            img2.setImageResource(R.drawable.bau);
            ketqua2 = " bau ";kqua2 =2;
        } else if (index == 2) {
            img2.setImageResource(R.drawable.cua);
            ketqua2 = " cua ";
            kqua2 =5;
        } else if (index == 3) {
            kqua2 =6;
            img2.setImageResource(R.drawable.tom);
            ketqua2 = " tom ";
        } else if (index == 4) {
            img2.setImageResource(R.drawable.ca);
            ketqua2 = " ca ";
            kqua2 =4;
        } else if (index == 5) {
            img2.setImageResource(R.drawable.ga);
            ketqua2 = " ga ";
            kqua2 =3;
        } else if (index == 6) {
            img2.setImageResource(R.drawable.nai);
            ketqua2 = " nai ";
            kqua2 =1;
        }
    }
    public void Vtri3() {
        Integer index = getramdon(7, 1);
        if (index == 1) {
            img3.setImageResource(R.drawable.bau);
            ketqua3 = " bau ";
            kqua3 =2;
        } else if (index == 2) {
            img3.setImageResource(R.drawable.cua);
            ketqua3 = " cua ";
            kqua3 =5;

        } else if (index == 3) {
            img3.setImageResource(R.drawable.tom);
            ketqua3 = " Tom ";
            kqua3 =6;
        } else if (index == 4) {
            img3.setImageResource(R.drawable.ca);
            ketqua3 = " Ca ";
            kqua3 =4;
        } else if (index == 5) {
            img3.setImageResource(R.drawable.ga);
            ketqua3 = " Ga ";
            kqua3 =3;
        } else if (index == 6) {
            img3.setImageResource(R.drawable.nai);
            ketqua3 = " Nai ";
            kqua3 =1;
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
            Vtri2();
            Vtri3();
            TV.setText(ketqua );
            TV2.setText( ketqua2 );
            TV3.setText( ketqua3 );
            //img.setImageResource(R.drawable.ip);
            //view.setBackgroundColor(Color.RED);
        }
        if (deltaY > vibrateThreshold) {
            Vtri1();
            Vtri2();
            Vtri3();
            TV.setText(ketqua );
            TV2.setText( ketqua2 );
            TV3.setText( ketqua3 );
            //img.setImageResource(R.drawable.ip);
            //view.setBackgroundColor(Color.YELLOW);

        }
        if (deltaZ > vibrateThreshold) {
            Vtri1();
            Vtri2();
            Vtri3();
            TV.setText(ketqua );
            TV2.setText( ketqua2 );
            TV3.setText( ketqua3 );
            //img.setImageResource(R.drawable.ip);
            //view.setBackgroundColor(Color.BLUE);

        }
        lastX = event.values[0];
        lastY = event.values[1];
        lastZ = event.values[2];

    }
    public void setvitri()
    {
      imgbtn1.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Vtri1 = "Nai";
              index1 =1;
              Toast.makeText(getApplicationContext(),"Nai",Toast.LENGTH_SHORT).show();
          }
      });
        imgbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vtri2 = "Bau";
                index2 =2;
                Toast.makeText(getApplicationContext(),"Bau",Toast.LENGTH_SHORT).show();
            }
        });
        imgbtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vtri3 ="Ga";
                index3 =3;
                Toast.makeText(getApplicationContext(),"ga",Toast.LENGTH_SHORT).show();
            }
        });
        imgbtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vtri4 ="Ca";
                index4 =4;
                Toast.makeText(getApplicationContext(),"ca",Toast.LENGTH_SHORT).show();
            }
        });
        imgbtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vtri5 ="Cua";
                index5 =5;
                Toast.makeText(getApplicationContext(),"cua",Toast.LENGTH_SHORT).show();
            }
        });
        imgbtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Vtri6 ="Tom";
                index6 =6;
                Toast.makeText(getApplicationContext(),"Tom",Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void ketquachon()
    {
        xkq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                kqc.setText( Vtri1 );
                kqc2.setText( Vtri2 );
                kqc3.setText( Vtri3 );
                kqc4.setText( Vtri4 );
                kqc5.setText( Vtri5 );
                kqc6.setText( Vtri6 );
                TinhTien();
            }
        });
    }
    public void TinhTiencc()
    {
        btncc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    int a=0,b=0,c=0,Tong;
    public int Tien1 ()
    {
        if(index1 == kqua1)
        {
            getdata = sp.getSelectedItem().toString();
            a = Integer.parseInt(getdata)*2;
        }
        else if(index2== kqua1)
        {
            getdata1 = sp2.getSelectedItem().toString();
            a = Integer.parseInt(getdata1)*2;
        }
        else if(index3 == kqua1)
        {
            getdata2 = sp3.getSelectedItem().toString();
            a = Integer.parseInt(getdata2)*2;
        }
        else if(index4==kqua1)
        {
            getdata3 = sp4.getSelectedItem().toString();
            a = Integer.parseInt(getdata3)*2;
        }
        else if(index5 ==kqua1)
        {
            getdata4 = sp5.getSelectedItem().toString();
            a = Integer.parseInt(getdata4)*2;
        }
        else if(index6 == kqua1)
        {
            getdata5 = sp6.getSelectedItem().toString();
            a = Integer.parseInt(getdata5)*2;
        }

        Toast.makeText(getApplicationContext(),"Ket qua a " + a,Toast.LENGTH_LONG).show();
        return a;
    }
    public int Tien2 ()
    {
        if(index1 == kqua2)
        {
            getdata = sp.getSelectedItem().toString();
            b = Integer.parseInt(getdata)*2;
        }
        else if(index2== kqua2)
        {
            getdata1 = sp2.getSelectedItem().toString();
            b = Integer.parseInt(getdata1)*2;
        }
        else if(index3 == kqua2)
        {
            getdata2 = sp3.getSelectedItem().toString();
            b = Integer.parseInt(getdata2)*2;
        }
        else if(index4==kqua2)
        {
            getdata3 = sp4.getSelectedItem().toString();
            b = Integer.parseInt(getdata3)*2;
        }
        else if(index5 ==kqua2)
        {
            getdata4 = sp5.getSelectedItem().toString();
            b = Integer.parseInt(getdata4)*2;
        }
        else
        {
            getdata5 = sp6.getSelectedItem().toString();
            b = Integer.parseInt(getdata5)*2;
        }

        Toast.makeText(getApplicationContext(),"Ket qua b " + b,Toast.LENGTH_LONG).show();
        return b;
    }
    public int Tien3 ()
    {
        if(index1 == kqua3)
        {
            getdata = sp.getSelectedItem().toString();
            c = Integer.parseInt(getdata)*2;
        }
        else if(index2== kqua3)
        {
            getdata1 = sp2.getSelectedItem().toString();
            c = Integer.parseInt(getdata1)*2;
        }
        else if(index3 == kqua3)
        {
            getdata2 = sp3.getSelectedItem().toString();
            c = Integer.parseInt(getdata2)*2;
        }
        else if(index4==kqua3)
        {
            getdata3 = sp4.getSelectedItem().toString();
            c = Integer.parseInt(getdata3)*2;
        }
        else if(index5 ==kqua3)
        {
            getdata4 = sp5.getSelectedItem().toString();
            c = Integer.parseInt(getdata4)*2;
        }
        else
        {
            getdata5 = sp6.getSelectedItem().toString();
            c = Integer.parseInt(getdata5)*2;
        }

        Toast.makeText(getApplicationContext(),"Ket qua c " + c,Toast.LENGTH_LONG).show();
        return c;
    }
    public void TinhTien()
    {
      Tong = Tien1() + Tien2() + Tien3();


        Toast.makeText(getApplicationContext(),"ban nhan duoc " + Tong,Toast.LENGTH_SHORT ).show();

    }
}
