package com.erikriosetiawan.recyclerviewexercise;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = (Mahasiswa.class), version = 1)
public abstract class DatabaseMahasiswa extends RoomDatabase {

    public abstract MahasiswaDao mahasiswaDao();
}
