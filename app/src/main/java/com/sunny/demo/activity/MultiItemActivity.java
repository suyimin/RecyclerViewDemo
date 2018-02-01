package com.sunny.demo.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sunny.demo.ApplicationHelper;
import com.sunny.demo.R;
import com.sunny.demo.adapter.MultiItemAdapter;

/**
 * 多Item布局RecyclerView
 */
public class MultiItemActivity extends BaseActivity implements View.OnClickListener {

    private ImageView imgBack;
    private ImageView imgClose;
    private TextView tvTitle;
    private RecyclerView mRecyclerView;

    @Override
    public void setRootView() {
        setContentView(R.layout.activity_multiitem);
    }

    @Override
    public void initWidget() {
        imgBack = (ImageView) findViewById(R.id.img_back);
        imgBack.setOnClickListener(this);
        imgClose = (ImageView) findViewById(R.id.img_close);
        imgClose.setOnClickListener(this);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tvTitle.setText("多Item布局RecyclerView");

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        LinearLayoutManager lm = new LinearLayoutManager(this);
        lm.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(lm);

        mRecyclerView.setAdapter(new MultiItemAdapter(this));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.img_close:
                ApplicationHelper.exit();
                break;
        }
    }
}
