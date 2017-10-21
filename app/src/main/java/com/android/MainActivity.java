package com.android;

import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

public class MainActivity extends FragmentActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, getFilesDir().getPath());
        Log.d(TAG, getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS).getPath());
        Environment.getExternalStoragePublicDirectory();
        Environment.getExternalStorageDirectory()

    }
}
