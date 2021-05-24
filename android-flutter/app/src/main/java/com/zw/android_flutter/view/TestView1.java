package com.zw.android_flutter.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import com.zw.android_flutter.R;

public class TestView1 extends View {
    public static final String TAG = TestView1.class.getSimpleName();

    public static final int DEFAULT_WIDTH = 200;
    public static final int DEFAULT_HEIGHT = 200;

    private int colorBackground = Color.WHITE;
    private int colorForeground = Color.WHITE;
    private float paddingLeft = 0f;
    private float paddingRight = 0f;

    private int w = DEFAULT_WIDTH;
    private int h = DEFAULT_HEIGHT;
    private Paint paint;

    public TestView1(Context context) {
        this(context, null);
    }

    public TestView1(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TestView1(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public TestView1(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs, defStyleAttr, defStyleRes);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TestView1);
        colorBackground = typedArray.getColor(R.styleable.TestView1_colorBackground, Color.WHITE);
        colorForeground = typedArray.getColor(R.styleable.TestView1_colorForeground, Color.WHITE);
        paddingLeft = typedArray.getDimension(R.styleable.TestView1_paddingLeft, 0);
        paddingRight = typedArray.getDimension(R.styleable.TestView1_paddingRight, 0);
        typedArray.recycle();

        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.RED);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        // 处理 wrap_content
        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);

        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);

        //处理wrap_content的几种特殊情况
        if (widthSpecMode == MeasureSpec.AT_MOST && heightSpecMode == MeasureSpec.AT_MOST) {
            w = DEFAULT_WIDTH;  //单位是px
            h = DEFAULT_HEIGHT;
        } else if (widthSpecMode == MeasureSpec.AT_MOST) {
            //只要宽度布局参数为wrap_content， 宽度给固定值200dp(处理方式不一，按照需求来)
            w = DEFAULT_WIDTH;
            //按照View处理的方法，查看View#getDefaultSize可知
            h = heightSpecSize;
        } else if (heightSpecMode == MeasureSpec.AT_MOST) {
            w = widthSpecSize;
            h = DEFAULT_HEIGHT;
        }

        //给两个字段设置值，完成最终测量
        Log.i(TAG, "w: " + w + ",h: " + h);

        setMeasuredDimension(w, h);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 背景颜色
        setBackgroundColor(colorBackground);
        // 处理padding
        int w1 = (int) (w - paddingLeft - paddingRight);
        int h1 = h;
        float radius = w1 < h1 ? w1 / 2 : h1 / 2;
        canvas.drawCircle(w1 / 2, h1 / 2, radius, paint);
    }
}