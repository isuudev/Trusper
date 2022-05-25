package com.isuu.trusper.model.net

import android.content.Context
import android.util.Log
import androidx.fragment.app.Fragment
import com.isuu.trusper.model.entity.BaseEntity

suspend inline fun <T> handlerRequest(crossinline block: suspend () -> BaseEntity<T>): BaseEntity<T> {
    return try {
        block()
    } catch (e: Throwable) {
        Log.w("HttpError", e)
        BaseEntity<T>(-1, "Fail:${e.message}")
    }
}

inline fun <reified T> Context.response(
    baseEntity: BaseEntity<T>,
    noinline error: ((base: BaseEntity<T>) -> Unit)? = null,
    crossinline success: (data: T?) -> Unit
) = handlerResponse(this, baseEntity, error, success)

inline fun <reified T> Fragment.response(
    baseEntity: BaseEntity<T>,
    noinline error: ((base: BaseEntity<T>) -> Unit)? = null,
    crossinline success: ((data: T?) -> Unit)
) = handlerResponse(requireContext(), baseEntity, error, success)

inline fun <reified T> handlerResponse(
    context: Context,
    baseEntity: BaseEntity<T>,
    noinline error: ((base: BaseEntity<T>) -> Unit)? = null,
    crossinline success: (data: T?) -> Unit
) {
    val code = baseEntity.totalCount
    val msg = baseEntity._type
    val data = baseEntity.value
    if (code > 0 || msg == "images") {
        success(data)
    } else {
        error?.invoke(baseEntity)
    }
}