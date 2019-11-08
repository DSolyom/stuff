package com.ds.symbols_base

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View
import com.ds.symbols_base.svg.Svg
import kotlin.math.min

class TargetSymbol @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    var targetSymbol: Svg? = null
        set(value) {
            field = value
            if (value != null) {
                invalidate()
            }
        }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        if (canvas == null) {
            return
        }

        val symbolSize = min(measuredWidth, measuredHeight)
        val symbolX = (measuredWidth - symbolSize) / 2
        val symbolY = (measuredHeight - symbolSize) / 2

        targetSymbol?.draw(canvas, symbolSize, symbolSize, symbolX, symbolY)
    }
}