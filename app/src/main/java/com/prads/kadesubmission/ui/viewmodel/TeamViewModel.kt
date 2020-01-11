package com.prads.kadesubmission.ui.viewmodel

import android.content.Context
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

    fun favoriteTeams(context: Context): MutableLiveData<List<Team>> =
        teamRepository.getFavoriteTeams(context)

    fun isFavoriteTeam(context: Context, teamId: String): MutableLiveData<Boolean> =
        teamRepository.getIsFavoriteTeam(context, teamId)

    fun addFavoriteTeam(context: Context, team: Team): MutableLiveData<Boolean> =
        teamRepository.setAddFavoriteTeam(context, team)

    fun deleteFavoriteTeam(context: Context, team: Team): MutableLiveData<Boolean> =
        teamRepository.setDeleteFavoriteTeam(context, team)

}