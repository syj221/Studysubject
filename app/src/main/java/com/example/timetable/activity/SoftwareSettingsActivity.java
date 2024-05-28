package com.example.timetable.activity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.timetable.R;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SoftwareSettingsActivity extends AppCompatActivity {

    private String readAgreementText() {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            InputStream inputStream = getResources().openRawResource(R.raw.xieyi);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
    private void showAgreementDialog(String agreementText) {
        // 在对话框中显示协议文本内容
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("服务协议");
        builder.setMessage(agreementText);
        builder.setPositiveButton("确定", null);
        builder.show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_software_settings);

        Button btnAccountSecurity = findViewById(R.id.btn_account_security);
        Button btnServiceAgreement = findViewById(R.id.btn_service_agreement);
        Button btnLogout = findViewById(R.id.btn_logout);

        btnAccountSecurity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 处理账号与安全功能
                Intent intent = new Intent(SoftwareSettingsActivity.this, AccountSecurityActivity.class);
                startActivity(intent);
            }
        });


// Modify the onClick listener for the "服务协议" button
        btnServiceAgreement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String agreementText = readAgreementText();
                showAgreementDialog(agreementText);
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 处理退出登录功能
            }
        });
    }


}