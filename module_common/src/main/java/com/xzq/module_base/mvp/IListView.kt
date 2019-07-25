package com.xzq.module_base.mvp

/**
 * 网络响应以列表形式返回
 * 列表接口
 *
 * @author xzq
 */
interface IListView<Entity> {

    /**
     * 设置数据
     *
     * @param list        数据列表
     * @param hasNextPage 是否有下一页列表
     * @param totalCount  总数量
     */
    fun setData(list: List<Entity>, page: Int, hasNextPage: Boolean, totalCount: Int)

    /**
     * 追加数据
     *
     * @param list        数据列表
     * @param hasNextPage 是否有下一页列表
     * @param totalCount  总数量
     */
    fun addData(list: List<Entity>, page: Int, hasNextPage: Boolean, totalCount: Int)
}
