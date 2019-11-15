package com.prads.kadesubmission.data

data class League(
    var name:String,
    var logo:Int,
    var id:Int,
    var description:String
){
    companion object {
        const val LEAGUE_ID = "LEAGUE ID"
    }
}