package com.ds.symbols_base.model

class Board(val width: Int, val height: Int) {

    val items = Array(width) {
        Array(height) {
            0
        }
    }

    val selected = Array(width) {
        Array(height) {
            false
        }
    }

    var targetSymbols: IntArray? = null

    fun validate(): Boolean {
        for (x in 0 until width) {
            for (y in 0 until height) {
                if (selected[x][y] != targetSymbols?.contains(items[x][y])) {
                        return false
                }
            }
        }
        return true
    }
}
