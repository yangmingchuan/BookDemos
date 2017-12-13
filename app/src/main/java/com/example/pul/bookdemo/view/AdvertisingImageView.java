package com.example.pul.bookdemo.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 *  广告 自定义 imageview
 * Created by pul on 2017/12/5.
 */

public class AdvertisingImageView extends android.support.v7.widget.AppCompatImageView {
    private final static String TAG = "AdvertisingImageView";
    private RectF mBitmapRectF;
    private Bitmap mBitmap;
    private int mMinDy;
    private int mDy;

    public AdvertisingImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        mMinDy = h;
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        mBitmap = drawableToBitamp(drawable);
        mBitmapRectF = new RectF(0, 0,
                w,mBitmap.getHeight() * w / mBitmap.getWidth());
    }

    private Bitmap drawableToBitamp(Drawable drawable) {
        if(drawable instanceof BitmapDrawable){
            BitmapDrawable bd = (BitmapDrawable) drawable;
            return bd.getBitmap();
        }
        int w = drawable.getIntrinsicWidth();
        int h = drawable.getIntrinsicHeight();
        Bitmap bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, w, h);
        drawable.draw(canvas);
        return bitmap;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (mBitmap == null) {
            return;
        }
        canvas.save();
        canvas.translate(0, -mDy);
        canvas.drawBitmap(mBitmap, null, mBitmapRectF, null);
        canvas.restore();
    }

    public void setmDy(int dy) {
        if (getDrawable() == null) {
            return;
        }
        mDy = dy - mMinDy;
//        Log.e(TAG," dy:"+dy +"  mBitmapRectF.height():"+(mBitmapRectF.height())+"   mMinDy:"+mMinDy);
        if (mDy <= 0) {
            mDy = 0;
        }
        if (mDy > mBitmapRectF.height() - mMinDy) {
            mDy = (int) (mBitmapRectF.height() - mMinDy);
        }
        invalidate();
    }
}
