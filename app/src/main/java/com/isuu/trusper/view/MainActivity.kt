package com.isuu.trusper.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.isuu.trusper.R
import com.isuu.trusper.base.BaseRefreshActivity
import com.isuu.trusper.base.DefaultLoadingDialog
import com.isuu.trusper.databinding.ActivityMainBinding
import com.isuu.trusper.model.entity.FlowEntity
import com.isuu.trusper.model.net.response
import com.isuu.trusper.utils.*
import com.isuu.trusper.view.adapter.FlowAdapter
import com.isuu.trusper.view.recyclerview.GridSpacingItemDecoration
import com.isuu.trusper.viewmodel.MainViewModel
import com.scwang.smart.refresh.layout.SmartRefreshLayout
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseRefreshActivity<FlowEntity, FlowAdapter>() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override val refreshLayout: SmartRefreshLayout
        get() = binding.refreshLayout

    override val recyclerView: RecyclerView
        get() = binding.recyclerView

    override val adapter: FlowAdapter = FlowAdapter()

    private val viewModel: MainViewModel by viewModels()

    private val loadingView: DefaultLoadingDialog by lazy {
        DefaultLoadingDialog(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        fetchData(NORMAL_PAGE_INDEX)
        observeFlowList()
    }

    private fun observeFlowList() {
        loadingView.show()
        viewModel.initFlowList.observe(this) { result ->
            loadingView.hide()
            response(result) { data ->
                when {
                    data == null -> {
                        adapter.setEmptyView(emptyView())
                        onFetchSuccess(arrayListOf())
                    }
                    data.isNotEmpty() -> {
                        onFetchSuccess(viewModel.convertData(data))
                    }
                    else -> {
                        onFetchFailure()
                    }
                }
            }
        }

        binding.addImageButton.setOnClickListener {
            adapter.addHeaderView(emptyView())
        }
    }

    override fun initRecyclerView() {
        val gridLayoutManager = GridLayoutManager(this, SPAN_COUNT)
        adapter.setLifecycleOwner(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = gridLayoutManager
        val divider = GridSpacingItemDecoration(SPAN_COUNT, GRID_SPACING)
        recyclerView.addItemDecoration(divider)
        adapter.setOnItemClickListener { _, _, position ->
            val url = adapter.data[position].url
            UserPhotoActivity.startActivity(this@MainActivity, url)
        }

        gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                if (viewModel.flowSort(position)) {
                    return BANNER_ITEM_TYPE_VIEW
                }
                return NORMAL_ITEM_TYPE_VIEW
            }
        }
    }

    override fun onFetchData(page: Int) {
        viewModel.initFlowList(page, NORMAL_PAGE_SIZE)
    }

    @SuppressLint("SetTextI18n")
    private fun emptyView(): TextView {
        val textView = TextView(this)
        textView.text = "Not data"
        textView.setTextColor(ContextCompat.getColor(this, R.color.purple_700))
        textView.textSize = 15f
        return textView
    }
}

