package com.example.allclass;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // هين موجود كلاس الاشعارات

    Button btn;
    public static final String CHANNEL_ID = "x_channelId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayNotif();
            }
        });
    }

    private void displayNotif() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID,"CHANNEL display name", NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("my channel des");

            NotificationManager nm = getSystemService(NotificationManager.class);
            nm.createNotificationChannel(channel);
        }

        Intent intent = new Intent(this,MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this,0,intent,0);


        NotificationCompat.Builder builder = new NotificationCompat.Builder(getBaseContext(),CHANNEL_ID);
        builder.setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("My titel")
                .setContentText("eyas eyassssssssssssssss")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setStyle(new NotificationCompat.BigTextStyle().bigText("My Data"))
                .addAction(R.drawable.ic_launcher_foreground,"Replay",pi);


        NotificationManagerCompat nC = NotificationManagerCompat.from(this);
        nC.notify(10,builder.build());


    }
}