package com.ds.symbols_base.model

interface LevelConfig {

    var boardWidth: Int

    var boardHeight: Int

    var boardCount: Int

    var maxSymbolCount: Int

    var targetSymbolCount: Int

    fun createGameConfig()
}