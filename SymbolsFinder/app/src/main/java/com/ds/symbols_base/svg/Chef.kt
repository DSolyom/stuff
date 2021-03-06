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

class Chef: Svg {
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
        t.moveTo(18.0f, 4.0f)
        t.cubicTo(17.38f, 4.0f, 16.79f, 4.14f, 16.25f, 4.4f)
        t.cubicTo(15.36f, 2.94f, 13.76f, 2.0f, 12.0f, 2.0f)
        t.cubicTo(10.24f, 2.0f, 8.64f, 2.94f, 7.75f, 4.4f)
        t.cubicTo(7.21f, 4.14f, 6.62f, 4.0f, 6.0f, 4.0f)
        t.cubicTo(3.79f, 4.0f, 2.0f, 5.79f, 2.0f, 8.0f)
        t.cubicTo(2.0f, 9.86f, 3.28f, 11.43f, 5.0f, 11.87f)
        t.lineTo(5.0f, 21.0f)
        t.cubicTo(5.0f, 21.55f, 5.45f, 22.0f, 6.0f, 22.0f)
        t.lineTo(18.0f, 22.0f)
        t.cubicTo(18.55f, 22.0f, 19.0f, 21.55f, 19.0f, 21.0f)
        t.lineTo(19.0f, 11.87f)
        t.cubicTo(20.72f, 11.43f, 22.0f, 9.86f, 22.0f, 8.0f)
        t.cubicTo(22.0f, 5.79f, 20.2f, 4.0f, 18.0f, 4.0f)
        t.moveTo(7.0f, 20.0f)
        t.lineTo(7.0f, 19.0f)
        t.lineTo(17.0f, 19.0f)
        t.lineTo(17.0f, 20.0f)
        t.lineTo(7.0f, 20.0f)
        t.moveTo(18.0f, 10.0f)
        t.cubicTo(17.45f, 10.0f, 17.0f, 10.45f, 17.0f, 11.0f)
        t.lineTo(17.0f, 17.0f)
        t.lineTo(16.0f, 17.0f)
        t.lineTo(16.0f, 14.0f)
        t.lineTo(14.0f, 14.0f)
        t.lineTo(14.0f, 17.0f)
        t.lineTo(13.0f, 17.0f)
        t.lineTo(13.0f, 13.0f)
        t.lineTo(11.0f, 13.0f)
        t.lineTo(11.0f, 17.0f)
        t.lineTo(10.0f, 17.0f)
        t.lineTo(10.0f, 14.0f)
        t.lineTo(8.0f, 14.0f)
        t.lineTo(8.0f, 17.0f)
        t.lineTo(7.0f, 17.0f)
        t.lineTo(7.0f, 11.0f)
        t.cubicTo(7.0f, 10.45f, 6.55f, 10.0f, 6.0f, 10.0f)
        t.cubicTo(4.9f, 10.0f, 4.0f, 9.1f, 4.0f, 8.0f)
        t.cubicTo(4.0f, 6.9f, 4.9f, 6.0f, 6.0f, 6.0f)
        t.cubicTo(6.54f, 6.0f, 7.06f, 6.22f, 7.44f, 6.62f)
        t.cubicTo(7.69f, 6.88f, 8.06f, 6.99f, 8.4f, 6.9f)
        t.cubicTo(8.75f, 6.81f, 9.03f, 6.54f, 9.13f, 6.2f)
        t.cubicTo(9.49f, 4.9f, 10.67f, 4.0f, 12.0f, 4.0f)
        t.cubicTo(13.33f, 4.0f, 14.51f, 4.9f, 14.87f, 6.2f)
        t.cubicTo(14.97f, 6.54f, 15.25f, 6.81f, 15.59f, 6.9f)
        t.cubicTo(15.94f, 6.99f, 16.31f, 6.88f, 16.56f, 6.62f)
        t.cubicTo(16.94f, 6.22f, 17.45f, 6.0f, 18.0f, 6.0f)
        t.cubicTo(19.1f, 6.0f, 20.0f, 6.9f, 20.0f, 8.0f)
        t.cubicTo(20.0f, 9.1f, 19.1f, 10.0f, 18.0f, 10.0f)

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