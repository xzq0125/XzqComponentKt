package com.xzq.module_base.dialog

import android.content.Context
import android.graphics.drawable.Animatable
import android.support.v7.widget.AppCompatImageView
import android.util.AttributeSet
import android.view.View
import com.scwang.smartrefresh.layout.internal.ProgressDrawable

/**
 * 进度ImageView
 * Created by xzq on 2018/10/9.
 */

class LoadingImageView : AppCompatImageView {

    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context)
    }

    private fun init(context: Context) {
        val progressDrawable = ProgressDrawable()
        //progressDrawable.setColor(ContextCompat.getColor(context, R.color.color_999999));
        setImageDrawable(progressDrawable)
    }

    override fun onDetachedFromWindow() {
        visibility = View.GONE
        super.onDetachedFromWindow()
    }

    override fun setVisibility(visibility: Int) {
        if (visibility == View.VISIBLE) {
            val drawable = drawable
            if (drawable is Animatable) {
                (drawable as Animatable).start()
            }
        } else {
            val drawable = drawable
            if (drawable is Animatable) {
                (drawable as Animatable).stop()
            }
        }
        super.setVisibility(visibility)
    }
}
