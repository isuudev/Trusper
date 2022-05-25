package com.isuu.trusper.base

import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.scwang.smart.refresh.layout.SmartRefreshLayout
import com.scwang.smart.refresh.layout.listener.OnRefreshLoadMoreListener

interface RefreshExtension<M, A : BaseQuickAdapter<M, *>> : OnRefreshLoadMoreListener {

    val refreshLayout: SmartRefreshLayout?

    val recyclerView: RecyclerView?

    val adapter: A?

    var limit: Int

    var currentPage: Int

    fun initRecyclerView()

    fun initRefreshLayout()

    fun fetchData(page: Int)

    fun onFetchData(page: Int)

    fun onFetchSuccess(list: List<M>?)

    fun onFetchFailure()
}