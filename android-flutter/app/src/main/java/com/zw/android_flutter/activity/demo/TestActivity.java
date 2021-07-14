package com.zw.android_flutter.activity.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class TestActivity extends AppCompatActivity {
    @Override
    protected void onStart() {
        super.onStart();
        test();
    }

    private void test() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Fragment fragment = null;
        transaction.add(fragment, "");
        transaction.commit();
        transaction.commitAllowingStateLoss();
    }
}