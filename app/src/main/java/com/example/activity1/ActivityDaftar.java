package com.example.activity1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class ActivityDaftar extends AppCompatActivity {

    //Deklarasi variabel dengan tipe data EditText
    EditText edtNama, edtAlamat, edtEmail, edtPassword, edtRepass;

    //Deklarasi variabel dengan tipe data Floating Action Button
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        //Menghubungkan variabel edtNama dengan komponen EditText pada layout
        edtNama = (EditText) findViewById((R.id.edNama));

        //Menghubungkan variabel edtAlamat dengan komponen EditText pada layout
        edtAlamat = (EditText) findViewById(R.id.edAlamat);

        //Menghubungkan variabel edtEmail dengan komponen EditText pada layout
        edtEmail = (EditText) findViewById(R.id.edEmail);

        //Menghubungkan variabel edtPassword dengan komponen EditText pada layout
        edtPassword = (EditText) findViewById(R.id.edPass);

        //Menghubungkan variabel edtRepass dengan komponen EditText pada layout
        edtRepass = (EditText) findViewById(R.id.edRepass);

        //Menghubungkan variabel fab dengan komponen Floating button pada layout
        fab = (FloatingActionButton) findViewById(R.id.fabSimpan);

        //Membuat method untuk event dari Floating Button
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Membuat kondisi untuk mengecek apakah EditText kosong atau tidak
                if (edtNama.getText().toString().isEmpty() ||
                    edtAlamat.getText().toString().isEmpty() ||
                    edtEmail.getText().toString().isEmpty() ||
                    edtPassword.getText().toString().isEmpty() ||
                    edtRepass.getText().toString().isEmpty())
                {
                    //Menampilkan pesan notifikasi jika seluruh EditText wajib diisi
                    Snackbar.make(view,"Wajib Isi Seluruh Data!!!", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                }
                else
                {
                    //Membuat kondisi untuk mengecek apakah isi dari EditText password dan EditText repassword sama atau tidak
                    if (edtPassword.getText().toString().equals(edtRepass.getText().toString()))
                    {
                        //Menampilkan pesan notifikasi jika pendaftaran berhasil
                        Toast.makeText(getApplicationContext(), "Pendaftaran Berhasil", Toast.LENGTH_LONG).show();

                        //Method untuk kembali ke MainActivity
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                    }
                    else
                    {
                        //Menampilkan pesan bahwa isi dari EditText password dan EditText repassword tidak sama
                        Snackbar.make(view,"Password dan Repassword Harus Sama", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    }

                }
            }
        });
    }

}