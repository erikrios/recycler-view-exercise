package com.erikriosetiawan.recyclerviewexercise;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class HalamanAwal extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FloatingActionButton btnTambah;
    private Adapter adapter;
    private final static int KODE_INPUT_DATA = 8888;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.halaman_awal);
        recyclerView = findViewById(R.id.recycler_data);
        btnTambah = findViewById(R.id.btn_tambah);

        List<Mahasiswa> dataMahasiswa = MainApplication.getDb().mahasiswaDao().getAll();
        adapter = new Adapter(dataMahasiswa);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(HalamanAwal.this, InputData.class), KODE_INPUT_DATA);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == KODE_INPUT_DATA) {
                List<Mahasiswa> dataMahasiswa = MainApplication.getDb().mahasiswaDao().getAll();
                adapter.addAll(dataMahasiswa);
            }
        }
    }
}
