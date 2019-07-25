package com.yd.xzqcomponentkt

import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex
import com.alibaba.android.arouter.launcher.ARouter
import com.xzq.module_base.User
import com.xzq.module_base.utils.RefreshLayoutInitializer
import com.xzq.module_base.utils.Utils
import com.xzq.module_base.utils.XTimber

/**
 * App
 * Created by xzq on 2018/12/18.
 */
open class App : Application() {

    private var isDebug: Boolean = false

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        // dex突破65535的限制
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        context = this
        Utils.init(this)
        User.init()
        isDebug = Utils.isAppDebug()
        if (isDebug) {
            //初始化懒人log
            XTimber.plant(XTimber.DebugTree())

            //开启InstantRun之后，一定要在ARouter.init之前调用openDebug
            ARouter.openDebug()
            ARouter.openLog()
        }
        ARouter.init(this)
        //初始化下拉刷新
        RefreshLayoutInitializer.initHeader()
    }

    companion object {

        var context: Application? = null
            private set
    }

}
