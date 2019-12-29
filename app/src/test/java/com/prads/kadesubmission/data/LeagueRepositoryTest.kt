package com.prads.kadesubmission.data

import com.example.subm1jetpackmovieskuy.data.source.ApiMain
import com.example.subm1jetpackmovieskuy.data.source.ApiService
import com.prads.kadesubmission.utils.DummyData
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class LeagueRepositoryTest {

    var service: ApiService = ApiMain().services

    @Before
    fun setUp() {
    }

    @Test
    fun getAllLeagues() {
//        ambil semua data dari dummyData
//        cek apakah jumlah data sesuai dengan yang diharapkan yaitu 10
        var leagues = DummyData().getLeagues()
        assertEquals(10, leagues?.size)
    }

    @Test
    fun getLeague() {
//        ambil data dari API getLeagueById dengan id league 4334
//        cek apakah nama league dari data League yang didapatkan sesuai dengan yang diinginkan yaitu French Ligue 1
        var league = service.getLeagueById("4334").execute().body()?.leagues?.last()
        assertEquals("French Ligue 1", league?.strLeague)
    }
}