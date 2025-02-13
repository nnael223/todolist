package com.example.mytodolist;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class LanceNoteActivity extends AppCompatActivity {
    private ImageButton vihod,prinyat;
    private TextView textViewz;
    private EditText opisaniye,dlyadata;
    private int notePosition; // для хранения позиции заметки


@Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.lance_note);

    vihod = findViewById(R.id.artka1);
    prinyat = findViewById(R.id.prinyal1);
    textViewz = findViewById(R.id.zagalovok1);
    opisaniye = findViewById(R.id.opisaniye1);
    dlyadata = findViewById(R.id.dlyadata);


    dlyadata.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            final Calendar c  = Calendar.getInstance();

            int god = c.get(Calendar.YEAR);
            int mes = c.get(Calendar.MONTH);
            int den = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(LanceNoteActivity.this, new DatePickerDialog.OnDateSetListener() {
                @SuppressLint("SetTextI18n")
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    dlyadata.setText(year + "-" + (month + 1) + "-" + dayOfMonth);

                }
            }, god,mes,den);
            datePickerDialog.show();
        }
    });

    Intent intent = getIntent();
    String title = intent.getStringExtra("klyuchtitla");
    String content = intent.getStringExtra("opisaniye");
    String date = intent.getStringExtra("date11");
    notePosition = intent.getIntExtra("notePosition", -1);



    textViewz.setText(title);
    opisaniye.setText(content);
    dlyadata.setText(date);


    prinyat.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
    Intent rezultatintent = new Intent();

    rezultatintent.putExtra("klyuchtitla1",textViewz.getText().toString());
    rezultatintent.putExtra("opisanie1",opisaniye.getText().toString());
    rezultatintent.putExtra("datenew",dlyadata.getText().toString());
    rezultatintent.putExtra("notePosition",notePosition);
    setResult(RESULT_OK,rezultatintent);
    finish();

        }
    });
    vihod.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    });
}
}
