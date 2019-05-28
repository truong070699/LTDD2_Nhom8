package tdc.edu.vn.test;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<pheptinh> pheptinhList;
    private RecyclerView recyclerView;
    private Adapter PhepTinhAdapter;
    Button btnCong, btnTru, btnNhan, btnChia;
    EditText soA;
    EditText soB;
    EditText ketqua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEvent();
        setAdapter();

    }

    public void setControl() {
        btnCong = (Button) findViewById(R.id.btnCong);
        btnTru = (Button) findViewById(R.id.btnTru);
        btnNhan = (Button) findViewById(R.id.btnNhan);
        btnChia = (Button) findViewById(R.id.btnChia);
        soA = (EditText) findViewById(R.id.soA);
        soB = (EditText) findViewById(R.id.soB);
        ketqua = (EditText) findViewById(R.id.ketqua);
    }

    public void setEvent() {
        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (kiemtra()) return;
                int temp = Integer.parseInt(soA.getText().toString()) + Integer.parseInt(soB.getText().toString());
                int temps = Integer.parseInt(ketqua.getText().toString());
                if (temp == temps) {
                    Toast.makeText(getApplicationContext(), "Đúng", Toast.LENGTH_LONG).show();
                    addEvent1();
                } else {
                    Toast.makeText(getApplicationContext(), "Sai", Toast.LENGTH_LONG).show();
                    addEvent2();
                }
            }
        });
        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (kiemtra()) return;
                int temp = Integer.parseInt(soA.getText().toString()) - Integer.parseInt(soB.getText().toString());
                int temps = Integer.parseInt(ketqua.getText().toString());

                if (temp == temps) {
                    Toast.makeText(getApplicationContext(), "Đúng", Toast.LENGTH_LONG).show();
                    addEvent1();
                } else {

                    Toast.makeText(getApplicationContext(), "Sai", Toast.LENGTH_LONG).show();
                    addEvent2();
                }

            }
        });
        btnNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (kiemtra()) return;
                int temp = Integer.parseInt(soA.getText().toString()) * Integer.parseInt(soB.getText().toString());
                int temps = Integer.parseInt(ketqua.getText().toString());

                if (temp == temps) {
                    Toast.makeText(getApplicationContext(), "Đúng", Toast.LENGTH_LONG).show();
                    addEvent1();
                } else {
                    Toast.makeText(getApplicationContext(), "Sai", Toast.LENGTH_LONG).show();
                    addEvent2();
                }
            }
        });
        btnChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (kiemtra()) return;
                int temp = Integer.parseInt(soA.getText().toString()) / Integer.parseInt(soB.getText().toString());
                int temps = Integer.parseInt(ketqua.getText().toString());

                if (temp == temps) {
                    Toast.makeText(getApplicationContext(), "Đúng", Toast.LENGTH_LONG).show();
                    addEvent1();
                } else
                {
                    Toast.makeText(getApplicationContext(), "Sai", Toast.LENGTH_LONG).show();
                    addEvent2();
                }
            }

        });
    }

    public boolean kiemtra() {
        if (soA.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Nhập số A", Toast.LENGTH_LONG).show();
            soA.requestFocus();
            return true;
        } else if (soB.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Nhập số B", Toast.LENGTH_LONG).show();
            soB.requestFocus();
            return true;
        } else if (ketqua.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Nhập kết quả", Toast.LENGTH_LONG).show();
            ketqua.requestFocus();
            return true;
        }
        return false;

    }
    private void setAdapter() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        pheptinhList = new ArrayList<>();
        PhepTinhAdapter = new Adapter(this,pheptinhList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(PhepTinhAdapter);
    }

    private void addEvent1() {
        /** Call method add data*/
        createData1();
    }
    private void addEvent2() {
        /** Call method add data*/
        createData2();
    }
    public void createData1() {
        pheptinh pheptinh = new pheptinh(soA.getText().toString(),soB.getText().toString(),ketqua.getText().toString(),R.drawable.ic_done_black_24dp);
        pheptinhList.add(pheptinh);
        PhepTinhAdapter.notifyDataSetChanged();
    }
    public void createData2() {
        pheptinh pheptinh = new pheptinh(soA.getText().toString(),soB.getText().toString(),ketqua.getText().toString(),R.drawable.ic_clear_black_24dp);
        pheptinhList.add(pheptinh);
        PhepTinhAdapter.notifyDataSetChanged();
    }

}
