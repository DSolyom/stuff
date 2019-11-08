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

class Ccamera: Svg {
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
        t.moveTo(21.92f, 3.62f)
        t.cubicTo(21.77f, 3.24f, 21.4f, 3.0f, 21.0f, 3.0f)
        t.lineTo(8.0f, 3.0f)
        t.cubicTo(5.24f, 3.0f, 3.0f, 5.24f, 3.0f, 8.0f)
        t.cubicTo(3.0f, 10.76f, 5.24f, 13.0f, 8.0f, 13.0f)
        t.lineTo(10.0f, 13.0f)
        t.lineTo(10.0f, 15.25f)
        t.lineTo(5.0f, 16.68f)
        t.lineTo(5.0f, 14.0f)
        t.lineTo(3.0f, 14.0f)
        t.lineTo(3.0f, 21.0f)
        t.lineTo(5.0f, 21.0f)
        t.lineTo(5.0f, 18.75f)
        t.lineTo(11.27f, 16.96f)
        t.cubicTo(11.7f, 16.84f, 12.0f, 16.45f, 12.0f, 16.0f)
        t.lineTo(12.0f, 13.0f)
        t.lineTo(16.0f, 13.0f)
        t.cubicTo(16.55f, 13.0f, 17.0f, 12.55f, 17.0f, 12.0f)
        t.lineTo(19.0f, 12.0f)
        t.cubicTo(19.55f, 12.0f, 20.0f, 11.55f, 20.0f, 11.0f)
        t.lineTo(20.0f, 8.0f)
        t.cubicTo(20.0f, 7.57f, 19.72f, 7.21f, 19.34f, 7.07f)
        t.lineTo(21.71f, 4.71f)
        t.cubicTo(21.99f, 4.42f, 22.08f, 3.99f, 21.92f, 3.62f)
        t.moveTo(15.29f, 8.29f)
        t.cubicTo(15.1f, 8.48f, 15.0f, 8.73f, 15.0f, 9.0f)
        t.lineTo(15.0f, 11.0f)
        t.lineTo(8.0f, 11.0f)
        t.cubicTo(6.35f, 11.0f, 5.0f, 9.65f, 5.0f, 8.0f)
        t.cubicTo(5.0f, 6.7f, 5.84f, 5.6f, 7.0f, 5.19f)
        t.lineTo(7.0f, 8.0f)
        t.lineTo(9.0f, 8.0f)
        t.lineTo(9.0f, 5.0f)
        t.lineTo(10.0f, 5.0f)
        t.lineTo(10.0f, 7.0f)
        t.lineTo(12.0f, 7.0f)
        t.lineTo(12.0f, 5.0f)
        t.lineTo(18.59f, 5.0f)
        t.lineTo(15.29f, 8.29f)
        t.moveTo(18.0f, 9.0f)
        t.lineTo(18.0f, 10.0f)
        t.lineTo(17.0f, 10.0f)
        t.lineTo(17.0f, 9.41f)
        t.lineTo(17.41f, 9.0f)
        t.lineTo(18.0f, 9.0f)

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