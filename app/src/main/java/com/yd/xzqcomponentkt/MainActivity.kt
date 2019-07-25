package com.yd.xzqcomponentkt

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.xzq.module_base.api.NetCallback
import com.xzq.module_base.arouter.RouterUtils
import com.xzq.module_base.base.BaseActivity


class MainActivity : BaseActivity() {

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initViews(savedInstanceState: Bundle?) {
        hideToolbar()
    }

    override fun activityExit() {}

    fun pagingLoad(view: View) {
        NetCallback.FIRST_PAGE_INDEX = 0
        RouterUtils.openMvp()
    }

    fun pagingLoadEmpty(view: View) {
        NetCallback.FIRST_PAGE_INDEX = 10000
        RouterUtils.openMvp()
    }

    fun pagingLoadCustomLoading(view: View) {
        NetCallback.FIRST_PAGE_INDEX = 335
        RouterUtils.openMvp()
    }

    fun pagingLoadCustomEmpty(view: View) {
        NetCallback.FIRST_PAGE_INDEX = 10001
        RouterUtils.openMvp()
    }

    companion object {

        fun start(context: Context) {
            val starter = Intent(context, MainActivity::class.java)
            context.startActivity(starter)
        }
    }
}
