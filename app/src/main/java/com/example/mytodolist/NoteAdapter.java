package com.example.mytodolist;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {



    public interface OnItemClickListener {
        void onItemClick(Note note);
    }

    private ArrayList<Note> notes;
    private OnItemClickListener listener;

    public NoteAdapter(ArrayList<Note> notes, OnItemClickListener listener,Activity activity) {
        this.notes = notes;
        this.listener = listener;

    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item, parent, false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        Note note = notes.get(position);
        holder.bind(note, listener, this);
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }



    public static class NoteViewHolder extends RecyclerView.ViewHolder {
        private TextView titleTextView,textView22;
        private ImageButton lanceButton; // Ланс редактирует
        private ImageButton ydalitButton; // это удаляет



        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView1);
            textView22 = itemView.findViewById(R.id.textView22); // для даты
        }

        public void bind(final Note note, final OnItemClickListener listener, final NoteAdapter adapter) {
            titleTextView.setText(note.getTitle());
            textView22.setText(note.getDate());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(note);
                }
            });




        }
    }
}

