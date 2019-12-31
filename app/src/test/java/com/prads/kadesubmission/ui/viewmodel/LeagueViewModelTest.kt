package com.prads.kadesubmission.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.prads.kadesubmission.data.LeagueRepository
import com.prads.kadesubmission.data.model.League
import com.prads.kadesubmission.data.model.LeagueDummy
import com.prads.kadesubmission.data.model.LeagueLocal
import com.prads.kadesubmission.mock
import com.prads.kadesubmission.utils.DummyData
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class LeagueViewModelTest {

    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var leagueRepository: LeagueRepository

    lateinit var leagueViewModel: LeagueViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        leagueViewModel = LeagueViewModel(leagueRepository)
    }

    @Test
    fun loadLeagues() {
//        mendapatkan dummy data
//        membuat live data untuk dummy data
//        isi dummy data pada live data
//        saat loadLeagues, return live data dummy yang sudah dibuat
//        lalu cek onChange pada observer
        val fakeLeagues = DummyData().getLeagues()
        val leagues = MutableLiveData<List<LeagueLocal>>()
        leagues.value = fakeLeagues
        Mockito.`when`(leagueViewModel.loadLeagues())
            .thenReturn(leagues)
        val observer: Observer<List<LeagueLocal>> = mock()
        leagueViewModel.loadLeagues().observeForever(observer)
        Mockito.verify(observer).onChanged(leagues.value)
    }

    @Test
    fun loadLeagueById() {
//        mendapatkan dummy data
//        membuat live data untuk dummy data
//        isi dummy data pada live data
//        saat loadLeagueById, return live data dummy yang sudah dibuat
//        lalu cek onChange pada observer
        val fakeLeague = LeagueDummy().getDummyLeague()
        val league = MutableLiveData<League>()
        league.value = fakeLeague
        Mockito.`when`(leagueViewModel.loadLeagueById("123"))
            .thenReturn(league)
        val observer: Observer<League> = mock()
        leagueViewModel.loadLeagueById("123").observeForever(observer)
        Mockito.verify(observer).onChanged(league.value)
    }
}