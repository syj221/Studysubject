package com.example.timetable.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.timetable.R;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // 在这里可以为每个按钮添加点击事件处理
        findViewById(R.id.btn_basic_info).setOnClickListener(v -> {
            Intent intent = new Intent(SettingsActivity.this, BasicInfoActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.btn_software_settings).setOnClickListener(v -> {
            // 处理软件设置点击事件
            Intent intent = new Intent(SettingsActivity.this, SoftwareSettingsActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.btn_help_feedback).setOnClickListener(v -> {
            // 处理帮助反馈点击事件
            Intent intent=new Intent(SettingsActivity.this, HelpFeedbackActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.btn_message_settings).setOnClickListener(v -> {
            // 处理消息设置点击事件
                Intent intent = new Intent(SettingsActivity.this, ReminderSettingsActivity.class);
                startActivity(intent);
        });

        findViewById(R.id.btn_grade_settings).setOnClickListener(v -> {
            // 处理成绩设置点击事件
            String url = "http://www.hsu.edu.cn/";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        });

        findViewById(R.id.btn_notes).setOnClickListener(v -> {
            // 处理笔记点击事件
            Intent intent = new Intent(SettingsActivity.this, NoteActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.btn_super_club).setOnClickListener(v -> {
            // 处理笔记查看点击事件
            Intent intent = new Intent(SettingsActivity.this, DisplayNoteActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.btn_card_recharge).setOnClickListener(v -> {
            // 处理一卡通充值点击事件
            // 启动支付宝主页
            Intent intent = getPackageManager().getLaunchIntentForPackage("com.eg.android.AlipayGphone");
            if (intent != null) {
                startActivity(intent);
            } else {
                // 如果支付宝未安装，可以跳转至支付宝官网下载页面或其他处理方式
                Toast.makeText(this, "未安装支付宝应用", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.btn_privacy).setOnClickListener(v -> {
            String hsuUrl = "https://www.hsu.edu.cn/2391/list.htm";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(hsuUrl));
            startActivity(intent);
        });

        findViewById(R.id.btn_share).setOnClickListener(v -> {
            String csdnUrl = "https://www.csdn.net/";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(csdnUrl));
            startActivity(intent);
        });

        findViewById(R.id.btn_encourage).setOnClickListener(v -> {
            String baiduUrl = "https://tieba.baidu.com/index.html";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(baiduUrl));
            startActivity(intent);
        });
        findViewById(R.id.btn_more).setOnClickListener(v -> {
            String githubUrl = "https://github.com/";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(githubUrl));
            startActivity(intent);

        });
        findViewById(R.id.btn_more1).setOnClickListener(v -> {
            String huaweiUrl = "https://consumer.huawei.com/cn/phones/";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(huaweiUrl));
            startActivity(intent);
        });
    }
}