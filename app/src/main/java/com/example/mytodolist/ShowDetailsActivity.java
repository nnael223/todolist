package com.example.mytodolist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ShowDetailsActivity extends AppCompatActivity {

        private TextView titleTextView;
        private TextView contentTextView;
        private EditText dlyadata22;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_show_details);

            titleTextView = findViewById(R.id.titleTextView);
            contentTextView = findViewById(R.id.contentTextView);
            dlyadata22 = findViewById(R.id.dlyadata22);


            Intent intent = getIntent();
            String title = intent.getStringExtra("title");
            String content = intent.getStringExtra("content");
            String date = intent.getStringExtra("date11");

            titleTextView.setText(title);
            contentTextView.setText(content);
            dlyadata22.setText(date);



            ImageButton nazad2 = findViewById(R.id.backBtn2);
            nazad2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
    }
