package com.sscience.stopapp.adapter;

import android.app.Activity;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.RecyclerView;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.science.baserecyclerviewadapter.base.ViewHolder;
import com.sscience.stopapp.R;
import com.sscience.stopapp.activity.AppListActivity;
import com.sscience.stopapp.bean.AppInfo;

import java.util.List;
import java.util.Set;

/**
 * @author SScience
 * @description
 * @email chentushen.science@gmail.com
 * @data 2017/1/15
 */

public class AppListAdapter extends AppAdapter {
    private AppListActivity mAppListActivity;

    public AppListAdapter(Activity activity, RecyclerView recyclerView) {
        super(activity, recyclerView);
        mAppListActivity = (AppListActivity) activity;
    }

    @Override
    public int getItemLayoutId() {
        return R.layout.item_app;
    }

    @Override
    public void convertCommon(ViewHolder viewHolder, List<AppInfo> appInfo, int position) {
        super.convertCommon(viewHolder, appInfo, position);
        final AppInfo info = appInfo.get(position);
        viewHolder.setText(R.id.tv_app_package_name, info.getAppPackageName());
        ((TextView) viewHolder.getView(R.id.tv_app_name)).setTextColor(info.isEnable()
                ? mAppListActivity.getResources().getColor(R.color.textPrimary)
                : mAppListActivity.getResources().getColor(R.color.translucentBg));
        ((ImageView) viewHolder.getView(R.id.iv_app_icon)).getDrawable().setColorFilter(info.isEnable()
                ? mColorFilterNormal : mColorFilterGrey);
        ((TextView) viewHolder.getView(R.id.tv_app_package_name)).setTextColor(info.isEnable()
                ? mAppListActivity.getResources().getColor(R.color.textSecondary)
                : mAppListActivity.getResources().getColor(R.color.translucentBg));
        AppCompatCheckBox cb = viewHolder.getView(R.id.cb_select_apps);
        cb.setOnCheckedChangeListener(null); // CheckBox在执行setChecked时会触发setOnCheckedChangeListener
        cb.setChecked(mAppListActivity.getSelection().contains(info.getAppPackageName()));
        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Set<String> selections = mAppListActivity.getSelection();
                if (isChecked) {
                    selections.add(info.getAppPackageName());
                } else {
                    selections.remove(info.getAppPackageName());
                }
                mAppListActivity.checkSelection();
            }
        });
    }
}

