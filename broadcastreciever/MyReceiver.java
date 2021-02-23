package com.eyasseyam.broadcastreciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction().equals("اسم الاكشن ")){
            //اذا تحقق فعل هذا الاكشن
            //نفذ هذا الكود
            Intent i = new Intent(context,MyService.class);
            context.startService(i);
        }else  if (intent.getAction().equals("com.eyasseyam.broadcastreciever.eyas")){
            String name = intent.getStringExtra("name");

        }





    }
}
