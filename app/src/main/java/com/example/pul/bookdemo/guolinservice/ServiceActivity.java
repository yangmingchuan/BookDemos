package com.example.pul.bookdemo.guolinservice;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.pul.bookdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * service 学习界面   测试一下 asynctask 使用方法
 * https://blog.csdn.net/guolin_blog/article/details/11952435
 */

public class ServiceActivity extends AppCompatActivity {

    @BindView(R.id.button)
    Button button;
    @BindView(R.id.button2)
    Button button2;
    @BindView(R.id.button3)
    Button button3;
    @BindView(R.id.button4)
    Button button4;

    private GuolinService.MyBinder myBinder;

    private ServiceConnection connection = new ServiceConnection() {

        @Override
        public void onServiceDisconnected(ComponentName name) {
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myBinder = (GuolinService.MyBinder) service;
            myBinder.startDownload();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.button ,R.id.button2 ,R.id.button3 ,R.id.button4})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.button:
                Intent startIntent = new Intent(this, GuolinService.class);
                startService(startIntent);
                break;
            case R.id.button2:
                Intent bindIntent = new Intent(this, GuolinService.class);
                bindService(bindIntent, connection, BIND_AUTO_CREATE);
                break;
            case R.id.button3:
                Intent stopIntent = new Intent(this, GuolinService.class);
                stopService(stopIntent);
                break;
            case R.id.button4:
                unbindService(connection);
                break;
        }
    }


    /**
     * 1. Params
     * 在执行AsyncTask时需要传入的参数，可用于在后台任务中使用。
     * 2. Progress
     * 后台任务执行时，如果需要在界面上显示当前的进度，则使用这里指定的泛型作为进度单位。
     * 3. Result
     * 当任务执行完毕后，如果需要对结果进行返回，则使用这里指定的泛型作为返回值类型。
     */
    class DownloadTask extends AsyncTask<Void, Integer, Boolean> {

        /**
         * 在后台task刚创建的时候 调用 用于初始化一些东西
         */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        /**
         * 该方法都是在子线程中运行的，耗时操作
         * 如果需要更新UI元素，可以调用publishProgress()方法来完成。
         */
        @Override
        protected Boolean doInBackground(Void... voids) {
            return null;
        }

        /**
         * publishProgress(Progress...)方法后，这个方法就很快会被调用
         * 可以根据传过来的参数 进行ui 的更新操作
         * @param values
         */
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        /**
         * 当后台通过 return 返回结果的时候回调用该方法，
         * 根据返回结果 aBoolean 来进行ui的判断更新
         * @param aBoolean
         */
        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
        }
    }
}
