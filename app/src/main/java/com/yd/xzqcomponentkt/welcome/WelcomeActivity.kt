package com.yd.xzqcomponentkt.welcome

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.yd.xzqcomponentkt.MainActivity


class WelcomeActivity : AppCompatActivity(), Runnable {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.postDelayed(this, 2000)
    }

    override fun run() {
        if (isFinishing) {
            finish()
            return
        }
        MainActivity.start(this)
        finish()
    }
}
