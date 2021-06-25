package com.zw.android_flutter;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DemoBaseFragment extends Fragment {
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.i(getClass().getSimpleName(),"onAttach ......");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(getClass().getSimpleName(),"onCreate ......");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(getClass().getSimpleName(),"onSaveInstanceState ......");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(getClass().getSimpleName(),"onCreateView ......");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(getClass().getSimpleName(),"onActivityCreated ......");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(getClass().getSimpleName(),"onStart ......");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(getClass().getSimpleName(),"onResume ......");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(getClass().getSimpleName(),"onPause ......");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(getClass().getSimpleName(),"onStop ......");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(getClass().getSimpleName(),"onDestroy ......");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(getClass().getSimpleName(),"onDetach ......");
    }
}