package com.prads.kadesubmission.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.prads.kadesubmission.data.TeamRepository
import com.prads.kadesubmission.data.model.Team
import com.prads.kadesubmission.data.model.TeamDummy
import com.prads.kadesubmission.mock
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TeamViewModelTest {
    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var teamRepository: TeamRepository
    lateinit var teamViewModel: TeamViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        teamViewModel = TeamViewModel(teamRepository)
    }

    @Test
    fun loadTeamById() {
        val fakeTeam = TeamDummy().getDummyTeams()
        val team = MutableLiveData<Team>()
        team.value = fakeTeam
        Mockito.`when`(teamViewModel.loadTeamById("123"))
            .thenReturn(team)
        val observer: Observer<Team> = mock()
        teamViewModel.loadTeamById("123").observeForever(observer)
        Mockito.verify(observer).onChanged(team.value)
    }
}