package com.sunny.demo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.WindowManager;

import com.sunny.demo.ApplicationHelper;


public abstract class BaseActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ApplicationHelper.add(this);
        setRootView();
        setTheWindowDisplay();
        initWidget();
    }

    public abstract void setRootView();

    public abstract void initWidget();

    public void setTheWindowDisplay() {
        final DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        final WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
        layoutParams.width = 2424;
        layoutParams.height = 1200;
        layoutParams.gravity = Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM;
        layoutParams.verticalMargin = 0.057f;
        getWindow().setAttributes(layoutParams);
        setFinishOnTouchOutside(false);
    }

}
