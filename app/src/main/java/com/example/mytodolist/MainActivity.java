    package com.example.mytodolist;


    import android.content.Intent;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.TextView;

    import androidx.appcompat.app.AppCompatActivity;
    import androidx.appcompat.widget.AppCompatImageButton;
    import androidx.recyclerview.widget.LinearLayoutManager;
    import androidx.recyclerview.widget.RecyclerView;

    import java.util.ArrayList;

    public class MainActivity extends AppCompatActivity {

        private RecyclerView recyclerView;
        private NoteAdapter adapter;
        private ArrayList<Note> notes;
        private TextView emptyView1;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            recyclerView = findViewById(R.id.recyclerView);
            emptyView1 = findViewById(R.id.emptyView1);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            notes = new ArrayList<>();


            adapter = new NoteAdapter(notes, new NoteAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(Note note) {
                    Intent intent = new Intent(MainActivity.this, ShowDetailsActivity.class);
                    intent.putExtra("title", note.getTitle());
                    intent.putExtra("content", note.getContent());
                    intent.putExtra("date11", note.getDate());
                    startActivity(intent);
                }
            }, MainActivity.this);
            recyclerView.setAdapter(adapter);


            AppCompatImageButton addButton = findViewById(R.id.addNote);
            addButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, AddNoteActivity.class);
                    startActivityForResult(intent, 1);
                }
            });
        }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);

            if (requestCode == 1 && resultCode == RESULT_OK && data != null) {

                String title = data.getStringExtra("title");
                String content = data.getStringExtra("content");
                String date = data.getStringExtra("date11");

                Note newNote = new Note(title, content, date);

                notes.add(newNote);
                adapter.notifyItemInserted(notes.size() - 1);
            }

        }


    }


