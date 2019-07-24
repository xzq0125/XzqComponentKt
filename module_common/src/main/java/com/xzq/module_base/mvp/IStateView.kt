package com.xzq.module_base.mvp

/**
 * 状态接口，适用于页面首次加载时显示对应的状态
 * 比如 loading、empty、error、normal
 *
 *
 * 如果你的页面需要这种状态，网络回调应该使用
 * [com.xzq.module_base.mvp.AbsPresenter.StateCallback]
 * 作为观察者
 *
 * @author xzq
 */

interface IStateView : ILoadingView {

    /**
     * 加载中
     */
    fun onStateLoading(loadingMessage: String)

    /**
     * 加载出错
     */
    fun onStateError(page: Int, error: String)

    /**
     * 加载为空
     */
    fun onStateEmpty()

    /**
     * 加载完成
     */
    fun onStateNormal()

    /**
     * 加载更多数据为空回调
     */
    fun onStateLoadMoreEmpty()

    /**
     * 加载更多错误回调
     */
    fun onStateLoadMoreError(page: Int, error: String)

}
