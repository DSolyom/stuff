package com.ds.symbols_base.svg

import android.graphics.Canvas

interface Svg {

    fun setColorTint(color: Int)
    fun draw(c: Canvas, w: Int, h: Int, dx: Int = 0, dy: Int = 0)
}