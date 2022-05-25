package com.isuu.trusper.model.initializer

import android.content.Context
import androidx.startup.Initializer
import com.scwang.smart.refresh.footer.ClassicsFooter
import com.scwang.smart.refresh.header.ClassicsHeader
import com.scwang.smart.refresh.layout.SmartRefreshLayout

class SmartRefreshLayoutInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        SmartRefreshLayout.setDefaultRefreshHeaderCreator { cxt, layout ->
            ClassicsHeader(cxt)
        }
        SmartRefreshLayout.setDefaultRefreshFooterCreator { cxt, layout ->
            ClassicsFooter(cxt)
        }
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        return emptyList()
    }
}