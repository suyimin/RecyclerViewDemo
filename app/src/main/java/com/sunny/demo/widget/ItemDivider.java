package com.sunny.demo.widget;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;


public class ItemDivider extends RecyclerView.ItemDecoration {

    private Integer mWidth;

    public void setWidth(Integer width) {
        mWidth = width;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                               RecyclerView.State state) {
        int childPosition = parent.getChildAdapterPosition(view);
        int itemCount = parent.getAdapter().getItemCount();
        if (childPosition != itemCount - 1) {
            outRect.set(0, 0, mWidth, 0);
        }
    }
}
