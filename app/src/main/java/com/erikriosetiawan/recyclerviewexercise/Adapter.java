package com.erikriosetiawan.recyclerviewexercise;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.AdapterViewHolder> {

    List<Mahasiswa> data;

    public Adapter(List<Mahasiswa> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recycler, parent, false);
        return new AdapterViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewHolder holder, int position) {
        Mahasiswa item = data.get(position);
        holder.nama.setText(item.getNama());
        holder.jurusan.setText(item.getJurusan());
        holder.angkatan.setText(String.valueOf(item.getAngkatan()));
        holder.alamat.setText(item.getAlamat());
        holder.noHp.setText(item.getNomorHp());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void addAll(List<Mahasiswa> data) {
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    class AdapterViewHolder extends RecyclerView.ViewHolder {

        TextView nama, jurusan, angkatan, alamat, noHp;

        public AdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            nama = itemView.findViewById(R.id.txt_nama);
            jurusan = itemView.findViewById(R.id.txt_jurusan);
            angkatan = itemView.findViewById(R.id.txt_angkatan);
            alamat = itemView.findViewById(R.id.txt_alamat);
            noHp = itemView.findViewById(R.id.txt_no_hp);
        }
    }
}
