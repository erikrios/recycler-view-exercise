package com.erikriosetiawan.recyclerviewexercise;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.AdapterViewHolder> {

    List<Mahasiswa> data;
    int position;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

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
    public void onBindViewHolder(@NonNull final AdapterViewHolder holder, int position) {
        Mahasiswa item = data.get(position);
        holder.nama.setText(item.getNama());
        holder.jurusan.setText(item.getJurusan());
        holder.angkatan.setText(String.valueOf(item.getAngkatan()));
        holder.alamat.setText(item.getAlamat());
        holder.noHp.setText(item.getNomorHp());
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                setPosition(holder.getAdapterPosition());
                return false;
            }
        });
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

    public Mahasiswa getMahasiswa(int position) {
        return data.get(position);
    }

    public void deleteMahasiswa(int position) {
        data.remove(position);
        notifyItemRemoved(position);
    }

    class AdapterViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {

        TextView nama, jurusan, angkatan, alamat, noHp;

        public AdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            nama = itemView.findViewById(R.id.txt_nama);
            jurusan = itemView.findViewById(R.id.txt_jurusan);
            angkatan = itemView.findViewById(R.id.txt_angkatan);
            alamat = itemView.findViewById(R.id.txt_alamat);
            noHp = itemView.findViewById(R.id.txt_no_hp);
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            menu.add(0, 1, getAdapterPosition(), "Ubah");
            menu.add(0, 3, getAdapterPosition(), "Hapus");
        }
    }
}
