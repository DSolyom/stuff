package com.ds.balloons.widget

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.AnimationDrawable
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.FrameLayout
import androidx.core.graphics.get
import com.ds.balloons.R
import com.ds.balloons.vm.Balloon
import kotlinx.android.synthetic.main.balloon.view.*

@SuppressLint("ViewConstructor")
open class BalloonLayout(
    context: Context,
    attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {

    companion object {
        var mask: Bitmap? = null
    }

    /**
     * The balloon data.
     */
    var balloon: Balloon? = null

    /**
     * Listener for balloon touch.
     */
    var onBalloonTouched: ((Balloon) -> Unit)? = null

    init {
        if (mask == null) {
            mask = BitmapFactory.decodeResource(
                resources,
                R.drawable.lufi
            )
        }
        isEnabled = false
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        positionBalloon()
        setupBalloon()
    }

    /**
     * Setups the balloons.
     */
    private fun setupBalloon() {
        if (balloon == null) {
            return
        }
        val balloonPackTypeArray = resources.obtainTypedArray(R.array.balloon_pack)
        balloon_view.setColorFilter(balloonPackTypeArray.getColor(balloon!!.color, 0))
        balloonPackTypeArray.recycle()

        if (balloon!!.isTarget && balloon!!.isSelected) {
            (balloon_view.drawable as AnimationDrawable).start()
        }

        setOnClickListener {
            if (isEnabled) {
                onBalloonTouched?.invoke(balloon!!)
            }
        }
        /*
        balloon_view.setOnTouchListener { _, event ->
            if (isEnabled) {
                when (event.action) {
                    MotionEvent.ACTION_DOWN -> {
                        if (checkTouch(event)) {
                            return@setOnTouchListener true
                        }
                    }
                    MotionEvent.ACTION_UP -> {
                        if (checkTouch(event)) {
                            onBalloonTouched?.invoke(balloon!!)
                            return@setOnTouchListener true
                        }
                    }
                }
            }
            false
        }*/
    }

    /**
     * positions the balloon view.
     */
    private fun positionBalloon() {
        (balloon_view.layoutParams as LayoutParams).apply {
            leftMargin = ((balloon?.x ?: 0.0) * (measuredWidth - balloon_view.measuredWidth)).toInt()
            topMargin = ((balloon?.y ?: 0.0) * (measuredHeight - balloon_view.measuredHeight)).toInt()
        }
    }

    private fun checkTouch(event: MotionEvent): Boolean {
        return mask!![event.x.toInt(), event.y.toInt()] != 0
    }
}