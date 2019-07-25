package com.xzq.module_base.api

import com.google.gson.annotations.SerializedName

/**
 * 请求返回实体
 *
 * @author xzq
 */
class NetBean<T> {
    var code: Int = 0
        private set//code
    var msg: String? = null
        private set//信息
    var data: T? = null// 返回数据
    @SerializedName(value = "snPageCount", alternate = ["pageCount"])
    private val snPageCount: Int = 0
    @SerializedName(value = "snTotalCount", alternate = ["count"])
    val totalCount: Int = 0
    private var localHasNextPage: Boolean = false//本地字段

    val isOk: Boolean
        get() = code == 0

    /**
     * 判断返回数据是否为空
     *
     * @return 是否为空
     */
    val isDataEmpty: Boolean
        get() {
            val entity = data
            return (entity == null
                    || entity is BaseListBean<*> && (entity as BaseListBean<*>).isEmpty
                    || entity is List<*> && (entity as List<*>).isEmpty())
        }

    fun hasNextPage(): Boolean {
        return localHasNextPage
    }

    fun checkHasNextPage(mPage: Int) {
        val hasNextPage: Boolean
        val entity = data
        hasNextPage = if (entity is BaseListBean<*>) {
            (entity as BaseListBean<*>).hasNextPage(mPage)
        } else {
            mPage < snPageCount - 1
        }
        this.localHasNextPage = hasNextPage
    }

    fun copyFrom(netBean: NetBean<T>) {
        this.data = netBean.data
        this.code = netBean.code
        this.msg = netBean.msg
    }

    /**
     * 返回数据是否为列表
     *
     * @return 是否为列表
     */
    fun dataIsList(): Boolean {
        val entity = data
        return entity is List<*> || entity is BaseListBean<*>
    }
}
