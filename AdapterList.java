package com.example.siakad;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import java.util.ArrayList;
import java.util.HashMap;
public class AdapterList extends RecyclerView.Adapter<AdapterList.ViewHolder>{

    Context context;
    ArrayList<HashMap<String, String>> list_data;

    public AdapterList(MainActivity mainActivity, ArrayList<HashMap<String, String>> list_data) {
        this.context = mainActivity;
        this.list_data = list_data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.nim.setText(list_data.get(position).get("nim"));
        holder.nama.setText(list_data.get(position).get("nama"));
        holder.alamat.setText(list_data.get(position).get("alamat"));
        holder.jurusan.setText(list_data.get(position).get("jurusan"));
        holder.tmplahir.setText(list_data.get(position).get("tmplahir"));
        holder.tgllahir.setText(list_data.get(position).get("tgllahir"));
        holder.agama.setText(list_data.get(position).get("agama"));

    }

    @Override
    public int getItemCount() {
        return list_data.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nim,nama,jurusan,alamat,tmplahir,tgllahir,agama;
        

        public ViewHolder(View itemView) {
            super(itemView);
            nim = (TextView) itemView.findViewById(R.id.id_nim);
            nama=(TextView) itemView.findViewById(R.id.id_nama);
            jurusan=(TextView) itemView.findViewById(R.id.id_jurusan);
            alamat=(TextView) itemView.findViewById(R.id.id_alamat);
            tmplahir=(TextView) itemView.findViewById(R.id.id_tmplahir);
            tgllahir=(TextView) itemView.findViewById(R.id.id_tgllahir);
            agama=(TextView) itemView.findViewById(R.id.id_agama);
        }
    }
}
