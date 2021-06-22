package com.zw.android_flutter.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.jetbrains.annotations.NotNull;

public class TestFragmentXXX extends Fragment {
    public static final String TAG = TestFragmentXXX.class.getSimpleName();

    private Context context;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
    }

    @Override
    public void onInflate(@NonNull @NotNull Context context, @NonNull @NotNull AttributeSet attrs, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onInflate(context, attrs, savedInstanceState);
        Log.i(TAG, "onInflate ......" + context);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
        Log.i(TAG, "onAttach ......" + context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle b = getArguments();
        String s = null;
        if (b != null) {
            s = b.getString("Hello");
            Log.i(TAG, "onCreate ......");
        }
        Log.i(TAG, "onCreate Arguments ......" + s);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView ......");
        TextView v = new TextView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        v.setLayoutParams(layoutParams);
        v.setText("Hello");
        v.setTextColor(Color.RED);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG, "onActivityCreated ......");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, "onStart ......");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "onResume ......");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG, "onPause ......");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG, "onStop ......");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG, "onDestroyView ......");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy ......");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(TAG, "onDetach ......");
    }
}