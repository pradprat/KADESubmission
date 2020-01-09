package com.prads.kadesubmission.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Classement(
    @SerializedName("name") val name: String?,
    @SerializedName("teamid") val teamid: String?,
    @SerializedName("played") val played: Int?,
    @SerializedName("goalsfor") val goalsfor: Int?,
    @SerializedName("goalsagainst") val goalsagainst: Int?,
    @SerializedName("goalsdifference") val goalsdifference: Int?,
    @SerializedName("win") val win: Int?,
    @SerializedName("draw") val draw: Int?,
    @SerializedName("loss") val loss: Int?,
    @SerializedName("total") val total: Int?
) : Parcelable