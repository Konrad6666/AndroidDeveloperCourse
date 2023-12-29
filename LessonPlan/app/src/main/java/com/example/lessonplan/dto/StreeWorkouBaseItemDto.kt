package com.example.lessonplan.dto


import androidx.annotation.Keep

@Keep
data class StreeWorkouBaseItemDto(
    @SerializedName("address")
    val address: String,
    @SerializedName("location")
    val location: LocationDto,
    @SerializedName("name")
    val name: String,
    @SerializedName("photo")
    val photo: String,
    @SerializedName("id")
    val id: String
)