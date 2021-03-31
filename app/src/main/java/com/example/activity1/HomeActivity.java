package com.example.activity1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    //Deklarasi variabel dengan jenis data ListView
    private ListView list;

    //Memanggil class ListViewAdapter dan diinisiasi menjadi variabel adapter
    private ListViewAdapter adapter;

    //Deklarasi array untuk menyimpan nama
    String[] listNama;

    //Memanggil class ClassNama
    public static ArrayList<ClassNama> classNamaArrayList = new ArrayList<ClassNama>();

    //Membuat objek Bundle
    Bundle bundle = new Bundle();

    //Membuat objek Intent
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Menyimpan nama didalam array ListNama
        listNama = new String[] {"Adijul", "Bima", "Dimas", "Fitri", "Guntur",
                                "Husni", "Ilham", "Jemmy", "Rama", "Saiful"};

        list = findViewById(R.id.listKontak);

        //Membuat onjek dari class ClassNama menjadi arrayList
        classNamaArrayList = new ArrayList<>();

        //Membaca objeck class pada array ListNama
        for (int i = 0; i < listNama.length; i++) {

            //Membuat objek class nama
            ClassNama classNama = new ClassNama(listNama[i]);

            //Binds string ke array
            classNamaArrayList.add(classNama);
        }

        //Membuat objek dari ListViewAdapter
        adapter = new ListViewAdapter(this);

        //binds adapter ke ListView
        list.setAdapter(adapter);

        //Membuat event dari List onClick
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //Deklarasi variabel nama yang berisi item yang diklik
                String nama = classNamaArrayList.get(position).getName();

                /*Memasukkan value dari variabel nama dengan kunci "a"
                  dan dimasukkan ke dalam bundle*/
                bundle.putString("a",nama.trim());

                //Membuat objek popup menu
                PopupMenu pm = new PopupMenu(getApplicationContext(), view);

                //Membuat event untuk popup menu ketika dipilih
                pm.setOnMenuItemClickListener(HomeActivity.this);

                //Menampilkan popup menu dari layout menu
                pm.inflate(R.menu.popup_menu);

                //Menampilkan popup menu
                pm.show();
            }
        });
    }

    //Event yang terjadi ketika menu dipilih
    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId())
        {
            case R.id.mnView :
                intent = new Intent(getApplicationContext(),LihatDataActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.mnEdit :
                Toast.makeText(getApplicationContext(), "Edit kontak disini", Toast.LENGTH_LONG).show();
                break;
        }
        return true;
    }
}