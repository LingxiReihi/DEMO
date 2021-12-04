package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class NextActivity extends AppCompatActivity implements View.OnClickListener {

    protected Button nButton;

    private static final String INTENT_USER_NAME = "username"; // intent 中的数据标记
    private static final String INTENT_PASSWORD = "password"; // intent 中的数据标记

    /**
     * 写一个 static 方法，让它来决定该传入那些数据
     */

    public static void startActivity(Context context, String username, String password) {
        Intent intent = new Intent(context, NextActivity.class);
        intent.putExtra(INTENT_USER_NAME, username);
        intent.putExtra(INTENT_PASSWORD, password);
        context.startActivity(intent);
    }

    private void initView() {
        nButton = findViewById(R.id.btn_next_next);
    }

    private String mUserName;
    private String mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        Intent intent = getIntent();
        mUserName = intent.getStringExtra(INTENT_USER_NAME);
        mPassword = intent.getStringExtra(INTENT_PASSWORD);
        initView();
        nButton.setOnClickListener(this);
    }

    private void nextActivity() {
        Toast.makeText(this, "继续", Toast.LENGTH_SHORT).show();
        LvChoose_Activity.startActivity(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_next_next) {
            nextActivity();
        }
    }
}