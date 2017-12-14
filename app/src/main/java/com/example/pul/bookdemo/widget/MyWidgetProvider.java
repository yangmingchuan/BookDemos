package com.example.pul.bookdemo.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.SystemClock;
import android.widget.RemoteViews;
import android.widget.Toast;
import com.example.pul.bookdemo.R;

/**
 * @packageName: com.example.pul.bookdemo.widget
 * @fileName: MyWidgetProvider
 * @date: 2017/12/13  14:42
 * @author: ymc
 * @QQ:745612618
 *  代码来源 ： Android 开发艺术 第五章 RemoteView 225#
 */

public class MyWidgetProvider extends AppWidgetProvider {
    private static final String TAG = "MyWidgetProvider";
    private static final String CLICK_ACTION = "com.example.pul.bookdemo.clickaction";

    @Override
    public void onReceive(final Context context, Intent intent) {
        super.onReceive(context, intent);
        if (intent.getAction().equals(CLICK_ACTION)) {
            Toast.makeText(context, "check it", Toast.LENGTH_SHORT).show();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    Bitmap srcBitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.widget);
                    AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
                    for (int i = 0; i < 37; i++) {
                        float degree = (i * 10) % 360;
                        RemoteViews remoteViews = new RemoteViews(context.getPackageName(),R.layout.layout_widget);
                        remoteViews.setImageViewBitmap(R.id.iv_widget,rotateBitmap(context,srcBitmap,degree));
                        Intent clickIntent = new Intent();
                        clickIntent.setAction(CLICK_ACTION);
                        PendingIntent pendingIntent = PendingIntent.getBroadcast(context,0,clickIntent,0);
                        remoteViews.setOnClickPendingIntent(R.id.iv_widget,pendingIntent);
                        appWidgetManager.updateAppWidget(new ComponentName(context,MyWidgetProvider.class),remoteViews);
                        SystemClock.sleep(50);
                    }
                }
            }).start();
        }
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        int counter = appWidgetIds.length;
        for(int i=0;i<counter;i++){
            int appwidgetid = appWidgetIds[i];
            onWidgetUpdate(context,appWidgetManager,appwidgetid);
        }
    }

    /**
     * 桌面小部件更新
     */
    private void onWidgetUpdate(Context context,AppWidgetManager appWidgetManager,int appid){
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(),R.layout.layout_widget);
        // 桌面小部件 点击事件
        Intent intentClick = new Intent();
        intentClick.setAction(CLICK_ACTION);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context,0,intentClick,0);
        remoteViews.setOnClickPendingIntent(R.id.iv_widget,pendingIntent);
        appWidgetManager.updateAppWidget(appid,remoteViews);
    }


    /**
     * 旋转角度
     * @param context
     * @param bitmap
     * @param degree
     * @return
     */
    private Bitmap rotateBitmap(Context context ,Bitmap bitmap ,float degree){
        Matrix matrix = new Matrix();
        matrix.reset();
        matrix.setRotate(degree);
        Bitmap tmpBitmap = Bitmap.createBitmap(bitmap,0,0,bitmap.getWidth(),bitmap.getHeight(),matrix,true);
        return tmpBitmap;
    }
}
