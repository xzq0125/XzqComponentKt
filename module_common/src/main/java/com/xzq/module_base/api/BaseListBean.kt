package com.xzq.module_base.api

import com.google.gson.annotations.SerializedName

/**
 * 列表基类
 *
 * @author xzq
 */

class BaseListBean<T> {

    @SerializedName(value = "snPageCount", alternate = ["pageCount"])
    private val snPageCount: Int = 0
    @SerializedName(value = "snTotalCount", alternate = ["count"])
    val totalCount: Int = 0
    @SerializedName(value = "snData", alternate = ["data", "rows", "datas"])
    val list: List<T>? = null

    val isEmpty: Boolean
        get() = list == null || list.isEmpty()

    /**
     * 是否还有下一页
     *
     * @param page 当前页码
     * @return 是否还有下一页
     */
    fun hasNextPage(page: Int): Boolean {
        return page < snPageCount - 1
    }
}
