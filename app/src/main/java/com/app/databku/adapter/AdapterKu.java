package com.app.databku.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.databku.R;
import com.app.databku.databaseku.MyDatabaseKu;
import com.app.databku.modal.ModalKu;

import java.util.List;

public class AdapterKu extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<ModalKu> modalKus;

    public AdapterKu(Context context, List<ModalKu> modalKus) {
        this.context = context;
        this.modalKus = modalKus;
    }

    class MyAdapterKu extends RecyclerView.ViewHolder{

        TextView name, alamat, pekerjaan;

        public MyAdapterKu(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            alamat = itemView.findViewById(R.id.alamat);
            pekerjaan = itemView.findViewById(R.id.pekerjaan);

        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.activity_adapter, viewGroup, false);

        return new MyAdapterKu(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        ((MyAdapterKu) viewHolder).name.setText(modalKus.get(i).getName());
        ((MyAdapterKu) viewHolder).alamat.setText(modalKus.get(i).getAlamat());
        ((MyAdapterKu) viewHolder).pekerjaan.setText(modalKus.get(i).getPekerjaan());

    }

    @Override
    public int getItemCount() {
        return modalKus.size();
    }
}
