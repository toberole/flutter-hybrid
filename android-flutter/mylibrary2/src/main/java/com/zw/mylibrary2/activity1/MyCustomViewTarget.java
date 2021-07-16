package com.zw.mylibrary2.activity1;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.request.target.CustomViewTarget;
import com.bumptech.glide.request.transition.Transition;

public class MyCustomViewTarget extends CustomViewTarget<ImageView, Bitmap> {
    private ImageView imageView;

    public MyCustomViewTarget(@NonNull ImageView view) {
        super(view);
        this.imageView = view;
    }

    @Override
    protected void onResourceCleared(@Nullable Drawable placeholder) {

    }

    @Override
    public void onLoadFailed(@Nullable Drawable errorDrawable) {

    }

    @Override
    public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {

    }
}