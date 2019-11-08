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

class Camera: Svg {
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

    @JvmOverloads
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
        r(1, 3, 4, 5)
        p.color = Color.argb(0, 0, 0, 0)
        c.restore()
        r(1, 3, 4, 5)
        p.color = Color.argb(0, 0, 0, 0)
        c.save()
        c.save()
        c.save()
        p.color = Color.parseColor("#757575")
        t.reset()
        t.moveTo(12.0f, 8.0f)
        t.cubicTo(9.24f, 8.0f, 7.0f, 10.25f, 7.0f, 13.0f)
        t.cubicTo(7.0f, 15.76f, 9.24f, 18.0f, 12.0f, 18.0f)
        t.cubicTo(14.76f, 18.0f, 17.0f, 15.76f, 17.0f, 13.0f)
        t.cubicTo(17.0f, 10.25f, 14.76f, 8.0f, 12.0f, 8.0f)
        t.moveTo(12.0f, 16.0f)
        t.cubicTo(10.35f, 16.0f, 9.0f, 14.66f, 9.0f, 13.0f)
        t.cubicTo(9.0f, 11.35f, 10.35f, 10.0f, 12.0f, 10.0f)
        t.cubicTo(13.65f, 10.0f, 15.0f, 11.35f, 15.0f, 13.0f)
        t.cubicTo(15.0f, 14.66f, 13.65f, 16.0f, 12.0f, 16.0f)

        t.transform(m)
        c.drawPath(t, p)
        c.drawPath(t, ps)
        c.restore()
        r(1, 3, 4, 5, 2)
        p.color = Color.parseColor("#757575")
        c.save()
        t.reset()
        t.moveTo(20.0f, 6.0f)
        t.lineTo(16.54f, 6.0f)
        t.lineTo(15.13f, 3.89f)
        t.cubicTo(14.76f, 3.33f, 14.13f, 3.0f, 13.46f, 3.0f)
        t.lineTo(10.54f, 3.0f)
        t.cubicTo(9.87f, 3.0f, 9.24f, 3.33f, 8.87f, 3.89f)
        t.lineTo(7.46f, 6.0f)
        t.lineTo(4.0f, 6.0f)
        t.cubicTo(2.9f, 6.0f, 2.0f, 6.9f, 2.0f, 8.0f)
        t.lineTo(2.0f, 19.0f)
        t.cubicTo(2.0f, 20.11f, 2.9f, 21.0f, 4.0f, 21.0f)
        t.lineTo(20.0f, 21.0f)
        t.cubicTo(21.1f, 21.0f, 22.0f, 20.11f, 22.0f, 19.0f)
        t.lineTo(22.0f, 8.0f)
        t.cubicTo(22.0f, 6.9f, 21.1f, 6.0f, 20.0f, 6.0f)
        t.moveTo(4.0f, 19.0f)
        t.lineTo(4.0f, 8.0f)
        t.lineTo(8.54f, 8.0f)
        t.lineTo(10.54f, 5.0f)
        t.lineTo(13.46f, 5.0f)
        t.lineTo(15.46f, 8.0f)
        t.lineTo(20.0f, 8.0f)
        t.lineTo(20.0f, 19.0f)
        t.lineTo(4.0f, 19.0f)

        t.transform(m)
        c.drawPath(t, p)
        c.drawPath(t, ps)
        c.restore()
        r(1, 3, 4, 5, 2, 0)
        c.restore()
        r(1, 3, 4, 5, 2)
        p.color = Color.parseColor("#757575")
        c.restore()
        r(1, 3, 4, 5, 2)
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
                0 -> p.color = Color.parseColor("#757575")
                1 -> ps.color = Color.argb(0, 0, 0, 0)
                2 -> p.color = Color.argb(0, 0, 0, 0)
                3 -> ps.strokeCap = Paint.Cap.BUTT
                4 -> ps.strokeJoin = Paint.Join.MITER
                5 -> ps.strokeMiter = 4.0f * od
            }
        }
    }
};