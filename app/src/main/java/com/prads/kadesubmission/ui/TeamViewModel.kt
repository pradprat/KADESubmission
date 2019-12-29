package com.prads.kadesubmission.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.prads.kadesubmission.data.TeamRepository
import com.prads.kadesubmission.data.model.Team

class TeamViewModel constructor(private val teamRepository: TeamRepository) : ViewModel() {

    fun loadTeamById(id:String): MutableLiveData<Team> = teamRepository.getTeam(id)

}