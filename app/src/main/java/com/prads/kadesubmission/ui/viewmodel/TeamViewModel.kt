package com.prads.kadesubmission.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.prads.kadesubmission.data.TeamRepository
import com.prads.kadesubmission.data.model.Team

class TeamViewModel constructor(private val teamRepository: TeamRepository) : ViewModel() {

    fun loadTeamById(id:String): MutableLiveData<Team> = teamRepository.getTeam(id)

    fun loadTeams(leagueId: String): MutableLiveData<List<Team>> =
        teamRepository.getAllTeam(leagueId)

    fun searchTeams(query: String, leagueId: String): MutableLiveData<List<Team>> =
        teamRepository.getSearchTeam(query, leagueId)

}