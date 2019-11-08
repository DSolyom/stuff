package com.ds.symbols_base

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.util.DisplayMetrics
import android.view.MotionEvent
import com.ds.symbols_base.model.Board
import kotlin.math.min
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.util.Log
import com.ds.symbols_base.svg.*
import com.ds.symbols_base.svg.Camera


class TheGrid @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    companion object {
        const val GRID_PADDING_START = 2
        const val GRID_PADDING_END = 2
        const val GRID_PADDING_TOP = 4
        const val GRID_PADDING_BOTTOM = 2

        val validSymbols = arrayOf(
            AddCircle::class.java.newInstance(),
            AirPlane::class.java.newInstance(),
            Alien::class.java.newInstance(),
            Box::class.java.newInstance(),
            Book::class.java.newInstance(),
            Camera::class.java.newInstance(),
            Car::class.java.newInstance(),
            Castle::class.java.newInstance(),
            Ccamera::class.java.newInstance(),
            Check::class.java.newInstance(),
            Chef::class.java.newInstance(),
            Cloud::class.java.newInstance(),
            Coach::class.java.newInstance(),
            Coins::class.java.newInstance(),
            Computer::class.java.newInstance(),
            X_::class.java.newInstance()
        )

        private val symbols = ArrayList<Bitmap>()
    }

    var board: Board? = null
        set(value) {
            field = value
            requestLayout()
            postInvalidate()
        }

    private val columns: Int
        get() {
            return board?.width ?: 0
        }

    private val rows: Int
        get() {
            return board?.height ?: 0
        }

    private val backgroundPaint = Paint()
    private val gridPaint = Paint()
    private val symbolPaint = Paint()

    private val dp: Float

    private val paddingStart: Float
    private val paddingEnd: Float
    private val paddingTop: Float
    private val paddingBottom: Float

    private var startOffset = 0
    private var boardWidth = 0
    private var boardHeight = 0

    private var gridMinX = 0f
    private var gridMaxX = 0f
    private var gridMinY = 0f
    private var gridMaxY = 0f
    private var gridSize = 0
    private var iconSize = 0


    private val colorFound: Int
    private val colorWrong: Int
    private val colorSelected: Int
    private val colorUnselected: Int

    private var touchDownPos: Point? = null

    init {
        backgroundPaint.color = resources.getColor(R.color.board_background, null)
        backgroundPaint.style = Paint.Style.FILL
        gridPaint.color = resources.getColor(R.color.grid, null)
        colorFound = resources.getColor(R.color.found, null)
        colorWrong = resources.getColor(R.color.wrong, null)
        colorSelected = resources.getColor(R.color.selected, null)
        colorUnselected = resources.getColor(R.color.unselected, null)
        dp = context.resources.displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT
        gridPaint.strokeWidth = dp
        paddingStart = GRID_PADDING_START * dp
        paddingEnd = GRID_PADDING_END * dp
        paddingTop = GRID_PADDING_TOP * dp
        paddingBottom = GRID_PADDING_BOTTOM * dp
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        val gridSizeFromWidth = (measuredWidth - paddingStart - paddingEnd) / columns
        val gridSizeFromHeight = (measuredHeight - paddingTop - paddingBottom) / rows

        gridSize = min(gridSizeFromWidth, gridSizeFromHeight).toInt()

        boardWidth = (gridSize * columns + paddingStart + paddingEnd).toInt()
        boardHeight = (gridSize * rows + paddingTop + paddingBottom).toInt()

        startOffset = (measuredWidth - boardWidth) / 2

        setMeasuredDimension(measuredWidth, boardHeight)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        Log.e("ADAS", "ASDAS")
        if (canvas == null || measuredWidth <= paddingStart + paddingEnd || measuredHeight <= paddingTop + paddingBottom) {
            return
        }

        if (symbols.isEmpty()) {
            createIcons()
        }

        canvas.translate(startOffset.toFloat(), 0f)

        gridMinX = 0f
        gridMinY = 0f
        gridMaxX = boardWidth.toFloat() - dp
        gridMaxY = boardHeight.toFloat() - dp

        canvas.drawRect(gridMinX, gridMinY, gridMaxX, gridMaxY, backgroundPaint)

        // borders
        canvas.drawLine(gridMinX, gridMinY, gridMaxX, gridMinY, gridPaint)
        canvas.drawLine(gridMinX, gridMinY, gridMinX, gridMaxY, gridPaint)
        canvas.drawLine(gridMaxX, gridMinY, gridMaxX, gridMaxY, gridPaint)
        canvas.drawLine(gridMinX, gridMaxY, gridMaxX + 1f, gridMaxY, gridPaint)

        if (board == null || columns <= 0 || rows <= 0) {
            canvas.translate(-startOffset.toFloat(), 0f)
            return
        }

        // grid
        iconSize = (gridSize - dp * 5).toInt()

        // top decoration and first line
        canvas.drawLine(gridMinX, gridMinY + 2 * dp, gridMaxX, gridMinY + 2 * dp, gridPaint)

        gridMinY += paddingTop
        gridMaxY -= paddingBottom
        canvas.drawLine(gridMinX, gridMinY, gridMaxX - paddingEnd - dp, gridMinY, gridPaint)
        for (i in 1..rows) {
            canvas.drawLine(gridMinX, gridMinY + i * gridSize, gridMaxX, gridMinY + i * gridSize, gridPaint)
        }

        gridMinX += paddingStart
        gridMaxX -= paddingEnd
        gridMinY -= paddingTop
        gridMaxY += paddingBottom
        for (i in 0..columns) {
            canvas.drawLine(gridMinX + i * gridSize, gridMinY, gridMinX + i * gridSize, gridMaxY, gridPaint)
        }

        for (y in 0 until rows) {
            for (x in 0 until columns) {
                paintSymbol(canvas, x, y)
            }
        }

        canvas.translate(-startOffset.toFloat(), 0f)
    }

    private fun paintSymbol(canvas: Canvas, x: Int, y: Int) {
        val item = board!!.items[x][y]
        if (item == -1 || !isEnabled && !board!!.selected[x][y] && !board!!.targetSymbols!!.contains(item)) {
            return
        }
        val symbol = symbols[item]
        val color = when (board!!.selected[x][y]) {
            true -> {
                if (isEnabled) {
                    colorSelected
                } else {
                    when (board!!.targetSymbols!!.contains(item)) {
                        true -> colorFound
                        false -> colorWrong
                    }
                }
            }
            false -> colorUnselected
        }

        symbolPaint.colorFilter = PorterDuffColorFilter(color, PorterDuff.Mode.SRC_IN)

        val bmpX = paddingStart + x * gridSize + dp * 3
        val bmpY = paddingTop + y * gridSize + dp * 3
        canvas.drawBitmap(
            symbol, null,
            RectF(
                bmpX,
                bmpY,
                bmpX + gridSize - dp * 6,
                bmpY + gridSize - dp * 6
            ),
            symbolPaint
        )
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (isEnabled) {
            when (event?.action) {
                MotionEvent.ACTION_DOWN -> {
                    if (touchDownPos == null) {
                        touchDownPos = checkTouch(event)
                        return true
                    }
                }
                MotionEvent.ACTION_UP -> {
                    if (touchDownPos?.equals(checkTouch(event)) == true) {
                        onValidClick()
                    }
                    touchDownPos = null
                }
            }
        }
        return false
    }

    private fun checkTouch(event: MotionEvent): Point? {
        val boardX = event.x - paddingStart - startOffset
        val boardY = event.y - paddingTop
        if (boardX < 0 || boardY < 0) {
             return null
        }
        val x = (boardX / gridSize).toInt()
        val y = (boardY / gridSize).toInt()

        if (x >= columns || y >= rows || board!!.items[x][y] == -1) {
            return null
        }
        return Point(x, y)
    }

    private fun onValidClick() {
        board!!.selected[touchDownPos!!.x][touchDownPos!!.y] = !board!!.selected[touchDownPos!!.x][touchDownPos!!.y]
        invalidate()
    }

    private fun createIcons() {
        validSymbols.forEach {
            symbols.add(svgToBitmap(it))
        }
    }

    private fun svgToBitmap(svg: Svg): Bitmap {
        val bmp = Bitmap.createBitmap((gridSize - dp * 6).toInt(), (gridSize - dp * 6).toInt(), Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bmp)
        svg.setColorTint(Color.BLACK)
        svg.draw(canvas, bmp.width, bmp.height, 0, 0)
        return bmp
    }
}