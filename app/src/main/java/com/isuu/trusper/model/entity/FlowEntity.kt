package com.isuu.trusper.model.entity

import com.chad.library.adapter.base.entity.MultiItemEntity
import com.isuu.trusper.utils.NORMAL_ITEM_TYPE_VIEW
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FlowEntity(
    val base64Encoding: Any?,
    val height: Int,
    val imageWebSearchUrl: String,
    val name: String,
    val provider: ProviderEntity?,
    val thumbnail: String,
    val thumbnailHeight: Int,
    val thumbnailWidth: Int,
    val title: String,
    val url: String,
    val webpageUrl: String,
    val width: Int,
    override var itemType: Int = NORMAL_ITEM_TYPE_VIEW,
    var banners: MutableList<String> = arrayListOf()
) : MultiItemEntity

