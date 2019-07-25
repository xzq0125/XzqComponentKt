package com.xzq.module_base.adapter

import android.content.Context
import android.util.TypedValue

import com.scwang.smartrefresh.layout.internal.ProgressDrawable


/**
 * FooterProgressDrawable
 * Created by xzq on 2018/9/29.
 */
class FooterProgressDrawable @JvmOverloads constructor(context: Context, size: Int = 20) : ProgressDrawable() {

    private val sizeOfPx: Int

    init {
        this.sizeOfPx = dp2px(context, size.toFloat())
    }

    override fun getIntrinsicWidth(): Int {
        return sizeOfPx
    }

    override fun getIntrinsicHeight(): Int {
        return sizeOfPx
    }

    private fun dp2px(context: Context, dpVal: Float): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dpVal, context.resources.displayMetrics
        ).toInt()
    }
}
