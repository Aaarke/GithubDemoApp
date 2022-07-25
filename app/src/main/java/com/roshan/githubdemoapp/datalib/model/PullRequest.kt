package com.roshan.githubdemoapp.datalib.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PullRequest(
    val title:String?,
    @SerializedName("created_at")
    val created_date:String?,
    @SerializedName("closed_at")
    val closed_date:String?,
    val user:User
):Parcelable

@Parcelize
data class User(
    @SerializedName("login")
    val name: String,
    val avatar_url:String?
):Parcelable