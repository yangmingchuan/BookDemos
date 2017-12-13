package com.example.pul.bookdemo.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.pul.bookdemo.R;
import com.example.pul.bookdemo.activity.GlideActivity;
import com.example.pul.bookdemo.activity.MainActivity;
import com.example.pul.bookdemo.activity.ZhiHuAdvertisingActivity;
import com.example.pul.bookdemo.banner.BannerActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 首页碎片
 * Created by pul on 2017/12/5.
 */

public class HomeFragment extends Fragment {

    @BindView(R.id.bt_glide)
    Button btGlide;
    @BindView(R.id.bt_pie_chart)
    Button btPieChart;
    Unbinder unbinder;
    @BindView(R.id.bt_advertising)
    Button btAdvertising;
    @BindView(R.id.bt_banner)
    Button btBanner;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @OnClick({R.id.bt_glide, R.id.bt_pie_chart, R.id.bt_advertising ,R.id.bt_banner})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_glide:
                Intent intentGlide = new Intent(getActivity(), GlideActivity.class);
                startActivity(intentGlide);
                break;
            case R.id.bt_pie_chart:
                Intent intentPieChart = new Intent(getActivity(), MainActivity.class);
                startActivity(intentPieChart);
                break;
            case R.id.bt_advertising:
                Intent intentAd = new Intent(getActivity(), ZhiHuAdvertisingActivity.class);
                startActivity(intentAd);
                break;
                case R.id.bt_banner:
                    Intent intentBanner = new Intent(getActivity(), BannerActivity.class);
                    startActivity(intentBanner);
                    break;
            default:
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
