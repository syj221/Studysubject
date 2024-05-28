package com.example.timetable.activity;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import com.example.timetable.R;

import java.util.Calendar;
public class ReminderSettingsActivity extends AppCompatActivity {

    private Switch dailyReminderSwitch;
    private TextView reminderTimeTextView;

    private int hour, minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder_settings);

        dailyReminderSwitch = findViewById(R.id.switch_daily_reminder);
        reminderTimeTextView = findViewById(R.id.text_reminder_time);

        // 设置每日提醒开关的监听事件
        dailyReminderSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // 根据isChecked状态做相应操作
            }
        });
        reminderTimeTextView = findViewById(R.id.text_reminder_time);

        // 设置提醒时间文本视图的点击事件监听器
        reminderTimeTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 获取当前时间
                final Calendar calendar = Calendar.getInstance();
                hour = calendar.get(Calendar.HOUR_OF_DAY);
                minute = calendar.get(Calendar.MINUTE);

                // 创建时间选择对话框
                TimePickerDialog timePickerDialog = new TimePickerDialog(ReminderSettingsActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int selectedHour, int selectedMinute) {
                                hour = selectedHour;
                                minute = selectedMinute;

                                // 更新提醒时间文本视图显示的时间
                                String time = String.format("%02d:%02d", hour, minute);
                                reminderTimeTextView.setText(time);
                            }
                        }, hour, minute, true);

                // 显示时间选择对话框
                timePickerDialog.show();
            }
        });
    }

}