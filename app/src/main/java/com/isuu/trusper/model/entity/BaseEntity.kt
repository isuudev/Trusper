package com.isuu.trusper.model.entity

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BaseEntity<out T>(val totalCount: Int = 200, val _type: String = "", val value: T? = null)