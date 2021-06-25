package com.zw.android_flutter;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DemoBaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(getClass().getSimpleName() + "-base", "onCreate ......");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(getClass().getSimpleName() + "-base", "onStart ......");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(getClass().getSimpleName() + "-base", "onResume ......");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(getClass().getSimpleName() + "-base", "onPause ......");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(getClass().getSimpleName() + "-base", "onSaveInstanceState ......");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(getClass().getSimpleName() + "-base", "onRestoreInstanceState ......");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(getClass().getSimpleName() + "-base", "onStop ......");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(getClass().getSimpleName() + "-base", "onDestroy ......");
    }
}