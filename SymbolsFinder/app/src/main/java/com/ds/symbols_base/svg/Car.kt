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

class Car: Svg {
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
        r(4, 0, 1, 2)
        p.color = Color.argb(0, 0, 0, 0)
        c.restore()
        r(4, 0, 1, 2)
        p.color = Color.argb(0, 0, 0, 0)
        c.save()
        c.save()
        p.color = Color.parseColor("#757575")
        t.reset()
        t.moveTo(13.0f, 7.0f)
        t.cubicTo(9.48f, 7.0f, 6.56f, 9.61f, 6.07f, 13.0f)
        t.lineTo(6.0f, 13.0f)
        t.cubicTo(3.79f, 13.0f, 2.0f, 14.8f, 2.0f, 17.0f)
        t.lineTo(2.0f, 19.0f)
        t.cubicTo(2.0f, 19.55f, 2.45f, 20.0f, 3.0f, 20.0f)
        t.lineTo(5.19f, 20.0f)
        t.cubicTo(5.6f, 21.16f, 6.7f, 22.0f, 8.0f, 22.0f)
        t.cubicTo(9.3f, 22.0f, 10.4f, 21.16f, 10.82f, 20.0f)
        t.lineTo(14.18f, 20.0f)
        t.cubicTo(14.6f, 21.16f, 15.7f, 22.0f, 17.0f, 22.0f)
        t.cubicTo(18.3f, 22.0f, 19.4f, 21.16f, 19.82f, 20.0f)
        t.lineTo(21.0f, 20.0f)
        t.cubicTo(21.55f, 20.0f, 22.0f, 19.55f, 22.0f, 19.0f)
        t.lineTo(22.0f, 16.0f)
        t.cubicTo(22.0f, 11.04f, 17.96f, 7.0f, 13.0f, 7.0f)
        t.moveTo(19.32f, 13.0f)
        t.lineTo(14.0f, 13.0f)
        t.lineTo(14.0f, 9.08f)
        t.cubicTo(16.35f, 9.42f, 18.33f, 10.93f, 19.32f, 13.0f)
        t.moveTo(12.0f, 9.1f)
        t.lineTo(12.0f, 13.0f)
        t.lineTo(8.1f, 13.0f)
        t.cubicTo(8.5f, 11.05f, 10.04f, 9.5f, 12.0f, 9.1f)
        t.moveTo(8.0f, 20.0f)
        t.cubicTo(7.45f, 20.0f, 7.0f, 19.55f, 7.0f, 19.0f)
        t.cubicTo(7.0f, 18.45f, 7.45f, 18.0f, 8.0f, 18.0f)
        t.cubicTo(8.55f, 18.0f, 9.0f, 18.45f, 9.0f, 19.0f)
        t.cubicTo(9.0f, 19.55f, 8.55f, 20.0f, 8.0f, 20.0f)
        t.moveTo(17.0f, 20.0f)
        t.cubicTo(16.45f, 20.0f, 16.0f, 19.55f, 16.0f, 19.0f)
        t.cubicTo(16.0f, 18.45f, 16.45f, 18.0f, 17.0f, 18.0f)
        t.cubicTo(17.55f, 18.0f, 18.0f, 18.45f, 18.0f, 19.0f)
        t.cubicTo(18.0f, 19.55f, 17.55f, 20.0f, 17.0f, 20.0f)
        t.moveTo(20.0f, 18.0f)
        t.lineTo(19.82f, 18.0f)
        t.cubicTo(19.4f, 16.84f, 18.3f, 16.0f, 17.0f, 16.0f)
        t.cubicTo(15.7f, 16.0f, 14.6f, 16.84f, 14.19f, 18.0f)
        t.lineTo(10.82f, 18.0f)
        t.cubicTo(10.4f, 16.84f, 9.3f, 16.0f, 8.0f, 16.0f)
        t.cubicTo(6.7f, 16.0f, 5.6f, 16.84f, 5.19f, 18.0f)
        t.lineTo(4.0f, 18.0f)
        t.lineTo(4.0f, 17.0f)
        t.cubicTo(4.0f, 15.9f, 4.9f, 15.0f, 6.0f, 15.0f)
        t.lineTo(19.92f, 15.0f)
        t.cubicTo(19.97f, 15.33f, 20.0f, 15.66f, 20.0f, 16.0f)
        t.lineTo(20.0f, 18.0f)

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