package com.example.pul.bookdemo.banner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.pul.bookdemo.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * banner 测试界面  原作者地址http://www.jianshu.com/p/1e2baec44e0d
 */

public class BannerActivity extends AppCompatActivity {

    @BindView(R.id.banner)
    RecyclerViewBannerNew banner;
    @BindView(R.id.banner1)
    RecyclerViewBannerNew banner1;
    @BindView(R.id.normal_banner)
    NormalRecyclerViewBanner normalBanner;
    @BindView(R.id.normal_banner1)
    NormalRecyclerViewBanner normalBanner1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);
        ButterKnife.bind(this);

        List<String> list = new ArrayList<>();
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1510833032476&di=3998d3aaa2e006c1120c8534311e9a81&imgtype=0&src=http%3A%2F%2Fe.hiphotos.baidu.com%2Fzhidao%2Fpic%2Fitem%2F810a19d8bc3eb135275b10f1ae1ea8d3fc1f44df.jpg");
        //list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1510833032475&di=8ceb2f76c9bed8a2ebaf5ba85efd4440&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2Fb%2F591953d9ce3cb.jpg");
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1510833032475&di=4cf3e1192a9e58529440d213de48a95a&imgtype=0&src=http%3A%2F%2Fimg.7xz.com%2Fimg%2Fpicimg%2F201607%2F20160715161145_327a1d30f651dab8932.jpg");
        list.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1510833032474&di=3723ba473a9c92dc420e2538a9aa584e&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2Fc%2F57450b9a295f5.jpg");
        banner.initBannerImageView(list, new RecyclerViewBannerBase.OnBannerItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(BannerActivity.this, "clicked:" + position, Toast.LENGTH_SHORT).show();
            }
        });
        banner1.initBannerImageView(list);
        normalBanner.initBannerImageView(list);
        normalBanner1.initBannerImageView(list);

    }
}
