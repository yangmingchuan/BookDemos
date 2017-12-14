package com.example.pul.bookdemo.animator;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.pul.bookdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 属性动画 学习
 * 博客地址 ： http://blog.csdn.net/guolin_blog/article/details/43536355
 */

public class AnimatorActivity extends AppCompatActivity {

    @BindView(R.id.tv_animator)
    TextView tvAnimator;
    @BindView(R.id.bt_start_animator)
    Button btStartAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator);
        ButterKnife.bind(this);
        /**
         * ValueAnimator 没有跟任何的控件相关联，
         * 那也正好说明 ValueAnimator 只是对值做动画运算，
         * 而不是针对控件的
         *
         * ValueAnimator当中最常用的应该就是ofFloat()和ofInt()这两个方法了，
         * 另外还有一个ofObject()方法，我会在下篇文章进行讲解。
         * 那么除此之外，我们还可以调用setStartDelay()方法来设置动画延迟播放的时间，
         * 调用setRepeatCount()和setRepeatMode()方法来设置动画循环播放的次数以及循环播放的模式，
         * 循环模式包括RESTART和REVERSE两种，分别表示重新播放和倒序播放的意思
         */
        ValueAnimator anim = ValueAnimator.ofFloat(0f, 1f);
        anim.setDuration(300);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float currentValue = (float) animation.getAnimatedValue();
                Log.d("TAG", "cuurent value is " + currentValue);
            }
        });
        anim.start();
    }


    @OnClick({R.id.bt_start_animator})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.bt_start_animator:
                setAnimator(tvAnimator);
                break;
        }
    }

    /**
     * 5秒 改变文字透明度  显示  到  消失  到显示
     * @param tvAnimator
     */
    private void aplaha(TextView tvAnimator) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(tvAnimator, "alpha", 1f, 0f, 1f);
        animator.setDuration(5000);
        animator.start();
    }

    /**
     * 5秒 旋转文字 一圈
     * @param tvAnimator
     */
    private void rotation(TextView tvAnimator) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(tvAnimator, "rotation", 0f, 360f);
        animator.setDuration(5000);
        animator.start();
    }

    /**
     * 5秒 拉伸文字 Y轴方向
     * @param tvAnimator
     */
    private void scaleY(TextView tvAnimator) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(tvAnimator, "scaleY", 1f, 3f, 1f);
        animator.setDuration(5000);
        animator.start();
    }

    /**
     * 组合动画
     * after(Animator anim)   将现有动画插入到传入的动画之后执行
     * after(long delay)   将现有动画延迟指定毫秒后执行
     * before(Animator anim)   将现有动画插入到传入的动画之前执行
     * with(Animator anim)   将现有动画和传入的动画同时执行
     * @param tvAnimator
     */
    private void setAnimator(TextView tvAnimator) {
        ObjectAnimator moveIn = ObjectAnimator.ofFloat(tvAnimator, "translationX", -500f, 200f);
        ObjectAnimator rotate = ObjectAnimator.ofFloat(tvAnimator, "rotation", 0f, 360f);
        ObjectAnimator fadeInOut = ObjectAnimator.ofFloat(tvAnimator, "alpha", 1f, 0f, 1f);
        AnimatorSet animSet = new AnimatorSet();
        animSet.play(rotate).with(fadeInOut).after(moveIn);
        animSet.setDuration(5000);
        animSet.start();
    }


}
