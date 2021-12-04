package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mImgHead;
    private EditText mEtUsername;
    private EditText mEtPassword;
    private Button mBtnLogin, mBtnCreate;
    private CheckBox mCbRemember;
    String thisUsername;
    String thisPassword;
    Boolean isRemember;
    private SharedPreferences.Editor editor;

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();//调用initView方法
        mBtnLogin.setOnClickListener(this);//设置监听
        mBtnCreate.setOnClickListener(this);//设置监听
        mCbRemember.setOnClickListener(this);//设置监听
        if (isRemember) {
            mEtUsername.setText(thisUsername);
            mEtPassword.setText(thisPassword);
            mCbRemember.setChecked(true);
        }
    }

    //初始化View
    private void initView() {
        mImgHead = findViewById(R.id.img_main_head);
        mEtPassword = findViewById(R.id.et_main_password);
        mEtUsername = findViewById(R.id.et_main_username);
        mBtnLogin = findViewById(R.id.btn_main_login);
        mBtnCreate = findViewById(R.id.btn_main_create);
        SharedPreferences sharedPreferences = getSharedPreferences("date", MODE_PRIVATE);
        mCbRemember = findViewById(R.id.ck_main_remember);
        thisUsername = sharedPreferences.getString("username", "");
        thisPassword = sharedPreferences.getString("password", "");
        isRemember = sharedPreferences.getBoolean("ck_main_remember", false);
        editor = sharedPreferences.edit();
    }

    //调用onClick方法对点击做出判断
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //点击login按钮时调用login方法
            case R.id.btn_main_login:
                login();
                break;
            //点击create按钮时调用create按钮
            case R.id.btn_main_create:
                create();
                break;
        }
    }

    //create方法
    private void create() {
        CreateActivity.startActivity(this);
    }

    //login方法
    private void login() {
        String username = mEtUsername.getText().toString();
        String password = mEtPassword.getText().toString();
        //判断账号密码是否输入正确
        if (username.equals(thisUsername) && password.equals(thisPassword)) {
            loginSuccess(username, password);
        } else {
            loginFailure(username, password);
        }
    }

    //账号输入正确的方法
    private void loginSuccess(String username, String password) {
        //记住密码的功能
        if (mCbRemember.isChecked()) {
            editor.putBoolean("ck_main_remember", true);
            editor.putString("et_main_username", thisUsername);
            editor.putString("et_main_password", thisPassword);
        } else {
            editor.clear();
        }
        editor.apply();
        Toast.makeText(this, "登陆成功!", Toast.LENGTH_SHORT).show();//弹出“登陆成功”
        NextActivity.startActivity(this, username, password);//打开NextActivity并传入数据username，password
    }

    //账号输入错误的方法
    private void loginFailure(String username, String password) {
        if (username.equals(thisUsername) || password.equals(thisPassword)) {
            if (!username.equals(thisUsername)) {
                Toast.makeText(this, "账号好像输错了 :(", Toast.LENGTH_SHORT).show();//弹出……
            }
            if (!password.equals(thisPassword)) {
                Toast.makeText(this, "密码好像输错了 :(", Toast.LENGTH_SHORT).show();//弹出……
            }
        } else {
            Toast.makeText(this, "账号密码都错了 :(", Toast.LENGTH_SHORT).show();//弹出……
        }
    }

    //设置返回键使用方法
    private long mExitTime = 0L;

    //设置返回键发生事件
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            /*
             * 当当前时间大于上次按返回键的时间 2 秒时
             */
            if (System.currentTimeMillis() - mExitTime > 2000) {
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                mExitTime = System.currentTimeMillis();
                return false;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
