package com.isuu.trusper.model.gilde

import android.content.Context
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.request.RequestOptions
import com.isuu.trusper.R

@GlideModule
class MyAppGlideModule : AppGlideModule() {

    override fun applyOptions(context: Context, builder: GlideBuilder) {
        builder.setDefaultRequestOptions {
            RequestOptions()
                .placeholder(R.drawable.ic_placeholder_default)
                .error(R.drawable.ic_placeholder_default)
        }
    }
}