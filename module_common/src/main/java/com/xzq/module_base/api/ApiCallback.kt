package com.xzq.module_base.api

import io.reactivex.Observable

/**
 * Api回调
 *
 * @author xzq
 */
interface ApiCallback<T> {
    /**
     * 获取调用方法
     *
     * @param api Api服务
     * @return Observable
     */
    fun getApi(api: ApiService): Observable<NetBean<T>>
}
