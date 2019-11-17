package com.prads.kadesubmission

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.prads.kadesubmission.data.LeagueDummy
import javax.inject.Inject

class LeagueViewModel constructor(private val leagueRepository: LeagueRepository) : ViewModel() {

    @Inject
    fun loadLeagues() : MutableLiveData<List<LeagueDummy>> = leagueRepository.getAllMovies()

//    fun getTvShowDetail(index : Int) : LeagueDummy? = dummyData.getLeagueDummies()?.get(index)
}