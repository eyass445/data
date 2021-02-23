package com.eyasseyam.broadcastreciever;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.PowerManager;

public class MainActivity extends AppCompatActivity {

    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // لعمل رسيفر يرسل للتطبيقات
        Intent i = new Intent();
        i.setAction("com.eyasseyam.broadcastreciever.eyas");
        i.putExtra("name","eyassss");
        sendBroadcast(i);





//        IntentFilter filter = new IntentFilter();
//        filter.addAction(Intent.ACTION_POWER_CONNECTED);
        //sendBroadcast(new Intent(""));
//        registerReceiver(pr, filter);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
       // unregisterReceiver(pr);
    }
}

