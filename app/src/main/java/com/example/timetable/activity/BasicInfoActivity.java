package com.example.timetable.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.timetable.R;

public class BasicInfoActivity extends AppCompatActivity {
    private static final int DATABASE_VERSION = 2; // 增加版本号
    private Spinner spinnerSchool;
    private Spinner spinnerDepartment;
    private Spinner spinnerYear;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_info);

        spinnerSchool = findViewById(R.id.spinner_school);
        spinnerDepartment = findViewById(R.id.spinner_department);
        spinnerYear = findViewById(R.id.spinner_year);
        sharedPreferences = getSharedPreferences("BasicInfo", MODE_PRIVATE);

        // 示例数据，可以根据实际情况调整
        String[] schools = {"学校A", "学校B", "学校C"};
        String[] departments = {"院系A", "院系B", "院系C"};
        String[] years = {"2020", "2021", "2022"};

        ArrayAdapter<String> schoolAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, schools);
        schoolAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSchool.setAdapter(schoolAdapter);

        ArrayAdapter<String> departmentAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, departments);
        departmentAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDepartment.setAdapter(departmentAdapter);

        ArrayAdapter<String> yearAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, years);
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerYear.setAdapter(yearAdapter);

        // 从 SharedPreferences 读取保存的信息并设置默认选项
        loadSavedInfo();
    }

    private void loadSavedInfo() {
        String savedSchool = sharedPreferences.getString("school", "");
        String savedDepartment = sharedPreferences.getString("department", "");
        String savedYear = sharedPreferences.getString("year", "");

        setSpinnerSelection(spinnerSchool, savedSchool);
        setSpinnerSelection(spinnerDepartment, savedDepartment);
        setSpinnerSelection(spinnerYear, savedYear);
    }

    private void setSpinnerSelection(Spinner spinner, String value) {
        ArrayAdapter<?> adapter = (ArrayAdapter<?>) spinner.getAdapter();
        for (int i = 0; i < adapter.getCount(); i++) {
            if (adapter.getItem(i).equals(value)) {
                spinner.setSelection(i);
                break;
            }
        }
    }

    public void onConfirmClick(View view) {
        String selectedSchool = spinnerSchool.getSelectedItem().toString();
        String selectedDepartment = spinnerDepartment.getSelectedItem().toString();
        String selectedYear = spinnerYear.getSelectedItem().toString();

        // 保存信息到 SharedPreferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("school", selectedSchool);
        editor.putString("department", selectedDepartment);
        editor.putString("year", selectedYear);
        editor.apply();

        Toast.makeText(this, "信息已保存", Toast.LENGTH_LONG).show();
    }
}