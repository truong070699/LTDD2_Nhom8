package com.example.ldd2tuan2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText editSoA, editSoB;
    RadioButton rbNam,rbNu;
    Button btncong;
    RadioGroup gt;
private List<pheptinh>pheptinhList;
private RecyclerView recyclerView;
private Adapter pheptinhAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEvent();
        setAdapter();
    }

    public void setControl() {
        editSoA = (EditText) findViewById(R.id.soa);
        editSoB = (EditText) findViewById(R.id.sob);
        btncong = (Button) findViewById(R.id.btnCong);
        rbNam = (RadioButton)findViewById(R.id.Nam);
        rbNu = (RadioButton)findViewById(R.id.Nu);
        gt =(RadioGroup)findViewById(R.id.gioitinh);

    }

    public void setEvent() {
        btncong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Validation()==true)
                {
                    CreateData1();
                }
            }
        });

    }
    public boolean Validation()
    {
        if(TextUtils.isEmpty(editSoA.getText().toString()))
        {
            editSoA.setError("Nhap Ma");
            return false;
        }
        if (TextUtils.isEmpty(editSoB.getText().toString())) {
            editSoB.setError("Nhap ten");
            return false;
        }
        return  true;
    }
    public void setAdapter()
    {
recyclerView =(RecyclerView)findViewById(R.id.recyclerview);
pheptinhList = new ArrayList<>();
pheptinhAdapter = new Adapter(this,pheptinhList);
RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
recyclerView.setLayoutManager(mLayoutManager);
recyclerView.setAdapter(pheptinhAdapter);
    }

    public void CreateData1()
    {
       if(rbNu.isChecked())
       {
           pheptinh pheptinh = new pheptinh(R.drawable.girl,editSoA.getText().toString(),editSoB.getText().toString());
           pheptinhList.add(pheptinh);
           pheptinhAdapter.notifyDataSetChanged();
       }
       else
       {
           pheptinh pheptinh = new pheptinh(R.drawable.nam,editSoA.getText().toString(),editSoB.getText().toString());
           pheptinhList.add(pheptinh);
           pheptinhAdapter.notifyDataSetChanged();
       }
    }


}
