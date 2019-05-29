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

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText editTen, editGia;
    RadioButton rbApple, rbSamsung, rbOppo;
    Button btnThem;
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
        editTen = (EditText) findViewById(R.id.ten);
        editGia = (EditText) findViewById(R.id.gia);
        btnThem = (Button) findViewById(R.id.btnCong);
        rbApple = (RadioButton)findViewById(R.id.apple);
        rbSamsung = (RadioButton)findViewById(R.id.samsung);
        rbOppo = (RadioButton)findViewById(R.id.oppo);

    }

    public void setEvent() {
        btnThem.setOnClickListener(new View.OnClickListener() {
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
        if(TextUtils.isEmpty(editTen.getText().toString()))
        {
            editTen.setError("Nhap Ten");
            return false;
        }
        if (TextUtils.isEmpty(editGia.getText().toString())) {
            editGia.setError("Nhap Gia");
            return false;
        }


        return  true;
    }
    public void setAdapter()
    {
recyclerView =(RecyclerView)findViewById(R.id.recyclerview);
pheptinhList = new ArrayList<>();
pheptinhAdapter = new Adapter(this,pheptinhList);
RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
recyclerView.setLayoutManager(mLayoutManager);
recyclerView.setAdapter(pheptinhAdapter);
    }

    public void CreateData1()
    {
       if(rbSamsung.isChecked())
       {
           pheptinh pheptinh = new pheptinh(R.drawable.samsung, editTen.getText().toString(), editGia.getText().toString());
           pheptinhList.add(pheptinh);
           pheptinhAdapter.notifyDataSetChanged();
       }
       else if(rbApple.isChecked())
       {
           pheptinh pheptinh = new pheptinh(R.drawable.apple, editTen.getText().toString(), editGia.getText().toString());
           pheptinhList.add(pheptinh);
           pheptinhAdapter.notifyDataSetChanged();
       }
       else
        {
            pheptinh pheptinh = new pheptinh(R.drawable.oppo, editTen.getText().toString(), editGia.getText().toString());
            pheptinhList.add(pheptinh);
            pheptinhAdapter.notifyDataSetChanged();
        }

    }


}
