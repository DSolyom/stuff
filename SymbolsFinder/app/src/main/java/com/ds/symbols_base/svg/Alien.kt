package com.ds.symbols_base.svg

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.ColorFilter
import android.graphics.Matrix
import android.graphics.Paint
import android.graphics.Path
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter

class Alien : Svg {
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
        t.moveTo(21.41f, 5.42f)
        t.cubicTo(22.2f, 4.64f, 22.2f, 3.37f, 21.41f, 2.59f)
        t.cubicTo(20.63f, 1.81f, 19.37f, 1.81f, 18.59f, 2.59f)
        t.cubicTo(18.06f, 3.11f, 17.9f, 3.85f, 18.08f, 4.51f)
        t.lineTo(17.04f, 5.55f)
        t.cubicTo(15.6f, 4.57f, 13.87f, 4.0f, 12.0f, 4.0f)
        t.cubicTo(10.13f, 4.0f, 8.4f, 4.57f, 6.96f, 5.55f)
        t.lineTo(5.92f, 4.51f)
        t.cubicTo(6.1f, 3.85f, 5.94f, 3.11f, 5.41f, 2.59f)
        t.cubicTo(4.63f, 1.81f, 3.37f, 1.81f, 2.59f, 2.59f)
        t.cubicTo(1.81f, 3.37f, 1.8f, 4.63f, 2.59f, 5.42f)
        t.cubicTo(3.11f, 5.94f, 3.84f, 6.1f, 4.51f, 5.93f)
        t.lineTo(5.44f, 6.86f)
        t.cubicTo(3.93f, 8.47f, 3.0f, 10.63f, 3.0f, 13.0f)
        t.lineTo(3.0f, 19.5f)
        t.cubicTo(3.0f, 21.43f, 4.57f, 23.0f, 6.5f, 23.0f)
        t.cubicTo(7.75f, 23.0f, 8.77f, 22.43f, 9.38f, 21.45f)
        t.cubicTo(9.94f, 22.69f, 11.04f, 23.0f, 12.0f, 23.0f)
        t.cubicTo(12.95f, 23.0f, 14.04f, 22.7f, 14.61f, 21.49f)
        t.cubicTo(14.72f, 21.65f, 14.86f, 21.81f, 15.02f, 21.98f)
        t.cubicTo(15.69f, 22.64f, 16.56f, 23.0f, 17.5f, 23.0f)
        t.cubicTo(19.43f, 23.0f, 21.0f, 21.43f, 21.0f, 19.5f)
        t.lineTo(21.0f, 13.0f)
        t.cubicTo(21.0f, 10.63f, 20.07f, 8.47f, 18.56f, 6.86f)
        t.lineTo(19.49f, 5.93f)
        t.cubicTo(20.16f, 6.1f, 20.89f, 5.94f, 21.41f, 5.42f)
        t.moveTo(19.0f, 19.5f)
        t.cubicTo(19.0f, 20.33f, 18.33f, 21.0f, 17.5f, 21.0f)
        t.cubicTo(17.1f, 21.0f, 16.72f, 20.85f, 16.44f, 20.56f)
        t.cubicTo(16.09f, 20.21f, 16.02f, 19.96f, 16.0f, 19.42f)
        t.cubicTo(15.98f, 18.62f, 15.34f, 18.0f, 14.51f, 18.0f)
        t.cubicTo(13.69f, 18.0f, 13.01f, 18.67f, 13.0f, 19.48f)
        t.cubicTo(12.98f, 20.9f, 12.59f, 21.0f, 12.0f, 21.0f)
        t.cubicTo(11.41f, 21.0f, 11.02f, 20.89f, 11.0f, 19.44f)
        t.cubicTo(10.99f, 18.65f, 10.34f, 18.0f, 9.5f, 18.0f)
        t.cubicTo(8.71f, 18.0f, 8.06f, 18.6f, 7.98f, 19.39f)
        t.cubicTo(7.88f, 20.44f, 7.37f, 21.0f, 6.5f, 21.0f)
        t.cubicTo(5.67f, 21.0f, 5.0f, 20.33f, 5.0f, 19.5f)
        t.lineTo(5.0f, 13.0f)
        t.cubicTo(5.0f, 9.14f, 8.14f, 6.0f, 12.0f, 6.0f)
        t.cubicTo(15.86f, 6.0f, 19.0f, 9.14f, 19.0f, 13.0f)
        t.lineTo(19.0f, 19.5f)

        t.transform(m)
        c.drawPath(t, p)
        c.drawPath(t, ps)
        c.restore()
        r(1, 3, 4, 5, 2)
        p.color = Color.parseColor("#757575")
        c.save()
        t.reset()
        t.moveTo(12.0f, 8.0f)
        t.cubicTo(9.79f, 8.0f, 8.0f, 9.8f, 8.0f, 12.0f)
        t.cubicTo(8.0f, 14.21f, 9.79f, 16.0f, 12.0f, 16.0f)
        t.cubicTo(14.21f, 16.0f, 16.0f, 14.21f, 16.0f, 12.0f)
        t.cubicTo(16.0f, 9.8f, 14.21f, 8.0f, 12.0f, 8.0f)
        t.moveTo(12.0f, 14.0f)
        t.cubicTo(10.9f, 14.0f, 10.0f, 13.11f, 10.0f, 12.0f)
        t.cubicTo(10.0f, 10.9f, 10.9f, 10.0f, 12.0f, 10.0f)
        t.cubicTo(13.1f, 10.0f, 14.0f, 10.9f, 14.0f, 12.0f)
        t.cubicTo(14.0f, 13.1f, 13.1f, 14.0f, 12.0f, 14.0f)

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