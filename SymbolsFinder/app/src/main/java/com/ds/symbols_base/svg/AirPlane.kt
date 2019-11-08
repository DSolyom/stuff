package com.ds.symbols_base.svg

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.ColorFilter
import android.graphics.Matrix
import android.graphics.Paint
import android.graphics.Path
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter

class AirPlane : Svg {
    private val p = Paint()
    private val ps = Paint()
    private val t = Path()
    private val m = Matrix()
    private var od: Float = 0.toFloat()
    private var cf: ColorFilter? = null

    override fun setColorTint(color: Int) {
        cf = PorterDuffColorFilter(color, PorterDuff.Mode.SRC_IN)
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
        t.moveTo(15.0f, 2.0f)
        t.lineTo(9.0f, 2.0f)
        t.lineTo(9.0f, 4.0f)
        t.lineTo(12.0f, 4.0f)
        t.lineTo(15.0f, 4.0f)
        t.lineTo(15.0f, 2.0f)

        t.transform(m)
        c.drawPath(t, p)
        c.drawPath(t, ps)
        c.restore()
        r(1, 3, 4, 5, 2)
        p.color = Color.parseColor("#757575")
        c.save()
        t.reset()
        t.moveTo(22.7f, 8.34f)
        t.cubicTo(22.26f, 7.51f, 21.4f, 7.0f, 20.46f, 7.0f)
        t.lineTo(15.0f, 7.0f)
        t.cubicTo(15.0f, 5.35f, 13.65f, 4.0f, 12.0f, 4.0f)
        t.cubicTo(10.38f, 4.0f, 9.06f, 5.3f, 9.01f, 7.0f)
        t.lineTo(3.54f, 7.0f)
        t.cubicTo(2.6f, 7.0f, 1.74f, 7.51f, 1.3f, 8.34f)
        t.cubicTo(0.86f, 9.17f, 0.91f, 10.16f, 1.43f, 10.94f)
        t.cubicTo(1.82f, 11.54f, 2.42f, 11.97f, 3.14f, 12.18f)
        t.lineTo(9.67f, 13.71f)
        t.lineTo(9.89f, 16.0f)
        t.lineTo(9.0f, 16.0f)
        t.cubicTo(7.35f, 16.0f, 6.0f, 17.35f, 6.0f, 19.0f)
        t.lineTo(6.0f, 20.0f)
        t.cubicTo(6.0f, 20.55f, 6.45f, 21.0f, 7.0f, 21.0f)
        t.lineTo(17.0f, 21.0f)
        t.cubicTo(17.55f, 21.0f, 18.0f, 20.55f, 18.0f, 20.0f)
        t.lineTo(18.0f, 19.0f)
        t.cubicTo(18.0f, 17.35f, 16.65f, 16.0f, 15.0f, 16.0f)
        t.lineTo(14.1f, 16.0f)
        t.lineTo(14.33f, 13.71f)
        t.lineTo(20.9f, 12.16f)
        t.cubicTo(21.58f, 11.97f, 22.18f, 11.54f, 22.57f, 10.94f)
        t.cubicTo(23.09f, 10.16f, 23.14f, 9.16f, 22.7f, 8.34f)
        t.moveTo(3.65f, 10.24f)
        t.cubicTo(3.42f, 10.18f, 3.22f, 10.03f, 3.09f, 9.83f)
        t.cubicTo(2.98f, 9.67f, 2.97f, 9.46f, 3.06f, 9.28f)
        t.cubicTo(3.16f, 9.11f, 3.34f, 9.0f, 3.54f, 9.0f)
        t.lineTo(9.2f, 9.0f)
        t.lineTo(9.46f, 11.61f)
        t.lineTo(3.65f, 10.24f)
        t.moveTo(15.0f, 18.0f)
        t.cubicTo(15.55f, 18.0f, 16.0f, 18.45f, 16.0f, 19.0f)
        t.lineTo(8.0f, 19.0f)
        t.cubicTo(8.0f, 18.45f, 8.45f, 18.0f, 9.0f, 18.0f)
        t.lineTo(15.0f, 18.0f)
        t.moveTo(12.0f, 16.0f)
        t.lineTo(11.9f, 16.0f)
        t.lineTo(11.0f, 7.0f)
        t.cubicTo(11.0f, 6.45f, 11.45f, 6.0f, 12.0f, 6.0f)
        t.cubicTo(12.55f, 6.0f, 13.0f, 6.45f, 13.0f, 6.9f)
        t.lineTo(12.09f, 16.0f)
        t.lineTo(12.0f, 16.0f)
        t.moveTo(20.91f, 9.83f)
        t.cubicTo(20.78f, 10.03f, 20.58f, 10.18f, 20.4f, 10.23f)
        t.lineTo(14.54f, 11.61f)
        t.lineTo(14.8f, 9.0f)
        t.lineTo(20.46f, 9.0f)
        t.cubicTo(20.66f, 9.0f, 20.84f, 9.11f, 20.94f, 9.28f)
        t.cubicTo(21.03f, 9.46f, 21.02f, 9.67f, 20.91f, 9.83f)

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