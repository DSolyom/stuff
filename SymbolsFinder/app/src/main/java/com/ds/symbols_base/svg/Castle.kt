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

class Castle: Svg {
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
        t.moveTo(23.0f, 14.0f)
        t.lineTo(16.82f, 14.0f)
        t.lineTo(16.22f, 10.99f)
        t.cubicTo(17.22f, 10.88f, 18.0f, 10.03f, 18.0f, 9.0f)
        t.lineTo(18.0f, 3.0f)
        t.lineTo(16.0f, 3.0f)
        t.lineTo(16.0f, 5.0f)
        t.lineTo(13.0f, 5.0f)
        t.lineTo(13.0f, 3.0f)
        t.lineTo(11.0f, 3.0f)
        t.lineTo(11.0f, 5.0f)
        t.lineTo(8.0f, 5.0f)
        t.lineTo(8.0f, 3.0f)
        t.lineTo(6.0f, 3.0f)
        t.lineTo(6.0f, 9.0f)
        t.cubicTo(6.0f, 10.03f, 6.78f, 10.88f, 7.78f, 10.99f)
        t.lineTo(7.18f, 14.0f)
        t.lineTo(1.0f, 14.0f)
        t.lineTo(1.0f, 16.0f)
        t.lineTo(2.0f, 16.0f)
        t.lineTo(2.0f, 21.0f)
        t.cubicTo(2.0f, 21.55f, 2.45f, 22.0f, 3.0f, 22.0f)
        t.lineTo(10.0f, 22.0f)
        t.cubicTo(10.55f, 22.0f, 11.0f, 21.55f, 11.0f, 21.0f)
        t.lineTo(11.0f, 20.0f)
        t.cubicTo(11.0f, 19.45f, 11.45f, 19.0f, 12.0f, 19.0f)
        t.cubicTo(12.56f, 19.0f, 13.0f, 19.46f, 13.0f, 20.01f)
        t.lineTo(13.0f, 21.0f)
        t.cubicTo(13.0f, 21.55f, 13.45f, 22.0f, 14.0f, 22.0f)
        t.lineTo(21.0f, 22.0f)
        t.cubicTo(21.55f, 22.0f, 22.0f, 21.55f, 22.0f, 21.0f)
        t.lineTo(22.0f, 16.0f)
        t.lineTo(23.0f, 16.0f)
        t.lineTo(23.0f, 14.0f)
        t.moveTo(9.77f, 9.37f)
        t.cubicTo(9.58f, 9.14f, 9.3f, 9.0f, 9.0f, 9.0f)
        t.lineTo(8.0f, 9.0f)
        t.lineTo(8.0f, 7.0f)
        t.lineTo(16.0f, 7.0f)
        t.lineTo(16.0f, 9.0f)
        t.lineTo(15.0f, 9.0f)
        t.cubicTo(14.7f, 9.0f, 14.42f, 9.14f, 14.23f, 9.37f)
        t.cubicTo(14.04f, 9.6f, 13.96f, 9.9f, 14.02f, 10.2f)
        t.lineTo(14.78f, 14.0f)
        t.lineTo(9.22f, 14.0f)
        t.lineTo(9.98f, 10.2f)
        t.cubicTo(10.04f, 9.9f, 9.96f, 9.6f, 9.77f, 9.37f)
        t.moveTo(20.0f, 20.0f)
        t.lineTo(15.0f, 20.0f)
        t.cubicTo(15.0f, 18.35f, 13.66f, 17.0f, 12.0f, 17.0f)
        t.cubicTo(10.35f, 17.0f, 9.0f, 18.35f, 9.0f, 20.0f)
        t.lineTo(4.0f, 20.0f)
        t.lineTo(4.0f, 16.0f)
        t.lineTo(20.0f, 16.0f)
        t.lineTo(20.0f, 20.0f)

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