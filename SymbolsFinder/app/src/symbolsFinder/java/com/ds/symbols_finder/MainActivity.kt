package com.ds.symbols_finder

import androidx.lifecycle.ViewModelProviders
import com.ds.symbols_base.MainActivityBase
import com.ds.symbols_base.viewmodel.GameBase

class MainActivity : MainActivityBase() {

    override fun createGameModel(): GameBase {
        return ViewModelProviders.of(this).get(TheGame::class.java)
    }
}
