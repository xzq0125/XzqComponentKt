package com.xzq.module_base.eventbus

import android.text.TextUtils

/**
 * EventBus消息载体
 * Created by xzq on 2018/7/19.
 */
class MessageEvent {

    var message: String? = null
    var data: Any? = null

    internal constructor(message: String) {
        this.message = message
    }

    internal constructor(message: String, data: Any?) {
        this.message = message
        this.data = data
    }

    fun equals(msg: String): Boolean {
        return TextUtils.equals(message, msg)
    }
}

