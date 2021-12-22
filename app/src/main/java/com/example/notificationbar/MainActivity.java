package com.example.notificationbar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button send_notification;
    NotificationManager nm;

    public final  String NOTIFICATION_ID="1";
    public final String NOTIFICATION_NAME="Example";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        send_notification = findViewById(R.id.btn_send);
        nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            creatNotificationChannel();

        }
        NotificationCompat.Builder n= new NotificationCompat.Builder(this,NOTIFICATION_ID);
        n.setContentTitle("suraj");
        n.setContentText("in android studio you should leran " +
                "many things like java basics array and etc.");
        n.setSmallIcon(R.drawable.notifications);


        // update some values

        nm.notify(1,n.build());
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void creatNotificationChannel() {
        NotificationChannel nc=new NotificationChannel(NOTIFICATION_ID,NOTIFICATION_NAME,NotificationManager.IMPORTANCE_DEFAULT);
        nc.enableVibration(true);
        nm.createNotificationChannel(nc);

    }
}