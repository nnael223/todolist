package com.example.mytodolist;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class AddNoteActivity extends AppCompatActivity {

    private EditText titleEditText;
    private EditText contentEditText;

    private TextView dateEditText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        titleEditText = findViewById(R.id.titleEditText);
        contentEditText = findViewById(R.id.contentEditText);
        dateEditText = findViewById(R.id.dateEditText);
        dateEditText.setText("Выберите дату");
        dateEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c  = Calendar.getInstance();

                int god = c.get(Calendar.YEAR);
                int mes = c.get(Calendar.MONTH);
                int den = c.get(Calendar.DAY_OF_MONTH);
                

                DatePickerDialog datePickerDialog = new DatePickerDialog(AddNoteActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        dateEditText.setText(year + "-" + (month + 1) + "-" + dayOfMonth);

                    }
                }, god,mes,den);
                datePickerDialog.show();
            }
        });



        Button saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = titleEditText.getText().toString();
                String content = contentEditText.getText().toString();
                String date = dateEditText.getText().toString();

                if(title.isEmpty()) {
                    titleEditText.setError("Введите хотя бы заголовок");
                    return;
                }

                if (date.isEmpty()) {
                    dateEditText.setError("Введите дату");
                    return;
                }


                Intent resultIntent = new Intent();
                resultIntent.putExtra("title", title);
                resultIntent.putExtra("content", content);
                resultIntent.putExtra("date11", date);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });

        ImageButton nazad = findViewById(R.id.backBtn);
        nazad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
