package com.example.pul.bookdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.example.pul.bookdemo.R;
import com.just.library.AgentWeb;
import com.just.library.ChromeClientCallbackManager;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * webview 简洁库    https://github.com/Justson/AgentWeb
 */

public class AgentwebActivity extends AppCompatActivity {
    @BindView(R.id.fragment_web)
    FrameLayout fragmentWeb;
    @BindView(R.id.ll_content)
    LinearLayout llContent;
    private AgentWeb mAgentWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agentweb);
        ButterKnife.bind(this);

        mAgentWeb = AgentWeb.with(this)//传入Activity or Fragment
                .setAgentWebParent(fragmentWeb, new LinearLayout.LayoutParams(-1, -1))//传入AgentWeb 的父控件 ，如果父控件为 RelativeLayout ， 那么第二参数需要传入 RelativeLayout.LayoutParams ,第一个参数和第二个参数应该对应。
                .useDefaultIndicator()// 使用默认进度条
                .defaultProgressBarColor() // 使用默认进度条颜色
                .setReceivedTitleCallback(new ChromeClientCallbackManager.ReceivedTitleCallback() {
                    @Override
                    public void onReceivedTitle(WebView view, String title) {
                        Log.e("tag","title:"+title);
                    }
                }) //设置 Web 页面的 title 回调
                .createAgentWeb()
                .ready()
                .go("http://10.11.30.10:90/DSPulse/web/login.html");

    }
}
