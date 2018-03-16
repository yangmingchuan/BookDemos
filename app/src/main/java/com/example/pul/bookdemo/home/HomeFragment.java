package com.example.pul.bookdemo.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.pul.bookdemo.R;
import com.example.pul.bookdemo.activity.AgentwebActivity;
import com.example.pul.bookdemo.activity.FallActivity;
import com.example.pul.bookdemo.activity.GlideActivity;
import com.example.pul.bookdemo.activity.MainActivity;
import com.example.pul.bookdemo.activity.ZhiHuAdvertisingActivity;
import com.example.pul.bookdemo.animator.AnimatorActivity;
import com.example.pul.bookdemo.banner.BannerActivity;
import com.example.pul.bookdemo.dialogframent.DialogFragmentActivity;
import com.example.pul.bookdemo.mvp.view.MvpLoginActivity;

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
    @BindView(R.id.bt_animator)
    Button btAnimator;
    @BindView(R.id.bt_agentweb)
    Button btAgentweb;
    @BindView(R.id.bt_mvp)
    Button btMvp;
    @BindView(R.id.ll_2)
    LinearLayout ll2;
    @BindView(R.id.bt_dialog_fragment)
    Button btDialogFragment;
    @BindView(R.id.bt_imm_mode)
    Button btImmMode;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @OnClick({R.id.bt_glide, R.id.bt_pie_chart, R.id.bt_advertising, R.id.bt_banner, R.id.bt_animator
            , R.id.bt_agentweb, R.id.bt_mvp, R.id.bt_dialog_fragment,R.id.bt_imm_mode})
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
            case R.id.bt_animator:
                Intent intentAnimator = new Intent(getActivity(), AnimatorActivity.class);
                startActivity(intentAnimator);
                break;
            case R.id.bt_agentweb:
                Intent intentAgentweb = new Intent(getActivity(), AgentwebActivity.class);
                startActivity(intentAgentweb);
                break;
            case R.id.bt_mvp:
                Intent intentMvp = new Intent(getActivity(), MvpLoginActivity.class);
                startActivity(intentMvp);
                break;
            case R.id.bt_dialog_fragment:
                Intent intentDialog = new Intent(getActivity(), DialogFragmentActivity.class);
                startActivity(intentDialog);
                break;
            case R.id.bt_imm_mode:
                Intent intentFall = new Intent(getActivity(), FallActivity.class);
                startActivity(intentFall);
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
