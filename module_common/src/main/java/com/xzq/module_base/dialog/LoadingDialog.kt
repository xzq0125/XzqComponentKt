package com.xzq.module_base.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.drawable.Animatable
import android.support.v4.content.ContextCompat
import android.view.Gravity
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import com.scwang.smartrefresh.layout.internal.ProgressDrawable
import com.xzq.module_base.R

/**
 * LoadingDialog
 * Created by xzq on 2018/7/23.
 */

class LoadingDialog(context: Context) : Dialog(context, R.style.LoadingDialogStyle) {

    private var mProgressView: ImageView? = null

    init {
        val window = window
        if (window != null) {
            window.requestFeature(Window.FEATURE_NO_TITLE)
            setContentView(R.layout.dialog_loading)
            window.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.bg_loading_dialog))
            window.setGravity(Gravity.CENTER)
            setCanceledOnTouchOutside(false)
            val layoutParams = window.attributes
            layoutParams.dimAmount = 0.0f
            window.setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT)
            mProgressView = findViewById(R.id.dl_loadingView)
            val progressDrawable = ProgressDrawable()
            progressDrawable.setColor(ContextCompat.getColor(context, R.color.color_cccccc))
            mProgressView!!.setImageDrawable(progressDrawable)
        }
    }

    override fun onAttachedToWindow() {
        val progressView = mProgressView
        if (progressView != null) {
            val drawable = progressView.drawable
            if (drawable is Animatable) {
                (drawable as Animatable).start()
            }
        }
    }

    override fun onDetachedFromWindow() {
        val progressView = mProgressView
        if (progressView != null) {
            val drawable = progressView.drawable
            if (drawable is Animatable) {
                (drawable as Animatable).stop()
            }
        }
    }
}
