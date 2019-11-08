package com.ds.symbols_memory

import android.preference.PreferenceManager
import com.ds.symbols_base.TheGrid
import com.ds.symbols_base.model.Board
import com.ds.symbols_base.viewmodel.GameBase
import kotlin.math.min
import kotlin.math.sqrt

class TheGame : GameBase() {

    override fun createGameConfig() {
        PreferenceManager.getDefaultSharedPreferences(applicationContext).edit().putInt("LEVEL", level).apply()
        targetSymbolCount = level / 5 + 1
        maxSymbolCount =
            min(TheGrid.validSymbols.size, (level - ((targetSymbolCount - 3) * 3)) * 2 + targetSymbolCount * 2)
        boardCount = 1
        boardHeight = sqrt(maxSymbolCount.toFloat()).toInt()
        boardWidth = (maxSymbolCount + boardHeight - 1) / boardHeight
    }

    override fun getRandomBoard(): Board {
        val board = Board(boardWidth, boardHeight)
        for (x in 0 until boardWidth) {
            for (y in 0 until boardHeight) {

                val symbol = x + y * boardWidth
                board.items[x][y] = when (symbol < maxSymbolCount) {
                    true -> symbol
                    else -> -1
                }
            }
        }
        board.targetSymbols = targetSymbols
        return board
    }
}