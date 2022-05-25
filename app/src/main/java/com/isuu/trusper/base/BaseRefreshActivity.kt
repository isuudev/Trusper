package com.isuu.trusper.base

import androidx.appcompat.app.AppCompatActivity
import com.chad.library.adapter.base.BaseQuickAdapter
import com.scwang.smart.refresh.layout.api.RefreshLayout

abstract class BaseRefreshActivity<M, A : BaseQuickAdapter<M, *>> : AppCompatActivity(),
    RefreshExtension<M, A> {
    private var requestPage = 1

    override var limit: Int = 12
    override var currentPage: Int = 1

    override fun onContentChanged() {
        super.onContentChanged()
        initRecyclerView()
        initRefreshLayout()
    }


    override fun initRefreshLayout() {
        refreshLayout?.setOnRefreshLoadMoreListener(this)
    }

    override fun fetchData(page: Int) {
        requestPage = page
        onFetchData(page)
    }

    override fun onFetchSuccess(list: List<M>?) {
        val adapter = this.adapter ?: return
        val dataList = list?.toMutableList() ?: mutableListOf()
        if (requestPage == 1) {
            currentPage = 1
            adapter.setNewInstance(dataList)
            if (dataList.size < limit) {
                if (refreshLayout?.isRefreshing == true) {
                    refreshLayout?.finishRefreshWithNoMoreData()
                }
                refreshLayout?.finishRefreshWithNoMoreData()
            } else {
                if (refreshLayout?.isRefreshing == true) {
                    refreshLayout?.finishRefresh()
                }
            }
        } else {
            if (dataList.size == 0) {
                currentPage = requestPage - 1
                if (refreshLayout?.isLoading == true) {
                    refreshLayout?.finishLoadMoreWithNoMoreData()
                }
            } else if (dataList.size < limit) {
                currentPage = requestPage
                adapter.addData(dataList)
                if (refreshLayout?.isLoading == true) {
                    refreshLayout?.finishLoadMoreWithNoMoreData()
                }
            } else {
                currentPage = requestPage
                adapter.addData(dataList)
                if (refreshLayout?.isLoading == true) {
                    refreshLayout?.finishLoadMore()
                }
            }
        }
    }

    override fun onFetchFailure() {
        if (refreshLayout?.isRefreshing == true) {
            refreshLayout?.finishRefresh(false)
        }
        if (refreshLayout?.isLoading == true) {
            refreshLayout?.finishLoadMore(false)
        }
    }

    override fun onRefresh(refreshLayout: RefreshLayout) {
        fetchData(1)
    }

    override fun onLoadMore(refreshLayout: RefreshLayout) {
        fetchData(++currentPage)
    }
}