package com.prads.kadesubmission.data

import com.example.subm1jetpackmovieskuy.data.source.ApiMain
import com.example.subm1jetpackmovieskuy.data.source.ApiService
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class TeamRepositoryTest {

    var service: ApiService = ApiMain().services

    @Before
    fun setUp() {
    }

    @Test
    fun getTeam() {
//        ambil data Team dari API getTeamById dengan id league 133712
//        cek apakah nama league dari data team yang didapatkan sesuai dengan yang diinginkan yaitu French Ligue 1
//        cek apakah nama team dari data team yang didapatkan sesuai dengan yang diinginkan yaitu Nice

        var events = service.getTeamById("133712").execute().body()?.teams
        assertEquals("French Ligue 1", events?.last()?.strLeague)
        assertEquals("Nice", events?.last()?.strTeam)
    }
}