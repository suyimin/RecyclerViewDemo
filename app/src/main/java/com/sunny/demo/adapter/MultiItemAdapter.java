package com.sunny.demo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sunny.demo.R;

public class MultiItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public enum ITEM_TYPE {
        ITEM_TYPE_ONE,
        ITEM_TYPE_TWO
    }

    private final LayoutInflater mLayoutInflater;
    private final Context mContext;

    public MultiItemAdapter(Context context) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ITEM_TYPE.ITEM_TYPE_ONE.ordinal()) {
            return new ImageViewHolder(mLayoutInflater.inflate(R.layout.item_all, parent, false));
        } else {
            return new TextViewHolder(mLayoutInflater.inflate(R.layout.item_update, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof TextViewHolder) {
        } else if (holder instanceof ImageViewHolder) {
        }
    }

    @Override
    public int getItemViewType(int position) {
        return position % 2 == 0 ? ITEM_TYPE.ITEM_TYPE_ONE.ordinal() : ITEM_TYPE.ITEM_TYPE_TWO.ordinal();
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public static class TextViewHolder extends RecyclerView.ViewHolder {

        TextViewHolder(View view) {
            super(view);
        }
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder {

        ImageViewHolder(View view) {
            super(view);
        }
    }
}
