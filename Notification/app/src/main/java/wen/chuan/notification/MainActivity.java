package wen.chuan.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void click_btn(View v){
        NotificationManager msg_str = (NotificationManager)
                getSystemService(Context.NOTIFICATION_SERVICE);
        Bitmap msg_img = BitmapFactory.decodeResource(getResources(),
                R.mipmap.d123);
        PendingIntent pendingIntent =
                PendingIntent.getActivity(this, 0,
                        new Intent(this, MainActivity.class), 0);

        Notification notification = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.e123)
                .setLargeIcon(msg_img)
                .setContentTitle("Notification 應用")
                .setContentText("可是這是作業啊!")
                .setWhen(System.currentTimeMillis())
                .setDefaults(Notification.DEFAULT_ALL)
                .setLights(Color.GREEN, 1000, 1000)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .build();

        msg_str.notify(0, notification);

    }
}