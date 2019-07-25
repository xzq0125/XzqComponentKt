package com.xzq.module_base.base

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.xzq.module_base.R
import com.xzq.module_base.adapter.BaseRecyclerFooterAdapter
import com.xzq.module_base.adapter.IAdapter
import com.xzq.module_base.api.NetCallback
import com.xzq.module_base.mvp.IListView
import com.xzq.module_base.mvp.MvpContract
import com.xzq.module_base.utils.DividerFactory

/**
 * Activity列表基类
 *
 * @author xzq
 */

abstract class BaseListActivity<P : MvpContract.CommonPresenter, T> : BasePresenterActivity<P>(), IListView<T>,
    BaseRecyclerFooterAdapter.OnLoadMoreCallback {

    protected lateinit var recyclerView: RecyclerView
    protected lateinit var mAdapter: IAdapter<T>
    protected var mPage = NetCallback.FIRST_PAGE_INDEX

    override fun getLayoutId(): Int {
        return R.layout.activity_base_list
    }

    override fun initViews(savedInstanceState: Bundle?) {
        setRefreshEnable(true)
        setToolbar(pageTitle)
        val wrapAdapter = BaseRecyclerFooterAdapter<T>(pageAdapter)
        wrapAdapter.setAlwaysShowFooter(alwaysShowFooter())
        wrapAdapter.setLoadMoreCallback(this)
        mAdapter = wrapAdapter
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.adapter = wrapAdapter
        initRecyclerView(recyclerView)
    }

    override fun getFirstPageData() {
        refresh()
    }

    override fun onStateEmpty() {
        super.onStateEmpty()
        mAdapter.clear()
    }

    override fun onStateError(page: Int, error: String) {
        super.onStateError(page, error)
        mAdapter.clear()
    }

    override fun onAutoLoadMore() {
        onPageLoad(mPage)
    }

    override fun onReloadMore() {
        onPageLoad(mPage)
    }

    override fun onStateLoadMoreError(page: Int, error: String) {
        super.onStateLoadMoreError(page, error)
        mAdapter.onError()
    }

    override fun onStateLoadMoreEmpty() {
        super.onStateLoadMoreEmpty()
        mAdapter.onEmpty()
    }

    override fun setData(list: List<T>, page: Int, hasNextPage: Boolean, totalCount: Int) {
        if (hasNextPage) {
            mPage++
        }
        mAdapter.setData(list, hasNextPage)
    }

    override fun addData(list: List<T>, page: Int, hasNextPage: Boolean, totalCount: Int) {
        if (hasNextPage) {
            mPage++
        }
        mAdapter.addData(list, hasNextPage)
    }

    private fun onPageLoad(page: Int) {
        if (presenter != null) {
            presenter.setPage(page)
            presenter.getList()
        }
    }

    open fun refresh() {
        mPage = NetCallback.FIRST_PAGE_INDEX
        onPageLoad(mPage)
    }

    /**
     * 初始化RecyclerView
     *
     * @param recyclerView RecyclerView
     */
    open fun initRecyclerView(recyclerView: RecyclerView) {
        recyclerView.addItemDecoration(DividerFactory.VERTICAL)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    /**
     * 获取页面标题
     *
     * @return 标题
     */
    protected abstract val pageTitle: String

    /**
     * 获取页面适配器
     *
     * @return 适配器
     */
    protected abstract val pageAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>

    open fun alwaysShowFooter(): Boolean {
        return true
    }
}
