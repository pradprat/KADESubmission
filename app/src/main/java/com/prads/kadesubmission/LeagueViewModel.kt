package com.prads.kadesubmission

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.prads.kadesubmission.data.League
import com.prads.kadesubmission.utils.DummyData
import javax.inject.Inject

class LeagueViewModel constructor(private val leagueRepository: LeagueRepository) : ViewModel() {

    @Inject
    fun loadLeagues() : MutableLiveData<List<League>> = leagueRepository.getAllMovies()

//    fun getTvShowDetail(index : Int) : League? = dummyData.getLeagues()?.get(index)
}