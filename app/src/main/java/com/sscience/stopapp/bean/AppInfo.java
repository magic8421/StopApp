package com.sscience.stopapp.bean;

import android.graphics.Bitmap;

import java.io.Serializable;
import java.util.Date;

/**
 * @author SScience
 * @description 实现Clonable接口，覆盖并实现clone方法，除了调用父类中的clone方法得到新的对象，
 * 还要将该类中的引用变量也clone出来。
 * @email chentushen.science@gmail.com
 * @data 2017/1/15
 */

public class AppInfo implements Serializable, Cloneable {

    private static final long serialVersionUID = -2984090829607150673L;
    public final static String APP_PACKAGE_NAME = "appPackageName";
    public final static String APP_NAME = "appName";
    public final static String APP_ICON = "appIcon";
    public final static String IS_ENABLE = "isEnable";
    public final static String IS_SYSTEM_APP = "isSystemApp";
    public final static String LAST_LAUNCH = "lastLaunch";

    private String appName;
    private String appPackageName;
    private Bitmap appIcon;
    private int isEnable;
    private int isSystemApp;
    private long lastLaunch;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppPackageName() {
        return appPackageName;
    }

    public void setAppPackageName(String appPackageName) {
        this.appPackageName = appPackageName;
    }

    public Bitmap getAppIcon() {
        return appIcon;
    }

    public void setAppIcon(Bitmap appIcon) {
        this.appIcon = appIcon;
    }

    public int isEnable() {
        return isEnable;
    }

    public void setEnable(int enable) {
        isEnable = enable;
    }

    public int isSystemApp() {
        return isSystemApp;
    }

    public void setSystemApp(int systemApp) {
        isSystemApp = systemApp;
    }

    public long getLastLaunch() {
        return lastLaunch;
    }

    public void setLastLaunch(long lastLaunch) {
        this.lastLaunch = lastLaunch;
    }

    @Override
    public AppInfo clone() throws CloneNotSupportedException {
        AppInfo appInfo = null;
        try {
            appInfo = (AppInfo) super.clone();

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return appInfo;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AppInfo))
            return false;
        if (obj == this)
            return true;
        return this.appPackageName.equals(((AppInfo) obj).appPackageName);
    }

    @Override
    public int hashCode() {
        return appPackageName.length();
    }
}
