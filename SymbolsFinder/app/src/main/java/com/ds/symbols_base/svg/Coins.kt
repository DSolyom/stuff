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

class Coins: Svg {
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
        t.moveTo(4.09f, 5.0f)
        t.cubicTo(4.56f, 4.59f, 6.21f, 4.0f, 8.0f, 4.0f)
        t.cubicTo(9.79f, 4.0f, 11.44f, 4.59f, 11.91f, 5.0f)
        t.lineTo(14.0f, 5.0f)
        t.cubicTo(14.0f, 2.76f, 9.88f, 2.0f, 8.0f, 2.0f)
        t.cubicTo(6.12f, 2.0f, 2.0f, 2.76f, 2.0f, 5.0f)
        t.lineTo(2.0f, 17.0f)
        t.cubicTo(2.0f, 19.25f, 6.12f, 20.0f, 8.0f, 20.0f)
        t.cubicTo(8.29f, 20.0f, 8.63f, 19.98f, 9.0f, 19.94f)
        t.lineTo(9.0f, 17.93f)
        t.cubicTo(8.68f, 17.97f, 8.34f, 18.0f, 8.0f, 18.0f)
        t.cubicTo(6.08f, 18.0f, 4.32f, 17.32f, 4.0f, 16.91f)
        t.lineTo(4.0f, 16.22f)
        t.cubicTo(5.32f, 16.78f, 6.99f, 17.0f, 8.0f, 17.0f)
        t.cubicTo(8.29f, 17.0f, 8.63f, 16.98f, 9.0f, 16.94f)
        t.lineTo(9.0f, 14.93f)
        t.cubicTo(8.68f, 14.97f, 8.34f, 15.0f, 8.0f, 15.0f)
        t.cubicTo(6.06f, 15.0f, 4.29f, 14.3f, 4.0f, 13.9f)
        t.lineTo(4.0f, 13.22f)
        t.cubicTo(5.32f, 13.78f, 6.99f, 14.0f, 8.0f, 14.0f)
        t.cubicTo(8.29f, 14.0f, 8.63f, 13.98f, 9.0f, 13.94f)
        t.lineTo(9.0f, 11.93f)
        t.cubicTo(8.68f, 11.97f, 8.34f, 12.0f, 8.0f, 12.0f)
        t.cubicTo(6.06f, 12.0f, 4.29f, 11.3f, 4.0f, 10.9f)
        t.lineTo(4.0f, 10.22f)
        t.cubicTo(5.32f, 10.78f, 6.99f, 11.0f, 8.0f, 11.0f)
        t.cubicTo(8.29f, 11.0f, 8.63f, 10.98f, 9.0f, 10.94f)
        t.lineTo(9.0f, 8.94f)
        t.cubicTo(8.68f, 8.97f, 8.34f, 9.0f, 8.0f, 9.0f)
        t.cubicTo(6.06f, 9.0f, 4.29f, 8.3f, 4.0f, 7.9f)
        t.lineTo(4.0f, 7.22f)
        t.cubicTo(5.32f, 7.78f, 6.99f, 8.0f, 8.0f, 8.0f)
        t.cubicTo(8.29f, 8.0f, 8.63f, 7.98f, 9.0f, 7.94f)
        t.lineTo(9.0f, 5.94f)
        t.cubicTo(8.68f, 5.97f, 8.34f, 6.0f, 8.0f, 6.0f)
        t.cubicTo(6.22f, 6.0f, 4.56f, 5.41f, 4.09f, 5.0f)

        t.transform(m)
        c.drawPath(t, p)
        c.drawPath(t, ps)
        c.restore()
        r(1, 3, 4, 5, 2)
        p.color = Color.parseColor("#757575")
        c.save()
        t.reset()
        t.moveTo(16.0f, 7.0f)
        t.cubicTo(14.12f, 7.0f, 10.0f, 7.76f, 10.0f, 10.0f)
        t.lineTo(10.0f, 19.0f)
        t.cubicTo(10.0f, 21.25f, 14.12f, 22.0f, 16.0f, 22.0f)
        t.cubicTo(17.88f, 22.0f, 22.0f, 21.25f, 22.0f, 19.0f)
        t.lineTo(22.0f, 10.0f)
        t.cubicTo(22.0f, 7.76f, 17.88f, 7.0f, 16.0f, 7.0f)
        t.moveTo(20.0f, 12.9f)
        t.cubicTo(19.71f, 13.3f, 17.94f, 14.0f, 16.0f, 14.0f)
        t.cubicTo(14.06f, 14.0f, 12.29f, 13.3f, 12.0f, 12.9f)
        t.lineTo(12.0f, 12.22f)
        t.cubicTo(13.32f, 12.78f, 14.98f, 13.0f, 16.0f, 13.0f)
        t.cubicTo(17.02f, 13.0f, 18.68f, 12.78f, 20.0f, 12.22f)
        t.lineTo(20.0f, 12.9f)
        t.moveTo(20.0f, 15.9f)
        t.cubicTo(19.71f, 16.3f, 17.94f, 17.0f, 16.0f, 17.0f)
        t.cubicTo(14.06f, 17.0f, 12.29f, 16.3f, 12.0f, 15.9f)
        t.lineTo(12.0f, 15.22f)
        t.cubicTo(13.32f, 15.78f, 14.98f, 16.0f, 16.0f, 16.0f)
        t.cubicTo(17.02f, 16.0f, 18.68f, 15.78f, 20.0f, 15.22f)
        t.lineTo(20.0f, 15.9f)
        t.moveTo(16.0f, 9.0f)
        t.cubicTo(17.79f, 9.0f, 19.44f, 9.59f, 19.91f, 10.0f)
        t.cubicTo(19.44f, 10.41f, 17.78f, 11.0f, 16.0f, 11.0f)
        t.cubicTo(14.22f, 11.0f, 12.56f, 10.41f, 12.09f, 10.0f)
        t.cubicTo(12.56f, 9.6f, 14.21f, 9.0f, 16.0f, 9.0f)
        t.moveTo(16.0f, 20.0f)
        t.cubicTo(14.08f, 20.0f, 12.32f, 19.32f, 12.0f, 18.91f)
        t.lineTo(12.0f, 18.22f)
        t.cubicTo(13.32f, 18.78f, 14.98f, 19.0f, 16.0f, 19.0f)
        t.cubicTo(17.02f, 19.0f, 18.68f, 18.78f, 20.0f, 18.22f)
        t.lineTo(20.0f, 18.91f)
        t.cubicTo(19.68f, 19.32f, 17.92f, 20.0f, 16.0f, 20.0f)

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