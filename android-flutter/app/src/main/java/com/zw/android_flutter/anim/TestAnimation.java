package com.zw.android_flutter.anim;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class TestAnimation extends Animation {
    private long native_instance = 0;

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);
        Camera camera = new Camera();
        camera.rotateX(10);
        Matrix matrix = t.getMatrix();

    }
}