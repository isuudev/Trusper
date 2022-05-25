package com.isuu.trusper.view.adapter

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.lifecycle.LifecycleOwner
import com.blankj.utilcode.util.ScreenUtils
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.isuu.trusper.R
import com.isuu.trusper.model.entity.FlowEntity
import com.isuu.trusper.model.gilde.GlideApp
import com.isuu.trusper.utils.BANNER_ITEM_TYPE_VIEW
import com.isuu.trusper.utils.IMAGE_MARGIN_NORMAL_VALUE
import com.isuu.trusper.utils.NORMAL_ITEM_TYPE_VIEW
import com.youth.banner.Banner
import com.zhengsr.viewpagerlib.bean.RectBean
import com.zhengsr.viewpagerlib.indicator.RectIndicator

class FlowAdapter :
    BaseMultiItemQuickAdapter<FlowEntity, FlowAdapter.FlowViewHolder>() {

    init {
        addItemType(NORMAL_ITEM_TYPE_VIEW, R.layout.item_flow_view)
        addItemType(BANNER_ITEM_TYPE_VIEW, R.layout.item_banner_view)
    }

    private lateinit var owner: LifecycleOwner

    fun setLifecycleOwner(owner: LifecycleOwner) {
        this.owner = owner
    }

    override fun convert(holder: FlowViewHolder, item: FlowEntity) {
        when (item.itemType) {
            NORMAL_ITEM_TYPE_VIEW -> {
                initFlowHolderView(holder, item)
            }
            BANNER_ITEM_TYPE_VIEW -> {
                initBannerHolderView(holder, item)
            }
        }
    }

    private fun initBannerHolderView(holder: FlowViewHolder, item: FlowEntity) {
        holder.onBindBannerView(holder, item)
    }

    private fun initFlowHolderView(holder: FlowViewHolder, item: FlowEntity) {
        holder.onBindFlowImageView(holder, item)
        holder.onBindFlowTextView(holder, item)
    }

    inner class FlowViewHolder(view: View) : BaseViewHolder(view) {
        fun onBindFlowImageView(
            holder: FlowViewHolder,
            item: FlowEntity
        ) {
            val imageView = holder.getView<AppCompatImageView>(R.id.itemFlowImageView)
            GlideApp.with(imageView).load(item.url).into(imageView)
        }

        fun onBindFlowTextView(
            holder: FlowViewHolder,
            item: FlowEntity
        ) {
            val textView = holder.getView<AppCompatTextView>(R.id.itemFlowTextView)
            textView.text = item.title
        }

        fun onBindBannerView(
            holder: FlowViewHolder,
            item: FlowEntity
        ) {
            val itemBannerView = holder.getView<View>(R.id.itemBannerView) as Banner<*, *>
            val itemBannerIndicatorView =
                holder.getView<RectIndicator>(R.id.itemBannerIndicatorView)

            val images = item.banners
            val imageSize = images?.size ?: 0
            val screenWidth = ScreenUtils.getScreenWidth()
            val bannerImageAdapter = BannerImagesAdapter(images)
            itemBannerView.startPosition = 0
            itemBannerView.addBannerLifecycleObserver(owner)
                .setAdapter(bannerImageAdapter)
            itemBannerView.isAutoLoop(false)
            //indicator view
            val rectBean = RectBean()
            //set rect width size
            rectBean.width =
                (screenWidth - (IMAGE_MARGIN_NORMAL_VALUE * (imageSize + 1))) / imageSize
            //add rect bean config data
            itemBannerIndicatorView.addRectBean(rectBean)
            itemBannerIndicatorView.addPagerData(
                imageSize,
                itemBannerView.viewPager2
            )
        }
    }
}