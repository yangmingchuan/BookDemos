package com.example.pul.bookdemo.banner.layoutmanager;

import android.support.v7.widget.RecyclerView;


/**
 * A {@link RecyclerView.OnScrollListener} which helps {@link BannerLayoutManager}
 * to center the current position
 */
public class CenterScrollListener extends RecyclerView.OnScrollListener {
    private boolean mAutoSet = false;

    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
        final RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (!(layoutManager instanceof BannerLayoutManager)) {
            mAutoSet = true;
            return;
        }

        final BannerLayoutManager.OnPageChangeListener onPageChangeListener = ((BannerLayoutManager) layoutManager).onPageChangeListener;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrollStateChanged(newState);
        }

        if (newState == RecyclerView.SCROLL_STATE_IDLE) {
            if (mAutoSet) {
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageSelected(((BannerLayoutManager) layoutManager).getCurrentPosition());
                }
                mAutoSet = false;
            } else {
                final int delta;
                delta = ((BannerLayoutManager) layoutManager).getOffsetToCenter();
                if (delta != 0) {
                    if (((BannerLayoutManager) layoutManager).getOrientation() == BannerLayoutManager.VERTICAL)
                        recyclerView.smoothScrollBy(0, delta);
                    else
                        recyclerView.smoothScrollBy(delta, 0);
                    mAutoSet = true;
                } else {
                    if (onPageChangeListener != null) {
                        onPageChangeListener.onPageSelected(((BannerLayoutManager) layoutManager).getCurrentPosition());
                    }
                    mAutoSet = false;
                }
            }
        } else if (newState == RecyclerView.SCROLL_STATE_DRAGGING || newState == RecyclerView.SCROLL_STATE_SETTLING) {
            mAutoSet = false;
        }
    }
}
