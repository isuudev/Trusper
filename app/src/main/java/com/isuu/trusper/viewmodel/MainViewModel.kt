package com.isuu.trusper.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.isuu.trusper.model.Api
import com.isuu.trusper.model.entity.BaseEntity
import com.isuu.trusper.model.entity.FlowEntity
import com.isuu.trusper.model.net.handlerRequest
import com.isuu.trusper.model.net.handlerResponse
import com.isuu.trusper.model.net.response
import com.isuu.trusper.utils.BANNER_ITEM_TYPE_VIEW
import com.isuu.trusper.utils.NORMAL_ITEM_TYPE_VIEW
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val api: Api) : ViewModel() {

    private val _initFlowList = MutableLiveData<BaseEntity<List<FlowEntity>>>()
    val initFlowList: LiveData<BaseEntity<List<FlowEntity>>>
        get() = _initFlowList

    fun initFlowList(pageIndex: Int, pageSize: Int) = viewModelScope.launch {

        val result = handlerRequest {
            api.apiFlowList(pageIndex, pageSize)
        }

        _initFlowList.value = result

    }

    fun flowSort(position: Int): Boolean {
        val p = position + 1
        return p % 3 == 0
    }

    fun convertData(data: List<FlowEntity>): List<FlowEntity> {
        for (position in data.indices) {
            if (flowSort(position)) {
                data[position].itemType = BANNER_ITEM_TYPE_VIEW
                data[position].banners.add(data[position].url)
                data[position].banners.add(data[position].url)
            }
        }
        return data
    }

}