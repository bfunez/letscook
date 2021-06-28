package com.example.home.domain.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Recipe (val id : Int, val title : String)