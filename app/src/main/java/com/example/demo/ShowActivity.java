package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ShowActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView sIvPicture;
    private Button sBtnNext, sBtnLast;
    private TextView sTvPic;
    int i = 1;
    PictureId pictureId = new PictureId();

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, ShowActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = new Intent(ShowActivity.this, MusicServer.class);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        initView();
        sBtnNext.setOnClickListener(this);
        sBtnLast.setOnClickListener(this);
        startService(intent);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }

    public void onStop() {
        Intent intent = new Intent(ShowActivity.this, MusicServer.class);
        stopService(intent);
        super.onStop();
    }

    private void initView() {
        sIvPicture = findViewById(R.id.iv_show_picture);
        sBtnLast = findViewById(R.id.btn_show_last);
        sBtnNext = findViewById(R.id.btn_show_next);
        sTvPic = findViewById(R.id.tv_show_picNum);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_show_next:
                next();
                break;
            case R.id.btn_show_last:
                last();
                break;
        }
    }

    @SuppressLint("SetTextI18n")
    private void last() {
        if (i == 1) {
            Toast.makeText(this, "已经是第一张了", Toast.LENGTH_SHORT).show();
        } else {
            i -= 1;
            sIvPicture.setImageResource(pictureId.getPictureId(i));
            sTvPic.setText(Integer.toString(i));
        }
    }

    @SuppressLint("SetTextI18n")
    private void next() {
        if (i == 27) {
            Toast.makeText(this, "已经是最后一张了", Toast.LENGTH_SHORT).show();
        } else {
            i += 1;
            sIvPicture.setImageResource(pictureId.getPictureId(i));
            sTvPic.setText(Integer.toString(i));
        }
    }
}