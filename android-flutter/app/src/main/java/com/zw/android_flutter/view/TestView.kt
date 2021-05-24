package com.zw.android_flutter.view

import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.Scroller

class TestView(
    context: Context?, attrs: AttributeSet?,
    defStyleAttr: Int, defStyleRes: Int
) : View(context, attrs, defStyleAttr, defStyleRes) {
    companion object {
        var TAG = TestView::class.java.simpleName
    }

    private var scroller: Scroller? = null

    constructor(
        context: Context?, attrs: AttributeSet?, defStyleAttr: Int
    ) : this(context, attrs, defStyleAttr, 0) {
        Log.i(TAG, "3 ......")
        scroller = Scroller(this.context)
    }

    constructor(context: Context?, attrs: AttributeSet?)
            : this(context, attrs, 0) {
        Log.i(TAG, "2 ......")
    }

    constructor(context: Context?) : this(context, null) {
        Log.i(TAG, "1 ......")
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        var w = width
        var h = height

        var r = if (w < h) w / 2 else h / 2

        var paint = Paint()
        var flags = paint.flags
        paint.flags = (Paint.ANTI_ALIAS_FLAG or flags)

        paint.setColor(Color.RED)
        canvas?.drawCircle((w / 2).toFloat(), (h / 2).toFloat(), r.toFloat(), paint)
    }

    fun anim() {
        var anim = ObjectAnimator.ofFloat(this, "translationX", 0f, 100f, 0f)
        anim.setDuration(1000)
        anim.start()
    }

    fun anim1() {
        var destX = 100
        var destY = 0

        var scrollX = scrollX
        var deltax = destX - scrollX
        scroller?.startScroll(scrollX, 0, deltax, 0, 1000)

        invalidate()
    }

    override fun computeScroll() {
        super.computeScroll()
        if (scroller?.computeScrollOffset() == true) {
            scroller?.currX?.let { scroller?.currY?.let { it1 -> scrollTo(it, it1) } }
            postInvalidate()
        }
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
    }
}