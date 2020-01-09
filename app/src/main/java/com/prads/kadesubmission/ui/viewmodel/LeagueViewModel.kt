package com.prads.kadesubmission.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.prads.kadesubmission.data.LeagueRepository
import com.prads.kadesubmission.data.model.Classement
import com.prads.kadesubmission.data.model.League
import com.prads.kadesubmission.data.model.LeagueLocal

class LeagueViewModel constructor(private val leagueRepository: LeagueRepository) : ViewModel() {

    fun loadLeagues(): MutableLiveData<List<LeagueLocal>> = leagueRepository.getAllLeagues()

    fun loadLeagueById(id:String): MutableLiveData<League> = leagueRepository.getLeague(id)

    fun loadClassement(leagueId: String): MutableLiveData<List<Classement>> =
        leagueRepository.getClassement(leagueId)

//    fun getTvShowDetail(index : Int) : LeagueDummy? = dummyData.getLeagueDummies()?.get(index)
}