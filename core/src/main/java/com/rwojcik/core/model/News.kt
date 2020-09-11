package com.rwojcik.core.model

data class News(
    val title: String,
    val lead: String,
    val published: String,
    val comments: Int,
    val section: String,
    val imageUrl: String
)