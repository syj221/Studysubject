package com.example.timetable.activity;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.timetable.R;

public class NoteActivity extends AppCompatActivity {

    private EditText editTextNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        editTextNote = findViewById(R.id.editTextNote);
    }

    public void saveNote(View view) {
        String note = editTextNote.getText().toString();

        // 保存笔记到SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("MyNotes", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("note", note);
        editor.apply();

        Toast.makeText(this, "笔记已保存", Toast.LENGTH_SHORT).show();
    }
}