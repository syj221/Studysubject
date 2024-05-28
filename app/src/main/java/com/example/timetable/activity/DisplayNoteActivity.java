package com.example.timetable.activity;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.timetable.R;

public class DisplayNoteActivity extends AppCompatActivity {

    private TextView textViewNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_note);

        textViewNote = findViewById(R.id.textViewNote);

        // 读取保存的笔记内容
        SharedPreferences sharedPreferences = getSharedPreferences("MyNotes", MODE_PRIVATE);
        String note = sharedPreferences.getString("note", "");

        // 显示笔记内容
        textViewNote.setText(note);
    }
}