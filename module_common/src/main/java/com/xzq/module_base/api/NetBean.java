package com.xzq.module_base.api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * 请求返回实体
 *
 * @author xzq
 */
public class NetBean<T> {
    private int errorCode;//code
    private String msg;//信息
    private T data;// 返回数据
    @SerializedName(value = "snPageCount", alternate = {"pageCount"})
    private int snPageCount;
    @SerializedName(value = "snTotalCount", alternate = {"count"})
    private int snTotalCount;
    private boolean localHasNextPage;//本地字段

    public boolean isOk() {
        return errorCode == 0;
    }

    public int getCode() {
        return errorCode;
    }

    public T getData() {
        return data;
    }

    public String getMsg() {
        return msg;
    }

    public int getTotalCount() {
        return snTotalCount;
    }

    public boolean hasNextPage() {
        return localHasNextPage;
    }

    public void checkHasNextPage(int mPage) {
        boolean hasNextPage;
        final T entity = data;
        if (entity instanceof BaseListBean) {
            hasNextPage = ((BaseListBean) entity).hasNextPage(mPage);
        } else {
            hasNextPage = mPage < snPageCount - 1;
        }
        this.localHasNextPage = hasNextPage;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void copyFrom(NetBean<T> netBean) {
        this.data = netBean.getData();
        this.errorCode = netBean.getCode();
        this.msg = netBean.getMsg();
    }

    /**
     * 判断返回数据是否为空
     *
     * @return 是否为空
     */
    public boolean isDataEmpty() {
        final T entity = data;
        return entity == null
                || (entity instanceof BaseListBean && ((BaseListBean) entity).isEmpty())
                || (entity instanceof List && ((List) entity).isEmpty());
    }

    /**
     * 返回数据是否为列表
     *
     * @return 是否为列表
     */
    public boolean dataIsList() {
        final T entity = data;
        return entity instanceof List || (entity instanceof BaseListBean);
    }
}
