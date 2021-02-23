package com.eyasseyam.serves;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    Button btn_start , btn2_stop , note_bt;
//    public final String Chanil_Id = "CH1";
//    public final String Chanil_Name = "Chanil One";
//    public final int importance = NotificationManager.IMPORTANCE_DEFAULT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_start = findViewById(R.id.start_btn1);
        btn2_stop = findViewById(R.id.stop_btn2);
        note_bt = findViewById(R.id.button);

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(),MyIntentService.class);
                startService(intent);
            }
        });

        btn2_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(),MyIntentService.class);
                stopService(intent);
            }
        });

        note_bt.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {

//                if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
//                    NotificationChannel channel = new NotificationChannel(Chanil_Id,Chanil_Name,importance);
//                    channel.setDescription("DescriptionDescriptionDescriptionDescriptionDescriptionDescription");
//                    channel.setVibrationPattern(new long[]{1000,200,440,500,100,1000});
//                    channel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
//                    channel.enableLights(true);
//                    NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
//                    notificationManager.createNotificationChannel(channel);
//
//
//                }
//
//                Intent intent = new Intent(getBaseContext(),Main2Activity.class);
//                PendingIntent pendingIntent = PendingIntent.getActivity(getBaseContext(),0,intent,0);
//
//                Intent intentAction = new Intent(getBaseContext(),Main2Activity.class);
//                PendingIntent pendingIntenActiont = PendingIntent.getActivity(getBaseContext(),0,intentAction,0);
//
//
//                //NotificationCompat b = new  Notification.Builder(getBaseContext(),Chanil_Id);
//
//                Notification.Builder builder = new Notification.Builder(getBaseContext(),Chanil_Id);
//
//                builder.setContentTitle("بلح");
//                builder.setContentText("Content");
//                builder.setSubText("bbnnghnhgngnhg");
//                builder.setSmallIcon(R.drawable.ic_launcher_background);
//                builder.setOngoing(true);
//                builder.setContentIntent(pendingIntent);
//                builder.addAction(R.drawable.ic_launcher_background,"ok",pendingIntent);
//
//                NotificationManagerCompat nm = NotificationManagerCompat.from(getBaseContext());
//                nm.notify(1,builder.build());
//
//



             }
          }

        );













    }
}
