package tdc.edu.vn.chuong2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView txtMota,txtMoTaTieuDe;
    ImageView imgMoTa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setControl();
        setValue();
    }

    public void setControl(){
        txtMoTaTieuDe = findViewById(R.id.txtMoTaTieuDe);
        txtMota = findViewById(R.id.txtMoTa);
        imgMoTa = findViewById(R.id.imgMoTa);
    }
    public void setValue(){
        int resoucrID = 0;
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra(Adapter.BUNDLE);

        txtMota.setText(bundle.getString(Adapter.TXTTIEUDE));
        txtMoTaTieuDe.setText(bundle.getString(Adapter.TXTTIEUDE));
        imgMoTa.setImageResource(bundle.getInt(Adapter.IMGANH));
    }

}
