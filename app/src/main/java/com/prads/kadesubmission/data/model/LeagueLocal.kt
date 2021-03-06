package com.prads.kadesubmission.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LeagueLocal(val name: String, val logo: Int, val id: String, val description: String) :
    Parcelable