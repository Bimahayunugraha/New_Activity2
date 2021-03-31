package com.example.activity1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class LihatDataActivity extends AppCompatActivity {

    //Deklarasi variabel dengan jenis data TextView
    TextView tvnama, tvnomor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data);

        //Menghubungkan variabel tvnama dengan komponen TextView pada layout
        tvnama = findViewById(R.id.tvNamaKontak);

        //Menghubungkan variabel tvnomor dengan komponen TextView pada layout
        tvnomor = findViewById(R.id.tvNomorTelepom);

        /*Membuat variabel dengan jenis data bundle dan assign value
          dari variabel tersebut dengan getIntent().getExtras()*/
        Bundle bundle = getIntent().getExtras();

        /*Membuat variabel nama dan assign value dari pesan yang dikirimkan
          dari activity sebelumnya*/
        String nama = bundle.getString("a");

        /*Membuat fungsi untuk mengatur TextView nama dan nomor telepon
          berdasarkan pesan yang dikirimkan dari activity sebelumnya*/
        switch (nama)
        {
            case "Adijul" :
                tvnama.setText("M Adijul");
                tvnomor.setText("081901758634");
                break;
            case "Bima" :
                tvnama.setText("Bima HN");
                tvnomor.setText("087500434581");
                break;
            case "Dimas" :
                tvnama.setText("Dimas Aji P");
                tvnomor.setText("081205812345");
                break;
            case "Fitri" :
                tvnama.setText("Fitri A");
                tvnomor.setText("085367018351");
                break;
            case "Guntur" :
                tvnama.setText("Guntur H");
                tvnomor.setText("081231090700");
                break;
            case "Husni" :
                tvnama.setText("M Husni");
                tvnomor.setText("081500690176");
                break;
            case "Ilham" :
                tvnama.setText("Ilham W");
                tvnomor.setText("081456540120");
                break;
            case "Jemmy" :
                tvnama.setText("Jemmy G");
                tvnomor.setText("082190721561");
                break;
            case "Rama" :
                tvnama.setText("Rama W");
                tvnomor.setText("081100456781");
                break;
            case "Saiful" :
                tvnama.setText("Saiful M");
                tvnomor.setText("085290168243");
                break;
        }

    }
}