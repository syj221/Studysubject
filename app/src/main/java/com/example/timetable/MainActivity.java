package com.example.timetable;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.timetable.activity.TimeTableActivity;
import com.example.timetable.dao.UserDao;
import com.example.timetable.pojo.User;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    EditText username, password, reg_username, reg_password,
            reg_firstName, reg_lastName, reg_email, reg_confirmemail;
    Button login, signUp, reg_register;
    TextInputLayout txtInLayoutUsername, txtInLayoutPassword, txtInLayoutRegPassword;
    CheckBox rememberMe;
    SQLiteDatabase db;
    UserDao helper=new UserDao(MainActivity.this);
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
                String name=username.getText().toString().trim();
                String pwd=password.getText().toString().trim();
                if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(pwd)) {
                    List<User> users = helper.getALLDATA();
                    boolean flag = false;
                    for (int i = 0; i < users.size(); i++) {
                        User user= users.get(i);   //可存储账号数量
                        if (name.equals(user.getUserName()) && pwd.equals(user.getPassword())) {
                            flag = true;
                            break;
                        } else {
                            flag = false;
                        }
                    }
                    if (flag){
                        Toast toast = Toast.makeText(getApplicationContext(), "登录成功！", Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.CENTER, 30, 0); // 设置Toast位置
                        toast.show(); // 显示Toast
                        Intent intent=new Intent(MainActivity.this, TimeTableActivity.class);
                        startActivity(intent);
                        finish();
                    }else {
                        Toast toast = Toast.makeText(getApplicationContext(), "密码或用户名不正确！", Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.CENTER, 30, 0); // 设置Toast位置
                        toast.show(); // 显示Toast
                    }

                } else if (TextUtils.isEmpty(name) && !TextUtils.isEmpty(pwd)) {
                    Snackbar snackbar = Snackbar.make(view, "Please fill out these fields",
                            Snackbar.LENGTH_LONG);
                    View snackbarView = snackbar.getView();
                    snackbarView.setBackgroundColor(getResources().getColor(R.color.red));
                    snackbar.show();
                    txtInLayoutUsername.setError("Username should not be empty");
                } else if (!TextUtils.isEmpty(name) && TextUtils.isEmpty(pwd)) {
                    Snackbar snackbar = Snackbar.make(view, "Please fill out these fields",
                            Snackbar.LENGTH_LONG);
                    View snackbarView = snackbar.getView();
                    snackbarView.setBackgroundColor(getResources().getColor(R.color.red));
                    snackbar.show();
                    txtInLayoutPassword.setError("Password should not be empty");
                }else {
                    Snackbar snackbar = Snackbar.make(view, "Please fill out these fields",
                            Snackbar.LENGTH_LONG);
                    View snackbarView = snackbar.getView();
                    snackbarView.setBackgroundColor(getResources().getColor(R.color.red));
                    snackbar.show();
                    txtInLayoutUsername.setError("Username should not be empty");
                    txtInLayoutPassword.setError("Password should not be empty");
                }

//                if (rememberMe.isChecked()) {
//                    //Here you can write the codes if box is checked
//                } else {
//                    //Here you can write the codes if box is not checked
//                }

            }

        });

    }

    //The method for opening the registration page and another processes or checks for registering
    private void ClickSignUp() {
        //使register页面以dialog的方式弹出
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
                String userName=reg_username.getText().toString().trim();
                String password=reg_password.getText().toString().trim();
                String firstName=reg_firstName.getText().toString().trim();
                String lastName=reg_lastName.getText().toString().trim();
                String email=reg_email.getText().toString().trim();
                String confirmEmail=reg_confirmemail.getText().toString().trim();
                showNormalDialog(userName,password,firstName,lastName,email,confirmEmail);
            }

            private void showNormalDialog(String userName,String password,String firstName,String lastName,String email,String confirmEmail) {
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

                                if (!TextUtils.isEmpty(userName)&&!TextUtils.isEmpty(password)&&!TextUtils.isEmpty(firstName)&&!TextUtils.isEmpty(lastName)&&!TextUtils.isEmpty(email)&&!TextUtils.isEmpty(confirmEmail)){
                                    if (email.equals(confirmEmail)){
                                        User user=new User(userName,password,firstName,lastName,email);
//                                        helper.add(userName,password,firstName,lastName,email);
                                        helper.insert(user);
                                        Toast toast = Toast.makeText(getApplicationContext(), "注册成功！", Toast.LENGTH_LONG);
                                        toast.setGravity(Gravity.CENTER, 20, 0); // 设置Toast位置
                                        toast.show(); // 显示Toast
                                    }else {
                                        Toast toast = Toast.makeText(getApplicationContext(), "请确保两次输入email信息一致！", Toast.LENGTH_LONG);
                                        toast.setGravity(Gravity.CENTER, 20, 0); // 设置Toast位置
                                        toast.show(); // 显示Toast
                                    }

                                }else {
                                    Toast toast = Toast.makeText(getApplicationContext(), "信息不完整，注册失败！", Toast.LENGTH_LONG);
                                    toast.setGravity(Gravity.CENTER, 20, 0); // 设置Toast位置
                                    toast.show(); // 显示Toast
                                }
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
