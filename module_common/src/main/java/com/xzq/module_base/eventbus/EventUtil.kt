package com.xzq.module_base.eventbus

import org.greenrobot.eventbus.EventBus

/**
 * EventBus工具
 * Created by xzq on 2018/7/19.
 */

object EventUtil {

    fun register(subscriber: Any) {
        EventBus.getDefault().register(subscriber)
    }

    fun unregister(subscriber: Any) {
        EventBus.getDefault().unregister(subscriber)
    }

    fun post(msg: String) {
        EventBus.getDefault().post(MessageEvent(msg))
    }

    fun post(msg: String, data: Any) {
        EventBus.getDefault().post(MessageEvent(msg, data))
    }

    fun postSticky(msg: String) {
        EventBus.getDefault().postSticky(MessageEvent(msg))
    }

    fun postSticky(msg: String, data: Any) {
        EventBus.getDefault().postSticky(MessageEvent(msg, data))
    }

    fun removeAllStickyEvents(event: Any) {
        EventBus.getDefault().removeStickyEvent(event)
    }

    fun removeAllStickyEvents() {
        EventBus.getDefault().removeAllStickyEvents()
    }

}
