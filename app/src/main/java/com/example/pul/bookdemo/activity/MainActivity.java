package com.example.pul.bookdemo.activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.pul.bookdemo.R;
import com.example.pul.bookdemo.bean.PieData;
import com.example.pul.bookdemo.service.MessengerService;
import com.example.pul.bookdemo.view.OneView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private Messenger mService;
    private OneView oneView;
    private Messenger mGetReplyMessenger = new Messenger(new MessengerHandler());
    private static class MessengerHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 2:
                    Log.e(TAG,"revice msg from service :"+msg.getData().get("reply"));
                    break;
            }
            super.handleMessage(msg);
        }
    }

    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mService = new Messenger(service);
            Message msg = Message.obtain(null,1);
            Bundle bundle = new Bundle();
            bundle.putString("msg","hello,this is client");
            msg.setData(bundle);
            msg.replyTo = mGetReplyMessenger;
            try {
                mService.send(msg);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent messagerInter = new Intent(this,MessengerService.class);
        bindService(messagerInter,mConnection, Context.BIND_AUTO_CREATE);
        oneView = findViewById(R.id.one_view);
        oneView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(MainActivity.this, ZhiHuAdvertisingActivity.class);
                startActivity(mIntent);
            }
        });
        List<PieData> pieDataList = new ArrayList<>();
        PieData pieData = new PieData("ymc",50);
        PieData pieData1 = new PieData("ymc1",40);
        PieData pieData2 = new PieData("ymc2",30);
        PieData pieData3 = new PieData("ymc3",40);
        PieData pieData4 = new PieData("ymc4",10);
        pieDataList.add(pieData);
        pieDataList.add(pieData1);
        pieDataList.add(pieData2);
        pieDataList.add(pieData3);
        pieDataList.add(pieData4);
        oneView.setData(pieDataList);
    }

    @Override
    protected void onDestroy() {
        unbindService(mConnection);
        super.onDestroy();
    }
}
