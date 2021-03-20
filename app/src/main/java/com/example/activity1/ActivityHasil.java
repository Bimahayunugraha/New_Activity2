package com.example.activity1;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityHasil extends AppCompatActivity {

    //Mendeklarasikan variabel dengan tipe data TextView
    TextView txEmail, txPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        //Menghubungkan variabel txEmail dengan komponen TextView pada layout
        txEmail = findViewById(R.id.tvHasil1);

        //Menghubungkan variabel txPassword dengan komponen TextView pada layout
        txPassword = findViewById(R.id.tvHasil2);

        //Mendeklarasikan variabel bundle yang akan digunakan untuk mengambil pesan
        //yang dikirimkan melalui method Intent
        Bundle bundle = getIntent().getExtras();

        //Membuat variabel string yang digunakan untuk menyimpan data yang dikirimkan
        //dari activity sebelumnya dengan kunci "a"
        String email = bundle.getString("a");

        //Membuat variabel string yang digunakan untuk menyimpan data yang dikirimkan
        //dari activity sebelumnya dengan kunci "b"
        String pass = bundle.getString("b");

        //Menampilkan value dari variabel email ke dalam txEmail
        txEmail.setText(email);

        //Menampilkan value dari variabel email ke dalam txPassword
        txPassword.setText(pass);
    }
}
