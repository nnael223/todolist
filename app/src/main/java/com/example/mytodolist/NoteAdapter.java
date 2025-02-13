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

    public void removeNote(int position) {
        if (position >= 0 && position < notes.size()) {
            notes.remove(position);
            notifyItemRemoved(position);
        }
    }

    public static class NoteViewHolder extends RecyclerView.ViewHolder {
        private TextView titleTextView,textView22;
        private ImageButton lanceButton; // Ланс редактирует
        private ImageButton ydalitButton; // это удаляет



        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView1);
            lanceButton = itemView.findViewById(R.id.lanceButton1);
            ydalitButton = itemView.findViewById(R.id.ydalitButton1);
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
            lanceButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent editintent = new Intent(itemView.getContext(), LanceNoteActivity.class);  // itemView для поиска оказывается

                    editintent.putExtra("notePosition",getAdapterPosition());
                    editintent.putExtra("klyuchtitla",note.getTitle());
                    editintent.putExtra("opisaniye",note.getContent());
                    editintent.putExtra("date11", note.getDate());

                    ((Activity) itemView.getContext()).startActivityForResult(editintent,100);
                }
            });
            ydalitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION) {

                        AlertDialog.Builder builder = new AlertDialog.Builder(itemView.getContext());
                        builder.setTitle("Удалить")
                                .setMessage("Вы действительно хотите удалить?")
                                .setCancelable(false)
                                .setPositiveButton("Удалить", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        adapter.removeNote(position);
                                    }
                                })
                                .setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                });
                        AlertDialog dialog = builder.create();
                        dialog.show();
                        }

                    }
                });
            }


        }
    }

