package tdc.edu.vn.chuong2;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainRutBai extends AppCompatActivity {
    private ListView listView;
    private SensorManager mSensorManager;
    private List<Sensor> deviceSensors = null;
    private ArrayList<String> deviceSensorsList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_list);

        listView = ((ListView)findViewById(R.id.listView1));
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        deviceSensors = mSensorManager.getSensorList(Sensor.TYPE_ALL);
        for (Sensor s : deviceSensors)
        {
            deviceSensorsList.add(s.getName());
        }
        listView.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_expandable_list_item_1,deviceSensorsList));
    }
}
