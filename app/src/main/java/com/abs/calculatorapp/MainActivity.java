package com.abs.calculatorapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.abs.calculatorapp.model.CalculatorAppViewModel;

public class MainActivity extends AppCompatActivity {
    Button btnKhong, btnMot, btnHai, btnBa, btnBon, btnNam, btnSau, btnBay, btnTam, btnChin, btnCong, btnTru, btnNhan, btnChia, btnMoNgoac, btnDongNgoac, btnXoa, btnXoaTatCa, btnKetQua;
    CalculatorAppViewModel model;
    TextView tvBieuThuc, tvKetQua;
    StringBuilder stringBuilder = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        model = new ViewModelProvider(this).get(CalculatorAppViewModel.class);
        initView();
        model.getExpression().observe(this, new Observer<StringBuilder>() {
            @Override
            public void onChanged(StringBuilder stringBuilder) {
                tvBieuThuc.setText(stringBuilder.toString());
            }
        });
        handleUserInteraction();
    }

    private void handleUserInteraction() {
        btnKhong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateValueForExpression(btnKhong.getText().toString());
            }
        });
        btnMot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateValueForExpression(btnMot.getText().toString());
            }
        });
        btnHai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateValueForExpression(btnHai.getText().toString());
            }
        });
        btnBa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateValueForExpression(btnBa.getText().toString());
            }
        });
        btnBon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateValueForExpression(btnBon.getText().toString());
            }
        });
        btnNam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateValueForExpression(btnNam.getText().toString());
            }
        });
        btnSau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateValueForExpression(btnSau.getText().toString());
            }
        });
        btnBay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateValueForExpression(btnBay.getText().toString());
            }
        });
        btnTam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateValueForExpression(btnTam.getText().toString());
            }
        });
        btnChin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateValueForExpression(btnChin.getText().toString());
            }
        });
        btnCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateValueForExpression(btnCong.getText().toString());
            }
        });
        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateValueForExpression(btnTru.getText().toString());
            }
        });
        btnNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateValueForExpression(btnNhan.getText().toString());
            }
        });
        btnChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateValueForExpression(btnChia.getText().toString());
            }
        });
        btnMoNgoac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateValueForExpression(btnMoNgoac.getText().toString());
            }
        });
        btnDongNgoac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateValueForExpression(btnDongNgoac.getText().toString());
            }
        });
        btnKetQua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InfixEvaluation i = new InfixEvaluation();
                if (tvBieuThuc.getText().toString().length() > 0) {
                    tvKetQua.setText(String.valueOf(i.evaluate(tvBieuThuc.getText().toString())));
                }
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (stringBuilder.length() > 0){
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                    model.getExpression().setValue(stringBuilder);
                }


            }
        });
        btnXoaTatCa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stringBuilder.setLength(0);
                model.getExpression().setValue(stringBuilder);
                tvKetQua.setText("");
            }
        });
    }

    public void updateValueForExpression(String value) {
        if (model.getExpression().getValue() == null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(value);
            model.getExpression().setValue(stringBuilder);
        } else {
            stringBuilder = model.getExpression().getValue().append(value);
            model.getExpression().setValue(stringBuilder);
        }
    }


    private void initView() {
        tvBieuThuc = findViewById(R.id.tv_bieu_thuc);
        btnKhong = findViewById(R.id.btn_khong);
        btnMot = findViewById(R.id.btn_mot);
        btnHai = findViewById(R.id.btn_hai);
        btnBa = findViewById(R.id.btn_ba);
        btnBon = findViewById(R.id.btn_bon);
        btnNam = findViewById(R.id.btn_nam);
        btnSau = findViewById(R.id.btn_sau);
        btnBay = findViewById(R.id.btn_bay);
        btnTam = findViewById(R.id.btn_tam);
        btnChin = findViewById(R.id.btn_chin);
        btnCong = findViewById(R.id.btn_cong);
        btnTru = findViewById(R.id.btn_tru);
        btnNhan = findViewById(R.id.btn_nhan);
        btnChia = findViewById(R.id.btn_chia);
        btnMoNgoac = findViewById(R.id.btn_mo_ngoac);
        btnDongNgoac = findViewById(R.id.btn_dong_ngoat);
        btnKetQua = findViewById(R.id.btn_ket_qua);
        tvKetQua = findViewById(R.id.tv_ket_qua);
        btnXoa = findViewById(R.id.btn_xoa);
        btnXoaTatCa = findViewById(R.id.btn_xoa_tat_ca);
    }
}
