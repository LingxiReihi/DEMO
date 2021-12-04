package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class LvChoose_Activity extends AppCompatActivity implements View.OnClickListener {

    protected Button lBtnSpoof, lBtnNext;
    protected ImageView lIvBackground;

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, LvChoose_Activity.class);
        context.startActivity(intent);
    }

    //初始化
    private void initView() {
        lBtnSpoof = findViewById(R.id.btn_lvChoose_spoof);
        lBtnNext = findViewById(R.id.btn_lvChoose_next);
        lIvBackground = findViewById(R.id.iv_lvChoose_background);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lv_choose);
        initView();
        //设置监听
        lBtnNext.setOnClickListener(this);
        lBtnSpoof.setOnClickListener(this);
    }

    //点击事件
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_lvChoose_next:
                next();
                break;
            case R.id.btn_lvChoose_spoof:
                nextActivity();
                break;
        }
    }

    //这两个方法没写好（名字）。。。

    private void nextActivity() {
        Toast.makeText(this, "进入恶搞界面", Toast.LENGTH_SHORT).show();
        SpoofActivity.startActivity(this);
    }

    private void next(){
        Toast.makeText(this,"进入下一页",Toast.LENGTH_SHORT).show();
        ShowActivity.startActivity(this);
    }
}