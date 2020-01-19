package com.app.databku;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.app.databku.adapter.AdapterKu;
import com.app.databku.databaseku.MyDatabaseKu;
import com.app.databku.modal.ModalKu;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    MyDatabaseKu dbku;
    AdapterKu adapterku;
    GridLayoutManager gm;

    List<ModalKu> modalList;
    List<ModalKu> modalListAll;

    EditText name, alamat, pekerjaan;
    Button tambah;
    RecyclerView recycler_view;

    String namaString, alamatString, pekerjaanString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbku = new MyDatabaseKu(this);

        name = findViewById(R.id.name);
        alamat = findViewById(R.id.alamat);
        pekerjaan = findViewById(R.id.pekerjaan);

        tambah = findViewById(R.id.tambah);
        recycler_view = findViewById(R.id.recycler_view);

        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                namaString = name.getText().toString();
                alamatString = alamat.getText().toString();
                pekerjaanString = pekerjaan.getText().toString();

                dbku.tambahData(new ModalKu(namaString, alamatString, pekerjaanString));
                Toast.makeText(getApplicationContext(), "DATA BERHASIL DI TAMBAH", Toast.LENGTH_LONG).show();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                }, 2000);


            }
        });

        gm = new GridLayoutManager(this, 1);
        recycler_view.setLayoutManager(gm);

        modalListAll = new ArrayList<>();
        modalList = dbku.tampilkanSemuaUser();

        for (ModalKu m : modalList){

            ModalKu listKu = new ModalKu();
            listKu.setName(m.getName());
            listKu.setAlamat(m.getAlamat());
            listKu.setPekerjaan(m.getPekerjaan());

            modalListAll.add(listKu);
        }

        adapterku = new AdapterKu(this, modalListAll);
        recycler_view.setAdapter(adapterku);
        adapterku.notifyDataSetChanged();

    }
}
