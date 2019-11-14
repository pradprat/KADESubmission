package com.prads.kadesubmission

import androidx.lifecycle.ViewModel
import com.prads.kadesubmission.data.League
import com.prads.kadesubmission.utils.DummyData

class LeagueViewModel constructor(private val dummyData: DummyData) : ViewModel() {

    fun loadLeagues() : List<League>? = dummyData.getLeagues()

    fun getTvShowDetail(index : Int) : League? = dummyData.getLeagues()?.get(index)
}