package com.erikriosetiawan.recyclerviewexercise;

import android.app.Application;

import androidx.room.Room;

public class MainApplication extends Application {

    private static DatabaseMahasiswa db;

    @Override
    public void onCreate() {
        super.onCreate();
        db = Room.databaseBuilder(getApplicationContext(), DatabaseMahasiswa.class, "database-mahasiswa").allowMainThreadQueries().build();
    }

    public static DatabaseMahasiswa getDb() {
        return db;
    }
}
