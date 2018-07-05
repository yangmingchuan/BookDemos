package com.example.pul.bookdemo.guolinservice;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.example.pul.bookdemo.R;
import com.example.pul.bookdemo.home.HomeActivity;

/**
 * 测试版service  记得需要在配置文件配置service
 * 1.startService   oncreate  -->  onStartCommand
 * 2.bindService   由于bind的时候传入的 int为1 ，则会 oncreate
 * 3.stopService     onDestroy
 * 4.unbindService   onDestroy
 *      如果分别 startService 并且bindService ，如想关闭就必须  stopService 和 unbindService
 * @packageName: com.example.pul.bookdemo.guolinservice
 * @fileName: GuolinService
 * @date: 2018/7/5  11:25
 * @author: ymc
 * @QQ:745612618
 */

public class GuolinService extends Service {
    private static final String TAG = "GuolinService";

    private MyBinder myBinder = new MyBinder();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return myBinder;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onCreate() {
        super.onCreate();

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this,"1");
        mBuilder.setSmallIcon(R.mipmap.ic_launcher);
        //设置标题
        mBuilder.setContentTitle("这是标题");
        //设置通知正文
        mBuilder.setContentText("这是正文，当前ID是：1" );
        //设置摘要
        mBuilder.setSubText("这是摘要");
        //设置是否点击消息后自动clean
        mBuilder.setAutoCancel(true);
        //显示指定文本
        mBuilder.setContentInfo("Info");
        //与setContentInfo类似，但如果设置了setContentInfo则无效果
        //用于当显示了多个相同ID的Notification时，显示消息总数
        mBuilder.setNumber(2);
        //通知在状态栏显示时的文本
        mBuilder.setTicker("在状态栏上显示的文本");
        //设置优先级
        mBuilder.setPriority(NotificationCompat.PRIORITY_MAX);
        //自定义消息时间，以毫秒为单位，当前设置为比系统时间少一小时
        mBuilder.setWhen(System.currentTimeMillis() - 3600000);
        //设置为一个正在进行的通知，此时用户无法清除通知
        mBuilder.setOngoing(true);
        //设置消息的提醒方式，震动提醒：DEFAULT_VIBRATE     声音提醒：NotificationCompat.DEFAULT_SOUND
        //三色灯提醒NotificationCompat.DEFAULT_LIGHTS     以上三种方式一起：DEFAULT_ALL
        mBuilder.setDefaults(NotificationCompat.DEFAULT_SOUND);
        //设置震动方式，延迟零秒，震动一秒，延迟一秒、震动一秒
        //mBuilder.setVibrate(new long[]{0, 1000, 1000, 1000});

        Intent intent = new Intent(this, HomeActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);
        mBuilder.setContentIntent(pIntent);

        NotificationManager mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        mNotificationManager.notify(1, mBuilder.build());
        Log.e(TAG, "onCreate() executed");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG, "onStartCommand() executed");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy() executed");
    }

     class MyBinder extends Binder {
        public void startDownload() {
            Log.e("TAG", "startDownload() executed");
            // 执行具体的下载任务
        }
    }

}
