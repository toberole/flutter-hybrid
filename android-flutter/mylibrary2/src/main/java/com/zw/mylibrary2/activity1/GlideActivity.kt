package com.zw.mylibrary2.activity1

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.zw.mylibrary2.CircleTransformation
import com.zw.mylibrary2.R
import kotlinx.android.synthetic.main.activity_glide.*

class GlideActivity : AppCompatActivity() {
    private val url =
        "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fedu-image.nosdn.127.net%2FF7F282D334BE1AD595587AEFC256F024.jpg%3FimageView%26thumbnail%3D510y288%26quality%3D100&refer=http%3A%2F%2Fedu-image.nosdn.127.net&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1628930395&t=d9e2b8522c74dbfff3568b3d20e603ad"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_glide)
        test1()
    }

    private fun test1() {
        Glide.with(this)
            .load(url)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .diskCacheStrategy(DiskCacheStrategy.DATA)
            .transform(CircleTransformation())
            .into(iv_test)

        // Glide.with(this).load(url)
    }
}
