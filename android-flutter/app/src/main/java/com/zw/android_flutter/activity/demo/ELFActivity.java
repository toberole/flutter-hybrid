package com.zw.android_flutter.activity.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.zw.android_flutter.R;

/**
 * brew update && brew install binutils
 * 然后用greadelf和gobjdump
 * <p>
 * 查看so文件的头部信息
 * readelf -h xxx.so
 * <p>
 * 查看so文件的段(Section)头的信息
 * readelf -S xxx.so
 * <p>
 * 查看so文件的程序段头信息(Program)
 * readelf -l xxx.so
 * <p>
 * 查看so文件的全部内容
 * readelf -a xxx.so
 */
public class ELFActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e_l_f);
        findViewById(R.id.btn_test1).setOnClickListener(this);
        findViewById(R.id.btn_test2).setOnClickListener(this);

        Log.i("test1-class", com.zw.android_flutter.test2.Test1.class + "");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_test1:
                test1();
                break;

            case R.id.btn_test2:
                test2();
                break;

            default:
                break;
        }
    }

    private void test1() {
        Intent intent = new Intent(this, ProfilerActivity.class);
        startActivity(intent);
    }

    private void test2() {

    }
}