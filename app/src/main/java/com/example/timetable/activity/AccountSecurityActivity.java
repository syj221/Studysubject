package com.example.timetable.activity;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.timetable.R;

public class AccountSecurityActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private static final String PREFS_NAME = "MyPrefs";
    private static final String PHONE_NUMBER_KEY = "phoneNumber";
    private Button btnPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_security);

        sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        String phoneNumber = sharedPreferences.getString(PHONE_NUMBER_KEY, "1234567890");

        btnPhoneNumber = findViewById(R.id.btnPhoneNumber);
        btnPhoneNumber.setText("手机号码：" + phoneNumber);
    }

    public void changePhoneNumber(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("请输入新的手机号码");

        final EditText input = new EditText(this);
        builder.setView(input);

        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String newPhoneNumber = input.getText().toString();

                // 保存新的手机号码到 SharedPreferences
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(PHONE_NUMBER_KEY, newPhoneNumber);
                editor.apply();

                // 更新按钮上显示的手机号码
                btnPhoneNumber.setText("手机号码：" + newPhoneNumber);
            }
        });

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }
}