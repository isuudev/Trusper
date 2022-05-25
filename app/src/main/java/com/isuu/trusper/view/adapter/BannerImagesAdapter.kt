package com.isuu.trusper.view.adapter

import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.isuu.trusper.model.gilde.GlideApp
import com.youth.banner.adapter.BannerAdapter

class BannerImagesAdapter (images: List<String>?) :
    BannerAdapter<String, BannerImagesAdapter.BannerViewHolder>(images) {
    override fun onCreateHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        val imageView = ImageView(parent.context)
        imageView.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        imageView.scaleType = ImageView.ScaleType.CENTER_CROP
        return BannerViewHolder(imageView)
    }


    inner class BannerViewHolder(var imageView: ImageView) : RecyclerView.ViewHolder(
        imageView
    )

    override fun onBindView(
        holder: BannerViewHolder,
        data: String,
        position: Int,
        size: Int
    ) {
        GlideApp.with(holder.imageView).load(data).into(holder.imageView)
    }
}