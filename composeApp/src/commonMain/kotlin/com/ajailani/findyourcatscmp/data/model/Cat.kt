package com.ajailani.findyourcatscmp.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Cat(
    val id: String,
    val name: String,
    @SerialName("image_link")
    val imageLink: String,
    val length: String,
    val origin: String,
    @SerialName("family_friendly")
    val familyFriendlyRating: Int,
    @SerialName("general_health")
    val generalHealthRating: Int,
    @SerialName("grooming")
    val groomingRating: Int
)