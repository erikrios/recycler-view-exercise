package com.erikriosetiawan.recyclerviewexercise;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MahasiswaDao {

    @Query("SELECT * FROM mahasiswa")
    List<Mahasiswa> getAll();

    @Query("SELECT * FROM mahasiswa WHERE id IN (:id)")
    List<Mahasiswa> loadAllByIds(int[] id);

    @Query("SELECT * FROM mahasiswa WHERE angkatan = :angkatan")
    List<Mahasiswa> getMahasiswaByAngkatan(int angkatan);

    @Query("SELECT * FROM mahasiswa WHERE nama LIKE :nama " + "LIMIT 1")
    Mahasiswa findByName(String nama);

    @Insert
    void insertAll(Mahasiswa... mahasiswa);

    @Delete
    void delete(Mahasiswa mahasiswa);

    @Query("SELECT * FROM mahasiswa WHERE id = :id")
    Mahasiswa getMahasiswaById(int id);

    @Update()
    void update(Mahasiswa... mahasiswa);
}
