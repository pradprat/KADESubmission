package com.prads.kadesubmission.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.prads.kadesubmission.data.*

class TeamViewModel constructor(private val teamRepository: TeamRepository) : ViewModel() {

    fun loadTeamById(id:String): MutableLiveData<Team> = teamRepository.getTeam(id)

}