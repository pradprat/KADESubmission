package com.prads.kadesubmission.data.model

import com.google.gson.annotations.SerializedName

data class ClassementResponse(
    @SerializedName("table") val table: List<Classement>
)