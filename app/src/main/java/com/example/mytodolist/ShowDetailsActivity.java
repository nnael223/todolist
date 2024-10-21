package com.example.mytodolist;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ShowDetailsActivity extends AppCompatActivity {

        private TextView titleTextView;
        private TextView contentTextView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_show_details);

            titleTextView = findViewById(R.id.titleTextView);
            contentTextView = findViewById(R.id.contentTextView);

            Intent intent = getIntent();
            String title = intent.getStringExtra("title");
            String content = intent.getStringExtra("content");

            titleTextView.setText(title);
            contentTextView.setText(content);
        }
    }
