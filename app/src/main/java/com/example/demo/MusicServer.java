package com.example.demo;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MusicServer extends Service {
    private MediaPlayer mediaPlayer;

    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        mediaPlayer.stop();

    }

    @Override
    @Deprecated
    public void onStart(Intent intent, int startId) {
        // TODO Auto-generated method stub
        super.onStart(intent, startId);
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(this, R.raw.alicegoodnight);
            mediaPlayer.setLooping(true);
            mediaPlayer.start();
        }
    }//划线是因为这种方法已经过时了（但我只在网上找到了这个方法。。。）

}

/**
 * 这上面为音乐播放的一个方法，还没了解透彻。。。
 * 但想要设置音乐播放直接照搬也可以
 */