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

    private lateinit var bannerData: FlowEntity

    private lateinit var bannerList: MutableList<FlowEntity>

    private val bannerImages: List<String> = arrayListOf<String>().apply {
        "http://cache.umusic.com/_sites/_halo/taylorswift/images/meta-image.jpg"
        "https://cdn.cnn.com/cnnnext/dam/assets/201215085238-taylor-swift-2020-sundance-super-tease.jpg"
        "https://pmcvariety.files.wordpress.com/2018/10/taylor_swift.png?w=979"
    }

    private val _initFlowList = MutableLiveData<List<FlowEntity>>()
    val initFlowList: LiveData<List<FlowEntity>>
        get() = _initFlowList

    fun initFlowList(pageIndex: Int, pageSize: Int) = viewModelScope.launch {

        val result = handlerRequest {
            api.apiFlowList(pageIndex, pageSize)
        }

        if (result.value != null && result.value.isNotEmpty()) {

            val flowMutableList: MutableList<FlowEntity> = arrayListOf()

            val flowEntityList = result.value
            bannerList = flowEntityList.toMutableList()
            bannerData = flowEntityList[0]

            for (position in result.value.indices) {
                bannerData = result.value[0]
                if (position % 3 == 0) {
                    result.value[position].itemType = BANNER_ITEM_TYPE_VIEW
                    result.value[position].banners = bannerImages
                    flowMutableList.add(result.value[position])
                    result.value[position].itemType = NORMAL_ITEM_TYPE_VIEW
                    flowMutableList.add(result.value[position])
                } else {
                    result.value[position].itemType = NORMAL_ITEM_TYPE_VIEW
                    flowMutableList.add(result.value[position])
                }
            }

            _initFlowList.value = flowMutableList

        }


    }


}