package com.sunny.demo.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sunny.demo.ApplicationHelper;
import com.sunny.demo.R;

public class DetailsActivity extends BaseActivity implements View.OnClickListener {

    private ImageView imgBack;
    private ImageView imgClose;
    private TextView tvTitle;

    @Override
    public void setRootView() {
        setContentView(R.layout.activity_details);
    }

    @Override
    public void initWidget() {
        imgBack = (ImageView) findViewById(R.id.img_back);
        imgBack.setOnClickListener(this);
        imgClose = (ImageView) findViewById(R.id.img_close);
        imgClose.setOnClickListener(this);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tvTitle.setText("进销存通用版");
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
