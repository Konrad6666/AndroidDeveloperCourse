package com.example.lessonplan.dto


import androidx.annotation.Keep

@Keep
data class LocationDto(
    @SerializedName("latitude")
    val latitude: Double,
    @SerializedName("longitude")
    val longitude: Double
)

annotation class SerializedName(val value: String)
