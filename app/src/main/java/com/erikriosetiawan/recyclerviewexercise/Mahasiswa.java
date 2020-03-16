package com.erikriosetiawan.recyclerviewexercise;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "mahasiswa")
public class Mahasiswa {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "nama")
    private String nama;

    @ColumnInfo(name = "jurusan")
    private String jurusan;

    @ColumnInfo(name = "angkatan")
    private int angkatan;

    @ColumnInfo(name = "alamat")
    private String alamat;

    @ColumnInfo(name = "nomor_hp")
    private String nomorHp;

    public Mahasiswa(String nama, String jurusan, int angkatan, String alamat, String nomorHp) {
        this.nama = nama;
        this.jurusan = jurusan;
        this.angkatan = angkatan;
        this.alamat = alamat;
        this.nomorHp = nomorHp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public int getAngkatan() {
        return angkatan;
    }

    public void setAngkatan(int angkatan) {
        this.angkatan = angkatan;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNomorHp() {
        return nomorHp;
    }

    public void setNomorHp(String nomorHp) {
        this.nomorHp = nomorHp;
    }
}
