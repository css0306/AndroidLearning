package com.vivo11084921.notification;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.nio.channels.Channel;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button sendNotice = (Button) findViewById(R.id.send_notice);
        sendNotice.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.send_notice:
                Intent intent = new Intent(this, NotificationActivity.class);
                PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);
                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                if (Build.VERSION.SDK_INT >= 26) { // sdk26版本后要创建channel对象来接收部分设定
                    NotificationChannel channel = new NotificationChannel("Channel", "Channel", NotificationManager.IMPORTANCE_DEFAULT);
                    manager.createNotificationChannel(channel);
                    Notification notification = new NotificationCompat.Builder(MainActivity.this, "Channel" )
                            .setContentTitle("This is content title")
                            .setContentText("This is content text")
                            .setWhen(System.currentTimeMillis())
                            .setSmallIcon(R.mipmap.ic_launcher)
                            .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                            .setContentIntent(pi)
                            .setAutoCancel(true)
                            .setSound(Uri.fromFile(new File("/system/media/audio/ringtones/Kuma.ogg")))
                            .setVibrate(new long[]{0, 1000, 1000, 1000})
                            .setLights(Color.GREEN, 1000, 1000)
//                            .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(getResources(), R.drawable.big_image)))
                            .setPriority(NotificationCompat.PRIORITY_MAX)
                            .build();
                    manager.notify(1, notification);

                }else{
                    Notification notification = new NotificationCompat.Builder(MainActivity.this)
                            .setContentTitle("This is content title")
                            .setContentText("This is content text")
                            .setWhen(System.currentTimeMillis())
                            .setSmallIcon(R.mipmap.ic_launcher)
                            .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                            .setContentIntent(pi)
                            .setAutoCancel(true)
                            .setSound(Uri.fromFile(new File("/system/media/audio/ringtones/Kuma.ogg")))
                            .setVibrate(new long[]{0, 1000, 1000, 1000})
                            .setLights(Color.GREEN, 1000, 1000)
                            .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(getResources(), R.drawable.big_image)))
                            .setPriority(NotificationCompat.PRIORITY_MAX)
                            .build();
                    manager.notify(1, notification);
                }



//                        .setDefaults(NotificationCompat.DEFAULT_ALL)
                        //        .setStyle(new NotificationCompat.BigTextStyle().bigText("Learn how to build notifications, send and sync data, and use voice actions. Get the official Android IDE and developer tools to build apps for Android."))
//                        .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(getResources(), R.drawable.big_image)))
//                        .setPriority(NotificationCompat.PRIORITY_MAX)

                break;
            default:
                break;
        }
    }

}
