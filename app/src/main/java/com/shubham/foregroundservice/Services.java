package com.shubham.foregroundservice;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class Services extends Service {
    @Override
    public void onCreate(){
        super.onCreate();

    }

    @Override
    public  int onStartCommand(Intent intent, int flags, int started){
        String editName = intent.getStringExtra("inputExtra");
        Intent intent1 = new Intent(this,MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent1,0);
        Notification notification = new NotificationCompat.Builder(this,App.CHANNEL_ID)
                .setContentTitle("SHUBHAM")
                .setContentText(editName)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentIntent(pendingIntent)
                .build();
        startForeground(1, notification);



        return START_NOT_STICKY;


    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
