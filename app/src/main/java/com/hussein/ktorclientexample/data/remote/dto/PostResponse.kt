package com.hussein.ktorclientexample.data.remote.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PostResponse(
    @SerialName("body")
    var body: String,
    @SerialName("id")
    var id: Int,
    @SerialName("title")
    var title: String,
    @SerialName("userId")
    var userId: Int
)