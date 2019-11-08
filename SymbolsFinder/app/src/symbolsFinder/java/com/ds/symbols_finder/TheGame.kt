package com.ds.symbols_finder

import android.preference.PreferenceManager
import com.ds.symbols_base.TheGrid
import com.ds.symbols_base.model.Board
import com.ds.symbols_base.viewmodel.GameBase
import kotlin.math.max
import kotlin.math.min
import kotlin.math.sqrt

class TheGame : GameBase() {

    override fun createGameConfig() {
        PreferenceManager.getDefaultSharedPreferences(applicationContext).edit().putInt("LEVEL", level).apply()
        val symbolLevel = level % 40 + (level / 40) * 3
        targetSymbolCount = level / 40 + 1
        maxSymbolCount =
            min(
                TheGrid.validSymbols.size,
                (symbolLevel + 4) * max(1f, with(targetSymbolCount!!) { toFloat() } / 2).toInt())
        boardCount = min(
            targetSymbolCount + 3,
            if (targetSymbolCount < 2) {
                max(1, (symbolLevel + 5) / 10)
            } else {
                max(1, (symbolLevel + 2) / 4)
            }
        )
        val sizeLevel = (symbolLevel / boardCount + 5) * 7
        boardWidth = if (level % 7 == 0) {
            min(10, sqrt(sizeLevel.toDouble()).toInt() - 2)
        } else {
            min(10, sqrt(sizeLevel.toDouble()).toInt())
        }
        boardHeight = min(12, sizeLevel / boardWidth)
    }

    override fun getRandomBoard(): Board {
        val board = Board(boardWidth, boardHeight)
        for (x in 0 until boardWidth) {
            for (y in 0 until boardHeight) {
                board.items[x][y] = randomSymbol()
            }
        }
        board.targetSymbols = targetSymbols
        return board
    }
}