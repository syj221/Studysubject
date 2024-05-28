package com.example.timetable.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.timetable.R;

public class HelpFeedbackActivity extends AppCompatActivity {

    private EditText editTextFeedback;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_feedback);

        editTextFeedback = findViewById(R.id.editTextFeedback);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String feedbackText = editTextFeedback.getText().toString();

                // 发送邮件至指定邮箱
                sendEmail("1605010842@qq.com", "用户反馈", feedbackText);
            }
        });
    }

    private void sendEmail(String email, String subject, String message) {
        // 在此处编写发送邮件的逻辑，可以使用 JavaMail 或第三方库来实现邮件发送功能
        // 这里仅提供逻辑示例，实际发送邮件需要额外配置和权限
    }
}