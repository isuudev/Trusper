package com.isuu.trusper.model.entity

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ProviderEntity(
    val favIcon: String,
    val favIconBase64Encoding: String,
    val name: String
)