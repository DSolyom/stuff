package com.ds.symbols_base.viewmodel

import android.content.Context
import android.preference.PreferenceManager
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ds.symbols_base.State
import com.ds.symbols_base.model.Board
import com.ds.symbols_base.model.LevelConfig
import kotlin.math.max
import kotlin.math.min

abstract class GameBase : ViewModel(), LevelConfig {

    private var gameBoards = ArrayList<Board>()

    var board: LiveData<Board> = MutableLiveData()

    var state: LiveData<State> = MutableLiveData()

    private var atBoard = 0

    var level = 0

    override var boardWidth = 10

    override var boardHeight = 12

    override var boardCount = 2

    override var maxSymbolCount = 4

    override var targetSymbolCount = 1

    val isLastBoard: Boolean
        get() {
            return atBoard == boardCount - 1
        }

    val isFirstBoard: Boolean
        get() {
            return atBoard == 0
        }

    var targetSymbols: IntArray? = null

    var atTarget: LiveData<Int> = MutableLiveData()

    val isFirstTarget: Boolean
        get() {
            return atTarget.value == 0
        }

    val isLastTarget: Boolean
        get() {
            return targetSymbols != null && atTarget.value == targetSymbols!!.size - 1
        }

    protected lateinit var applicationContext: Context

    fun setup(applicationContext: Context) {
        this.applicationContext = applicationContext
        if (state.value == null) {
            newGame()
        } else {
            (state as MutableLiveData).postValue(state.value)
            (board as MutableLiveData).postValue(board.value)
        }
    }

    private fun newGame() {
        createGameConfig()
        atBoard = 0
        targetSymbols = randomSymbols(targetSymbolCount)
        createGameBoards()
        (state as MutableLiveData).postValue(State.SHOW_TARGET)
        (atTarget as MutableLiveData).value = 0
        (board as MutableLiveData).postValue(gameBoards[atBoard])
    }

    fun goBack() {
        if (state.value == State.SHOW_TARGET) {
            (atTarget as MutableLiveData).value = max((atTarget.value ?: 1) - 1, 0)
        } else {
            atBoard = max(atBoard - 1, 0)
            (board as MutableLiveData).postValue(gameBoards[atBoard])
        }
    }

    fun next() {
        if (state.value == State.SHOW_TARGET) {
            (atTarget as MutableLiveData).value = min((atTarget.value ?: -1) + 1, targetSymbols!!.size - 1)
        } else {
            atBoard = min(atBoard + 1, boardCount - 1)
            (board as MutableLiveData).postValue(gameBoards[atBoard])
        }
    }

    fun done() {
        when (state.value) {
            State.SHOW_TARGET -> {
                (state as MutableLiveData).postValue(State.SELECT)
                (board as MutableLiveData).postValue(gameBoards[atBoard])
            }
            State.SELECT -> {
                (state as MutableLiveData).postValue(State.CHECK)
                atBoard = 0
                (board as MutableLiveData).postValue(gameBoards[atBoard])
            }
            else -> {
                if (validateBoards()) {
                    ++level
                }
                newGame()
            }
        }
    }

    fun restartAtLevel(newLevel: Int) {
        level = newLevel
        newGame()
    }

    fun restore(applicationContext: Context) {
        level = PreferenceManager.getDefaultSharedPreferences(applicationContext).getInt("LEVEL", 1)
    }

    private fun createGameBoards() {
        gameBoards.clear()
        for (i in 0 until boardCount) {
            gameBoards.add(getRandomBoard())
        }
    }

    abstract fun getRandomBoard(): Board

    protected fun randomSymbol(): Int {
        return (Math.random() * maxSymbolCount).toInt()
    }

    private fun randomSymbols(size: Int): IntArray {
        val result = IntArray(size) { -1 }
        for (at in 0 until size) {
            var symbol: Int
            do {
                symbol = randomSymbol()
            } while (result.contains(symbol))
            result[at] = symbol
        }
        return result
    }

    private fun validateBoards(): Boolean {
        return gameBoards.all { it.validate() }
    }
}
