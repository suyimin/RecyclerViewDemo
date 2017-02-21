package com.sunny.demo.activity;


import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.sunny.demo.ApplicationHelper;
import com.sunny.demo.R;
import com.sunny.demo.adapter.AllAdapter;
import com.sunny.demo.adapter.ShortcutAdapter;
import com.sunny.demo.adapter.UpdateAdapter;
import com.sunny.demo.entity.AppInfo;
import com.sunny.demo.widget.ItemDivider;

import java.util.ArrayList;

public class MainActivity extends BaseActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    private ImageView imgBack;
    private ImageView imgClose;
    /**
     * 最新应用列表
     */
    private RecyclerView rvShortcut;
    /**
     * 全部应用列表、升级应用列表、升级应用列表
     */
    private RecyclerView rvMain;
    private RadioGroup rg;
    private RadioButton rbTop, rbMiddle, rbBottom;

    public ArrayList<AppInfo> appInfos = new ArrayList<>();

    @Override
    public void setRootView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    public void initWidget() {
        getAppInfos();
        imgBack = (ImageView) findViewById(R.id.img_back);
        imgBack.setVisibility(View.GONE);
        imgClose = (ImageView) findViewById(R.id.img_close);
        imgClose.setOnClickListener(this);
        rvShortcut = (RecyclerView) findViewById(R.id.rv_shortcut);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        lm.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvShortcut.setLayoutManager(lm);
        ItemDivider divider = new ItemDivider();
        divider.setWidth(17);
        rvShortcut.addItemDecoration(divider);
        ShortcutAdapter mAdapter = new ShortcutAdapter();
        rvShortcut.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new ShortcutAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, DetailsActivity.class);
                startActivity(intent);
            }
        });
        rg = (RadioGroup) findViewById(R.id.rg);
        rbTop = (RadioButton) findViewById(R.id.rb_top);
        rbMiddle = (RadioButton) findViewById(R.id.rb_middle);
        rbBottom = (RadioButton) findViewById(R.id.rb_bottom);
        rbTop.setChecked(true);
        rg.setOnCheckedChangeListener(this);
        rvMain = (RecyclerView) findViewById(R.id.rv_main);
        GridLayoutManager gm = new GridLayoutManager(this, 2);
        gm.setOrientation(GridLayoutManager.VERTICAL);
        rvMain.setLayoutManager(gm);
        AllAdapter allAdapter = new AllAdapter();
        UpdateAdapter updateAdapter = new UpdateAdapter(appInfos);
        rvMain.setAdapter(updateAdapter);
        allAdapter.setOnItemClickListener(new AllAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, DetailsActivity.class);
                startActivity(intent);
            }
        });
        allAdapter.OnBtnInstallClickListener(new AllAdapter.OnBtnInstallClickListener() {
            @Override
            public void onBtnInstallClick(int position) {
                Toast.makeText(MainActivity.this, "Install" + position, Toast.LENGTH_SHORT).show();
            }
        });
        updateAdapter.setOnItemClickListener(new UpdateAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, DetailsActivity.class);
                startActivity(intent);
            }
        });
        updateAdapter.OnIvSelClickListener(new UpdateAdapter.OnIvSelClickListener() {
            @Override
            public void onSelClick(int position) {
                Toast.makeText(MainActivity.this, "Sel" + position, Toast.LENGTH_SHORT).show();
            }
        });
        updateAdapter.OnBtnInstallClickListener(new UpdateAdapter.OnBtnInstallClickListener() {
            @Override
            public void onBtnInstallClick(int position) {
                Toast.makeText(MainActivity.this, "Install" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getAppInfos() {
        for (int i = 0; i < 20; i++) {
            AppInfo info = new AppInfo();
            info.setName("应用" + i);
            info.setChecked(false);
            appInfos.add(info);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_close:
                ApplicationHelper.exit();
                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.rb_top:
                Log.e("==","全部应用");
                break;
            case R.id.rb_middle:
                Log.e("==","升级应用");
                break;
            case R.id.rb_bottom:
                Log.e("==","管理应用");
                break;
        }
    }
}
