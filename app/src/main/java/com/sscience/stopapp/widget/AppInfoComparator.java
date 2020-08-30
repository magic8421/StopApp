package com.sscience.stopapp.widget;

import android.text.TextUtils;

import com.sscience.stopapp.bean.AppInfo;

import java.text.Collator;
import java.util.Comparator;

/**
 * @author SScience
 * @description 根据应用名排序
 * @email chentushen.science@gmail.com
 * @data 2017/2/6
 */

public class AppInfoComparator implements Comparator<AppInfo> {

    private final Collator sCollator = Collator.getInstance();

    @Override
    public int compare(AppInfo appInfo1, AppInfo appInfo2) {
        if (appInfo1.isEnable() == 1 && appInfo2.isEnable() == 0) {
            return -1;
        }
        if (appInfo1.isEnable() == 0 && appInfo2.isEnable() == 1) {
            return 1;
        }
        if (appInfo1.getLastLaunch() > appInfo2.getLastLaunch()) {
            return -1;
        }
        if (appInfo1.getLastLaunch() < appInfo2.getLastLaunch()) {
            return 1;
        }
        String sa = appInfo1.getAppName();
        if (TextUtils.isEmpty(sa)) {
            sa = appInfo1.getAppPackageName();
        }
        String sb = appInfo2.getAppName();
        if (TextUtils.isEmpty(sb)) {
            sb = appInfo2.getAppPackageName();
        }
        return sCollator.compare(sa, sb); // 参考自ApplicationInfo.java中的DisplayNameComparator
    }
}
