package com.example.mytodolist;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Note {
    private String title;
    private String content;
    private String date;

    public Note(String title, String content, String date) {
        this.title = title;
        this.content = content;
        this.date = date;


    }

public void setDate(String date) {
        this.date = date ;
}

    public String getDate() {
        return date;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}

