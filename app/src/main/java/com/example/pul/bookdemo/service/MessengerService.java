package com.example.pul.bookdemo.service;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 *
 * Created by pul on 2017/11/30.
 */

public class MessengerService extends Service {
    private static final String TAG = "MessengerService";

    private static class MessengerHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    Log.e(TAG,"receive msg form client "+ msg.getData().getString("msg"));
                    // 服务端传递消息给 客户端
                    Messenger client = msg.replyTo;
                    Message replyMessage = Message.obtain(null,2);
                    Bundle serviceBundle = new Bundle();
                    serviceBundle.putString("reply","消息已经收到，稍后回复你");
                    replyMessage.setData(serviceBundle);
                    try {
                        client.send(replyMessage);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    super.handleMessage(msg);
            }

        }
    }

    private final Messenger mMessenger = new Messenger(new MessengerHandler());

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mMessenger.getBinder();
    }
}
