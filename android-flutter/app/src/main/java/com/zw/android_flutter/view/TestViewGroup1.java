package com.zw.android_flutter.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;

public class TestViewGroup1 extends ViewGroup {
    public static final String TAG = TestViewGroup1.class.getSimpleName();

    public static final int DEFAULT_WIDTH = 200;
    public static final int DEFAULT_HEIGHT = 200;

    public TestViewGroup1(Context context) {
        this(context, null);
    }

    public TestViewGroup1(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TestViewGroup1(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public TestViewGroup1(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs, defStyleAttr, defStyleRes);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.i(TAG,"onMeasure ......");

        int childCount = getChildCount();

        if (childCount == 0) setMeasuredDimension(0, 0);

        measureChildren(widthMeasureSpec, heightMeasureSpec);

        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);

        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);

        int w = 0;
        int h = 0;

        if (widthSpecMode == MeasureSpec.AT_MOST && heightSpecMode == MeasureSpec.AT_MOST) {
            for (int i = 0; i < childCount; i++) {
                w += getChildAt(i).getMeasuredWidth();
                h += getChildAt(i).getMeasuredHeight();
            }
        } else if (widthSpecMode == MeasureSpec.AT_MOST) {
            for (int i = 0; i < childCount; i++) {
                w += getChildAt(i).getMeasuredWidth();
            }
            h = heightSpecSize;
        } else if (heightSpecMode == MeasureSpec.AT_MOST) {
            w = widthSpecSize;
            for (int i = 0; i < childCount; i++) {
                int h1 = getChildAt(i).getMeasuredHeight();
                if (h1 > h) h = h1;
            }
        }

        setMeasuredDimension(w, h);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int preWidth = 0;
        for (int i = 0; i < getChildCount(); i++) {
            int left = 0;
            int top = 0;
            int right = 0;
            int bottom = 0;

            if (i == 0) {
                left = 0;
                top = 0;
                right = getChildAt(0).getMeasuredWidth();
                bottom = getChildAt(0).getMeasuredHeight();
                getChildAt(i).layout(left, top, right, bottom);

                preWidth += getChildAt(i).getWidth();
            } else {
                left = preWidth;
                top = 0;
                right = preWidth + getChildAt(i).getMeasuredWidth();
                bottom = getChildAt(i).getMeasuredHeight();
                getChildAt(i).layout(left, top, right, bottom);

                preWidth += getChildAt(i).getWidth();
            }
        }
    }

    @Override
    protected LayoutParams generateLayoutParams(LayoutParams p) {
        return new TestViewGroup1LayoutParams(p);
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new TestViewGroup1LayoutParams(getContext(), attrs);
    }

    private class TestViewGroup1LayoutParams extends MarginLayoutParams {
        public TestViewGroup1LayoutParams(LayoutParams source) {
            super(source);
        }

        public TestViewGroup1LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
        }

        public TestViewGroup1LayoutParams(int width, int height) {
            super(width, height);
        }

        public TestViewGroup1LayoutParams(MarginLayoutParams source) {
            super(source);
        }
    }
}