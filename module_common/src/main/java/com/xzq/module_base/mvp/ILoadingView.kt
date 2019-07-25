package com.xzq.module_base.mvp

/**
 * 状态接口，每次请求都会回调[.onShowLoading]
 * 和[.onHideLoading]
 *
 * @author xzq
 */
interface ILoadingView {
    /**
     * 显示Loading回调
     *
     * @param loadingMessage 加载提示
     */
    fun onShowLoading(loadingMessage: String)

    /**
     * 隐藏Loading回调
     */
    fun onHideLoading()
}
