package com.ds.symbols_base.svg

// TODO Include your package name here

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.ColorFilter
import android.graphics.Matrix
import android.graphics.Paint
import android.graphics.Path
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter

class Coach: Svg {
    private val p = Paint()
    private val ps = Paint()
    private val t = Path()
    private val m = Matrix()
    private var od: Float = 0.toFloat()
    internal var cf: ColorFilter? = null

    /**
     * IMPORTANT: Due to the static usage of this class this
     * method sets the tint color statically. So it is highly
     * recommended to call the clearColorTint method when you
     * have finished drawing.
     *
     * Sets the color to use when drawing the SVG. This replaces
     * all parts of the drawable which are not completely
     * transparent with this color.
     */
    override fun setColorTint(color: Int) {
        cf = PorterDuffColorFilter(color, PorterDuff.Mode.SRC_IN)
    }

    fun clearColorTint(color: Int) {
        cf = null
    }

    override fun draw(c: Canvas, w: Int, h: Int, dx: Int, dy: Int) {
        val ow = 24f
        val oh = 24f

        od = if (w / ow < h / oh) w / ow else h / oh

        r()
        c.save()
        c.translate((w - od * ow) / 2f + dx, (h - od * oh) / 2f + dy)

        m.reset()
        m.setScale(od, od)

        c.save()
        ps.color = Color.argb(0, 0, 0, 0)
        ps.strokeCap = Paint.Cap.BUTT
        ps.strokeJoin = Paint.Join.MITER
        ps.strokeMiter = 4.0f * od
        c.scale(1.0f, 1.0f)
        c.save()
        c.save()
        p.color = Color.argb(0, 0, 0, 0)
        t.reset()
        t.moveTo(0.0f, 0.0f)
        t.lineTo(24.0f, 0.0f)
        t.quadTo(24.0f, 0.0f, 24.0f, 0.0f)
        t.lineTo(24.0f, 24.0f)
        t.quadTo(24.0f, 24.0f, 24.0f, 24.0f)
        t.lineTo(0.0f, 24.0f)
        t.quadTo(0.0f, 24.0f, 0.0f, 24.0f)
        t.lineTo(0.0f, 0.0f)
        t.quadTo(0.0f, 0.0f, 0.0f, 0.0f)

        t.transform(m)
        c.drawPath(t, p)
        c.drawPath(t, ps)
        c.restore()
        r(4, 0, 1, 2)
        p.color = Color.argb(0, 0, 0, 0)
        c.restore()
        r(4, 0, 1, 2)
        p.color = Color.argb(0, 0, 0, 0)
        c.save()
        c.save()
        p.color = Color.parseColor("#757575")
        t.reset()
        t.moveTo(20.95f, 8.55f)
        t.cubicTo(20.72f, 6.01f, 18.6f, 4.0f, 16.0f, 4.0f)
        t.lineTo(8.0f, 4.0f)
        t.cubicTo(5.4f, 4.0f, 3.28f, 6.01f, 3.05f, 8.55f)
        t.cubicTo(1.33f, 8.77f, 0.0f, 10.23f, 0.0f, 12.0f)
        t.lineTo(0.0f, 17.0f)
        t.cubicTo(0.0f, 18.1f, 0.9f, 19.0f, 2.0f, 19.0f)
        t.lineTo(2.0f, 20.0f)
        t.lineTo(4.0f, 20.0f)
        t.lineTo(4.0f, 19.0f)
        t.lineTo(20.0f, 19.0f)
        t.lineTo(20.0f, 20.0f)
        t.lineTo(22.0f, 20.0f)
        t.lineTo(22.0f, 19.0f)
        t.cubicTo(23.1f, 19.0f, 24.0f, 18.1f, 24.0f, 17.0f)
        t.lineTo(24.0f, 12.0f)
        t.cubicTo(24.0f, 10.23f, 22.67f, 8.77f, 20.95f, 8.55f)
        t.moveTo(18.99f, 8.86f)
        t.cubicTo(17.82f, 9.43f, 17.0f, 10.62f, 17.0f, 12.0f)
        t.lineTo(13.0f, 12.0f)
        t.lineTo(13.0f, 6.0f)
        t.lineTo(16.0f, 6.0f)
        t.cubicTo(17.61f, 6.0f, 18.91f, 7.27f, 18.99f, 8.86f)
        t.moveTo(8.0f, 6.0f)
        t.lineTo(11.0f, 6.0f)
        t.lineTo(11.0f, 12.0f)
        t.lineTo(7.0f, 12.0f)
        t.cubicTo(7.0f, 10.62f, 6.19f, 9.43f, 5.01f, 8.86f)
        t.cubicTo(5.09f, 7.27f, 6.39f, 6.0f, 8.0f, 6.0f)
        t.moveTo(22.0f, 17.0f)
        t.lineTo(2.0f, 17.0f)
        t.lineTo(2.0f, 12.0f)
        t.cubicTo(2.0f, 11.17f, 2.67f, 10.5f, 3.5f, 10.5f)
        t.cubicTo(4.33f, 10.5f, 5.0f, 11.17f, 5.0f, 12.0f)
        t.lineTo(5.0f, 13.0f)
        t.cubicTo(5.0f, 13.55f, 5.45f, 14.0f, 6.0f, 14.0f)
        t.lineTo(18.0f, 14.0f)
        t.cubicTo(18.55f, 14.0f, 19.0f, 13.55f, 19.0f, 13.0f)
        t.lineTo(19.0f, 12.0f)
        t.cubicTo(19.0f, 11.17f, 19.67f, 10.5f, 20.5f, 10.5f)
        t.cubicTo(21.33f, 10.5f, 22.0f, 11.17f, 22.0f, 12.0f)
        t.lineTo(22.0f, 17.0f)

        t.transform(m)
        c.drawPath(t, p)
        c.drawPath(t, ps)
        c.restore()
        r(4, 0, 1, 2, 3)
        p.color = Color.parseColor("#757575")
        c.restore()
        r(4, 0, 1, 2, 3)
        p.color = Color.parseColor("#757575")
        c.restore()
        r()

        c.restore()
    }

    private fun r(vararg o: Int) {
        p.reset()
        ps.reset()
        if (cf != null) {
            p.colorFilter = cf
            ps.colorFilter = cf
        }
        p.isAntiAlias = true
        ps.isAntiAlias = true
        p.style = Paint.Style.FILL
        ps.style = Paint.Style.STROKE
        for (i in o) {
            when (i) {
                0 -> ps.strokeCap = Paint.Cap.BUTT
                1 -> ps.strokeJoin = Paint.Join.MITER
                2 -> ps.strokeMiter = 4.0f * od
                3 -> p.color = Color.argb(0, 0, 0, 0)
                4 -> ps.color = Color.argb(0, 0, 0, 0)
            }
        }
    }
};