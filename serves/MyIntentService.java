package com.eyasseyam.serves;

import android.app.IntentService;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.Toast;


public class MyIntentService extends IntentService {



    public MyIntentService() {
        super("MyIntentService");
    }


    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "OnCreate servise", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onHandleIntent(Intent intent) {




        try {

            Thread.sleep(5000);


        }catch (InterruptedException e){
          e.printStackTrace();
        }

        Toast.makeText(this, "onHandleIntent servise", Toast.LENGTH_SHORT).show();




    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy ", Toast.LENGTH_SHORT).show();


    }


}
