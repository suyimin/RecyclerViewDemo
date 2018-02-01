package com.sunny.demo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.sunny.demo.R;

/**
 * 主界面全部应用适配器.管理应用适配器
 */
public class AllAdapter extends RecyclerView.Adapter<AllAdapter.AllViewHolder> {

    @Override
    public AllViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_all, parent, false);
        AllViewHolder holder = new AllViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(AllViewHolder holder, int position) {
        final int pos = holder.getLayoutPosition();
        //验证itemView的重用
        holder.tvName.setText("应用" + pos + ",mTag:" + holder.itemView.getTag());
        holder.itemView.setTag(pos);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onItemClick(pos);
            }
        });
        holder.btnInstall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mInstallListener.onBtnInstallClick(pos);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    private OnItemClickListener mListener;

    public void setOnItemClickListener(OnItemClickListener li) {
        mListener = li;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    private OnBtnInstallClickListener mInstallListener;

    public void OnBtnInstallClickListener(OnBtnInstallClickListener li) {
        mInstallListener = li;
    }

    public interface OnBtnInstallClickListener {
        void onBtnInstallClick(int position);
    }

    class AllViewHolder extends RecyclerView.ViewHolder {

        Button btnInstall;
        TextView tvName;

        public AllViewHolder(View view) {
            super(view);
            btnInstall = (Button) view.findViewById(R.id.btn_install);
            tvName = (TextView) view.findViewById(R.id.tv_name);
        }
    }
}
