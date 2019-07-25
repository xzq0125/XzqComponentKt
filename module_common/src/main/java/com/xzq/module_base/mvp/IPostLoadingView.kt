package com.xzq.module_base.mvp

/**
 * 加载框接口，适用于发送类似Post请求时显示加载框
 *
 *
 * 网络回调使用[io.reactivex.Observer]的子类
 * [com.xzq.module_base.mvp.AbsPresenter.PostLoadingCallback]
 * 作为观察者时会触发[.onShowPostLoading]
 * 和[.onHidePostLoading]回调
 *
 * @author xzq
 */
interface IPostLoadingView {
    /**
     * 显示PostLoading回调
     *
     * @param loadingMessage 加载提示
     */
    fun onShowPostLoading(loadingMessage: String)

    /**
     * 隐藏PostLoading回调
     */
    fun onHidePostLoading()
}
