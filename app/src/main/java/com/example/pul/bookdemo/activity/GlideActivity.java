package com.example.pul.bookdemo.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.pul.bookdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Glide 学习界面
 */
public class GlideActivity extends AppCompatActivity {
    @BindView(R.id.bt)
    Button bt;
    @BindView(R.id.image_view)
    ImageView imageView;
    @BindView(R.id.webView)
    WebView webView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);
        ButterKnife.bind(this);
//        webView.setVerticalScrollbarOverlay(true);
//        //设置WebView支持JavaScript
//        webView.getSettings().setJavaScriptEnabled(true);
//        webView.loadUrl("http://10.11.30.10:90/DSPulse/web/login.html");
//        //添加客户端支持
//        webView.setWebChromeClient(new WebChromeClient());
    }

    @OnClick({R.id.bt})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt:
//                webView.loadUrl("javascript:showInfoFromJava('" + "ok" + "')");
                String gif = "http://p1.pstatp.com/large/166200019850062839d3";
                String url = "http://7xi8d6.com1.z0.glb.clouddn.com/20171201091356_OPqmuO_kanna399_1_12_2017_9_13_42_126.jpeg";
                Glide.with(this).load(gif).placeholder(R.mipmap.load)
                        .error(R.mipmap.err).into(imageView);
                break;
                default:
                    break;
        }
    }
}
