package com.example.pembayaraniurankelurahan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class checkdata extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkdata);

        TextView namakk = findViewById(R.id.checknama);
        TextView nik = findViewById(R.id.checkNIK);
        TextView jenkel = findViewById(R.id.checkJK);
        TextView anggotakk = findViewById(R.id.checkjumlahkel);
        TextView jenisiuran = findViewById(R.id.checkjenisIuran);
        TextView alamat = findViewById(R.id.checkalamat);
        Button backbutton = findViewById(R.id.backbtn);
        Button exitbutton = findViewById(R.id.exitbtn);

        Intent getiuran = getIntent();
        String nama = getiuran.getStringExtra("nama");
        namakk.setText(nama);
        nik.setText(getiuran.getStringExtra("NIK"));
        jenkel.setText(getiuran.getStringExtra("jeniskelamin"));
        alamat.setText(getiuran.getStringExtra("almt"));
        anggotakk.setText(getiuran.getStringExtra("jumlahkk"));
        jenisiuran.setText(getiuran.getStringExtra("jenisIuran"));

        // toast
        Toast.makeText(this,"Selamat datang " + getiuran.getStringExtra("nama"), Toast.LENGTH_SHORT).show();


       // method kembali
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindahActivity = new Intent(com.example.pembayaraniurankelurahan.checkdata.this, home.class);
                startActivity(pindahActivity);
            }
        });

        //method keluar
        exitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });

    }
}