package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class SpoofActivity extends AppCompatActivity implements View.OnClickListener {

    protected Button sBtn;
    protected int sWinWidth;
    protected int sWinHeight;
    protected View sView, sIvBackground;

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, SpoofActivity.class);
        context.startActivity(intent);
    }

    private void initView() {
        sBtn = findViewById(R.id.btn_spoof_click);
        sView = findViewById(R.id.tv_spoof_out);
        sIvBackground = findViewById(R.id.iv_spoof_background);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spoof);
        initView();
        sBtn.setOnClickListener(this);
        sView.setOnClickListener(this);
        //获取屏幕宽度和高度
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        sWinWidth = displayMetrics.widthPixels;
        sWinHeight = displayMetrics.heightPixels;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_spoof_click:
                //随机移动到屏幕上的一个坐标
                float x = new Random().nextInt(sWinWidth - v.getWidth());
                float y = new Random().nextInt(sWinHeight - v.getHeight());
                v.setX(x);
                v.setY(y);
                break;
            case R.id.tv_spoof_out:
                out();
                break;
        }
    }

    public void out() {
        Toast.makeText(this, "点我干啥？\n那么大一个按钮不知道点吗？", Toast.LENGTH_SHORT).show();
    }

    //拦截返回键
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
}