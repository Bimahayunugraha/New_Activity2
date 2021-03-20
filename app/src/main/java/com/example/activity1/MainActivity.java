package com.example.activity1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edEmail,edPwd;
    Button button;
    String nama,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edEmail = (EditText) findViewById(R.id.editUser);
        edPwd = (EditText) findViewById(R.id.editPassword);
        button = (Button) findViewById(R.id.button);

        //Membuat fungsi onclik pada button signin
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Menyimpan input user di EditText password ke dalam variabel nama
                nama = edEmail.getText().toString();

                //Menyimpan input user di EditText password ke dalam variabel password
                password = edPwd.getText().toString();

                //Mengeset email yang benar
                String email = "admin123@mail.com";

                //Mengeset password yang benar
                String pass = "admin123";

                //Mengecek apakah EditText email dan password terdaoat isi atau tidak
                if (nama.isEmpty() || password.isEmpty()) {
                    //Membuat variabel Toast dan menampilkan pesan "EditText tidak boleh kosong"
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Email dan Password Wajib Diisi!!",
                            Toast.LENGTH_LONG);
                    //Menampilkan Toast
                    t.show();
                }else{
                    //Membuat variabel toast dan membuat tost untuk menampilkan toast sesuai kondisi
                    if (nama.equals("admin123@mail.com") && password.equals("admin123")){

                        //Jika Login Berhasil
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Login Berhasil",Toast.LENGTH_LONG);
                        t.show();

                        //Membuat objek bundle
                        Bundle b = new Bundle();

                        //Memasukkan value dari variabel nama dengan kunci "a" dan dimasukkan ke dalam bundle
                        b.putString("a", nama.trim());

                        //Memasukkan value dari variabel nama dengan kunci "b" dan dimasukkan ke dalam bundle
                        b.putString("b", password.trim());

                        //Membuat objek Intent berpindah activity dari MainActivity ke ActivityHasil
                        Intent i = new Intent(getApplicationContext(), ActivityHasil.class);

                        //Memasukkan bundle ke dalam Intent untuk dikirimkan ke ActivityHasil
                        i.putExtras(b);

                        //Berpindah ke ActivityHaasil
                        startActivity(i);
                    }else if (password.equals("admin123")){

                        //Jika Email Salah
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Email Salah",Toast.LENGTH_LONG);
                        t.show();
                    }
                    else if (nama.equals("admin123@mail.com")){

                        //Jika Password Salah
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Password Salah",Toast.LENGTH_LONG);
                        t.show();
                    }else {

                        //Jika Email dan Password Salah
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Email dan Password Salah",Toast.LENGTH_LONG);
                        t.show();
                    }
                }

            }
        });
    }
}