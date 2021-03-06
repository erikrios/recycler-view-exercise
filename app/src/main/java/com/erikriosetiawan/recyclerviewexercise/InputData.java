package com.erikriosetiawan.recyclerviewexercise;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class InputData extends AppCompatActivity {

    private EditText edtNama, edtJurusan, edtAngkatan, edtAlamat, edtNoHp;
    private AppCompatButton btnSimpan;
    private int id;
    private boolean edit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_data);

        edtNama = findViewById(R.id.edt_nama);
        edtJurusan = findViewById(R.id.edt_jurusan);
        edtAngkatan = findViewById(R.id.edt_angkatan);
        edtAlamat = findViewById(R.id.edt_alamat);
        edtNoHp = findViewById(R.id.edt_nomo_hp);
        btnSimpan = findViewById(R.id.btn_simpan);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            if (bundle.containsKey("edit")) {
                if (bundle.getBoolean("edit")) {
                    edit = true;
                    Mahasiswa mahasiswa = MainApplication.getDb().mahasiswaDao().getMahasiswaById(bundle.getInt("id"));
                    edtNama.setText(mahasiswa.getNama());
                    edtJurusan.setText(mahasiswa.getNama());
                    edtAngkatan.setText(mahasiswa.getAngkatan());
                    edtAlamat.setText(mahasiswa.getAlamat());
                    edtNoHp.setText(mahasiswa.getNomorHp());
                    id = mahasiswa.getId();
                }
            }
        }

        btnSimpan.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (validasi()) {
                    Mahasiswa mahasiswa = new Mahasiswa(
                            edtNama.getText().toString(),
                            edtJurusan.getText().toString(),
                            Integer.parseInt(edtAngkatan.getText().toString()),
                            edtAlamat.getText().toString(),
                            edtNoHp.getText().toString()
                    );
                    if (edit) {
                        mahasiswa.setId(id);
                        MainApplication.getDb().mahasiswaDao().update(mahasiswa);
                    } else {
                        MainApplication.getDb().mahasiswaDao().insertAll(mahasiswa);
                    }
                    setResult(RESULT_OK);
                    finish();
                }
            }
        });
    }

    private boolean validasi() {
        if (edtNama.getText().toString().equals("")) {
            return false;
        }

        if (edtJurusan.getText().toString().equals("")) {
            return false;
        }

        if (edtAngkatan.getText().toString().equals("")) {
            return false;
        }

        if (edtAlamat.getText().toString().equals("")) {
            return false;
        }

        if (edtNoHp.getText().toString().equals("")) {
            return false;
        }
        return true;
    }
}
