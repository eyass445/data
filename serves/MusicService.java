package com.eyasseyam.serves;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.IBinder;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class MusicService extends Service {

    //MediaPlayer mp;

    public final String Chanil_Id = "CH1";
    public final String Chanil_Name = "Chanil One";
    public final int importance = NotificationManager.IMPORTANCE_DEFAULT;



    public MusicService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //mp = MediaPlayer.create(this,R.raw.ss);

        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){


            NotificationChannel channel = new NotificationChannel(Chanil_Id,Chanil_Name,importance);
            channel.setDescription("DescriptionDescriptionDescriptionDescriptionDescriptionDescription");
            channel.setVibrationPattern(new long[]{1000,200,440,500,100,1000});
            channel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);
            channel.enableLights(true);
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(channel);


        }

        Intent intent = new Intent(getBaseContext(),Main2Activity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(getBaseContext(),0,intent,0);

        Intent intentAction = new Intent(getBaseContext(),Main2Activity.class);
        PendingIntent pendingIntenActiont = PendingIntent.getActivity(getBaseContext(),0,intentAction,0);



        NotificationCompat.Builder builder = new NotificationCompat.Builder(getBaseContext(),Chanil_Id);

        builder.setContentTitle("بلح");
        builder.setContentText("Content");
        builder.setSubText("bbnnghnhgngnhg");
        builder.setSmallIcon(R.drawable.ic_launcher_background);
        builder.setOngoing(true);
        builder.setContentIntent(pendingIntent);
        builder.setContentIntent(pendingIntenActiont);
        builder.addAction(R.drawable.ic_launcher_background,"ok",pendingIntent);
        builder.addAction(R.drawable.ic_launcher_background,"NO",pendingIntenActiont);

        startForeground(1,builder.build());

//        NotificationManagerCompat nm = NotificationManagerCompat.from(getBaseContext());
//        nm.notify(1,builder.build());


        Toast.makeText(this, "OnCreate servise", Toast.LENGTH_SHORT).show();




    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

//        if (!mp.isPlaying()){
//            mp.start();
//        }
        return START_STICKY;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy servise", Toast.LENGTH_SHORT).show();
//        mp.start();
//        mp.release();

    }
}
