package com.example.timetable;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.timetable.activity.TimeTableActivity;
import com.example.timetable.dao.UserDao;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    EditText username, password, reg_username, reg_password,
            reg_firstName, reg_lastName, reg_email, reg_confirmemail;
    Button login, signUp, reg_register;
    TextInputLayout txtInLayoutUsername, txtInLayoutPassword, txtInLayoutRegPassword;
    CheckBox rememberMe;
    SQLiteDatabase db;
    UserDao helper;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        signUp = findViewById(R.id.signUp);
        txtInLayoutUsername = findViewById(R.id.txtInLayoutUsername);
        txtInLayoutPassword = findViewById(R.id.txtInLayoutPassword);
        rememberMe = findViewById(R.id.rememberMe);


        ClickLogin();


        //SignUp's Button for showing registration page
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClickSignUp();
            }
        });


    }

    //This is method for doing operation of check login
    private void ClickLogin() {

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (username.getText().toString().trim().isEmpty()) {

                    Snackbar snackbar = Snackbar.make(view, "Please fill out these fields",
                            Snackbar.LENGTH_LONG);
                    View snackbarView = snackbar.getView();
                    snackbarView.setBackgroundColor(getResources().getColor(R.color.red));
                    snackbar.show();
                    txtInLayoutUsername.setError("Username should not be empty");
                } else {
                    //Here you can write the codes for checking username
                    if (password.getText().toString().trim().isEmpty()) {
                        Snackbar snackbar = Snackbar.make(view, "Please fill out these fields",
                                Snackbar.LENGTH_LONG);
                        View snackbarView = snackbar.getView();
                        snackbarView.setBackgroundColor(getResources().getColor(R.color.red));
                        snackbar.show();
                        txtInLayoutPassword.setError("Password should not be empty");
                    } else {
                        //Here you can write the codes for checking password
                        Intent intent = new Intent(MainActivity.this, TimeTableActivity.class);
                        startActivity(intent);
                    }
                }
//                if (password.getText().toString().trim().isEmpty()) {
//                    Snackbar snackbar = Snackbar.make(view, "Please fill out these fields",
//                            Snackbar.LENGTH_LONG);
//                    View snackbarView = snackbar.getView();
//                    snackbarView.setBackgroundColor(getResources().getColor(R.color.red));
//                    snackbar.show();
//                    txtInLayoutPassword.setError("Password should not be empty");
//                } else {
//                    //Here you can write the codes for checking password
//                }

                if (rememberMe.isChecked()) {
                    //Here you can write the codes if box is checked
                } else {
                    //Here you can write the codes if box is not checked
                }

            }

        });

    }

    //The method for opening the registration page and another processes or checks for registering
    private void ClickSignUp() {

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.register, null);
        dialog.setView(dialogView);

        reg_username = dialogView.findViewById(R.id.reg_username);
        reg_password = dialogView.findViewById(R.id.reg_password);
        reg_firstName = dialogView.findViewById(R.id.reg_firstName);
        reg_lastName = dialogView.findViewById(R.id.reg_lastName);
        reg_email = dialogView.findViewById(R.id.reg_email);
        reg_confirmemail = dialogView.findViewById(R.id.reg_confirmemail);
        reg_register = dialogView.findViewById(R.id.reg_register);
        txtInLayoutRegPassword = dialogView.findViewById(R.id.txtInLayoutRegPassword);

        reg_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (reg_username.getText().toString().trim().isEmpty()) {

                    reg_username.setError("Please fill out this field");
                } else {
                    //Here you can write the codes for checking username
                    if (reg_password.getText().toString().trim().isEmpty()) {
                        txtInLayoutRegPassword.setPasswordVisibilityToggleEnabled(false);
                        reg_password.setError("Please fill out this field");
                    } else {
                        txtInLayoutRegPassword.setPasswordVisibilityToggleEnabled(true);
                        //Here you can write the codes for checking password
                        if (reg_firstName.getText().toString().trim().isEmpty()) {

                            reg_firstName.setError("Please fill out this field");
                        } else {
                            //Here you can write the codes for checking firstname
                            if (reg_lastName.getText().toString().trim().isEmpty()) {

                                reg_lastName.setError("Please fill out this field");
                            } else {
                                //Here you can write the codes for checking lastname
                                if (reg_email.getText().toString().trim().isEmpty()) {

                                    reg_email.setError("Please fill out this field");
                                } else {
                                    //Here you can write the codes for checking email
                                    if (reg_confirmemail.getText().toString().trim().isEmpty()) {

                                        reg_confirmemail.setError("Please fill out this field");
                                    } else {
                                        //Here you can write the codes for checking confirmemail
                                        showNormalDialog();
                                    }
                                }
                            }
                        }
                    }
                }
//                if (reg_password.getText().toString().trim().isEmpty()) {
//                    txtInLayoutRegPassword.setPasswordVisibilityToggleEnabled(false);
//                    reg_password.setError("Please fill out this field");
//                } else {
//                    txtInLayoutRegPassword.setPasswordVisibilityToggleEnabled(true);
//                    //Here you can write the codes for checking password
//                }
//                if (reg_firstName.getText().toString().trim().isEmpty()) {
//
//                    reg_firstName.setError("Please fill out this field");
//                } else {
//                    //Here you can write the codes for checking firstname
//
//                }
//                if (reg_lastName.getText().toString().trim().isEmpty()) {
//
//                    reg_lastName.setError("Please fill out this field");
//                } else {
//                    //Here you can write the codes for checking lastname
//                }
//                if (reg_email.getText().toString().trim().isEmpty()) {
//
//                    reg_email.setError("Please fill out this field");
//                } else {
//                    //Here you can write the codes for checking email
//                }
//                if (reg_confirmemail.getText().toString().trim().isEmpty()) {
//
//                    reg_confirmemail.setError("Please fill out this field");
//                } else {
//                    //Here you can write the codes for checking confirmemail
//                }
            }

            private void showNormalDialog() {
                /* @setIcon 设置对话框图标
                 * @setTitle 设置对话框标题
                 * @setMessage 设置对话框消息提示
                 * setXXX方法返回Dialog对象，因此可以链式设置属性
                 */
                final AlertDialog.Builder normalDialog =
                        new AlertDialog.Builder(MainActivity.this);
                normalDialog.setIcon(R.drawable.avatar);
                normalDialog.setTitle("提交个人信息");
                normalDialog.setMessage("你确定信息无误吗?");
                normalDialog.setPositiveButton("确定",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //...To-do
                            }
                        });
                normalDialog.setNegativeButton("关闭",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //...To-do
                            }
                        });
                // 显示
                normalDialog.show();
            }
        });


        dialog.show();


    }


}
