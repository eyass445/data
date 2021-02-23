package com.eyasseyam.broadcastreciever;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {

    MediaPlayer mp;



    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }



    @Override
    public void onCreate() {
        super.onCreate();

        mp = MediaPlayer.create(this,R.raw.ss);

        Toast.makeText(this, "OnCreate servise", Toast.LENGTH_SHORT).show();


    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        if (!mp.isPlaying()){
            mp.start();
        }

        //return START_STICKY;
        return  START_NOT_STICKY;

    }



    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy servise", Toast.LENGTH_SHORT).show();
        mp.start();
        mp.release();
    }
}
