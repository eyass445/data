package com.eyasseyam.broadcastreciever;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.SystemClock;

public class MyService2 extends Service {
    public MyService2() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE);
        Intent intent = new Intent(MyService2.this,MyReceiver.class);
        //intent.putExtra("name",name2);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),0,intent,0);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            manager.setExact(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime()+6*60*1000,pendingIntent);
        }

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
