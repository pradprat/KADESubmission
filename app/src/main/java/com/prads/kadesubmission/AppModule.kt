package com.prads.kadesubmission

import android.app.Application
import com.prads.kadesubmission.data.League
import com.prads.kadesubmission.utils.DummyData
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    internal fun getString(): String {
        return "from app module"
    }

}
