package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, RecyclerActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        ArrayList<picture> data = new ArrayList<>();
        PictureId pictureId = new PictureId();
        for (int i = 0; i < 27; i++) {
            picture myPicture = new picture();
            myPicture.setPictureId(pictureId.getPictureId(i + 1));
            data.add(myPicture);
        }
        initView();
        adapter myAdapter = new adapter(data);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }

    private void initView() {
        recyclerView = findViewById(R.id.recyclerview);
    }

}