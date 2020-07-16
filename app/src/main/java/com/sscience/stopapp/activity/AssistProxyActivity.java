package com.sscience.stopapp.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


public class AssistProxyActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        finish();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        //intent.setAction(Intent.ACTION_ASSIST);
        //startService(intent);
    }
}
