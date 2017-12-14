package com.example.pul.bookdemo.view;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * @packageName: com.example.pul.bookdemo.view
 * @fileName: CustomDrawable
 * @date: 2017/12/14  15:54
 * @author: ymc
 * @QQ:745612618
 * android  开发艺术 测试 drawable  263#
 */

public class CustomDrawable extends Drawable {
    private Paint paint;

    public CustomDrawable(int color) {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(color);
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        final Rect r = getBounds();
        float cx = r.exactCenterX();
        float cy = r.exactCenterY();
        canvas.drawCircle(cx,cy,Math.min(cx,cy),paint);
    }

    @Override
    public void setAlpha(int alpha) {
        paint.setAlpha(alpha);
        invalidateSelf();
    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        paint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }
}
