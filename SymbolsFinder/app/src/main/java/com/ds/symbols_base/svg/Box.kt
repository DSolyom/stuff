package com.ds.symbols_base.svg

import android.graphics.*

class Box : Svg {
    private val p = Paint()
    private val ps = Paint()
    private val t = Path()
    private val m = Matrix()
    private var od: Float = 0.toFloat()
    internal var cf: ColorFilter? = null

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
        r(1, 0, 4, 2)
        p.color = Color.argb(0, 0, 0, 0)
        c.restore()
        r(1, 0, 4, 2)
        p.color = Color.argb(0, 0, 0, 0)
        c.save()
        c.save()
        c.save()
        p.color = Color.parseColor("#757575")
        t.reset()
        t.moveTo(22.0f, 8.98f)
        t.cubicTo(21.99f, 8.86f, 21.97f, 8.75f, 21.93f, 8.64f)
        t.cubicTo(21.92f, 8.61f, 21.9f, 8.59f, 21.89f, 8.56f)
        t.cubicTo(21.87f, 8.52f, 21.86f, 8.48f, 21.83f, 8.45f)
        t.lineTo(17.83f, 2.45f)
        t.cubicTo(17.65f, 2.17f, 17.33f, 2.0f, 17.0f, 2.0f)
        t.lineTo(7.0f, 2.0f)
        t.cubicTo(6.67f, 2.0f, 6.35f, 2.17f, 6.17f, 2.44f)
        t.lineTo(2.17f, 8.45f)
        t.cubicTo(2.14f, 8.48f, 2.13f, 8.52f, 2.11f, 8.56f)
        t.cubicTo(2.1f, 8.59f, 2.08f, 8.62f, 2.07f, 8.64f)
        t.cubicTo(2.03f, 8.75f, 2.01f, 8.87f, 2.0f, 8.98f)
        t.cubicTo(2.0f, 8.99f, 2.0f, 8.99f, 2.0f, 9.0f)
        t.lineTo(2.0f, 21.0f)
        t.cubicTo(2.0f, 21.55f, 2.45f, 22.0f, 3.0f, 22.0f)
        t.lineTo(21.0f, 22.0f)
        t.cubicTo(21.55f, 22.0f, 22.0f, 21.55f, 22.0f, 21.0f)
        t.lineTo(22.0f, 9.0f)
        t.cubicTo(22.0f, 8.99f, 22.0f, 8.99f, 22.0f, 8.98f)
        t.moveTo(19.13f, 8.0f)
        t.lineTo(13.0f, 8.0f)
        t.lineTo(13.0f, 4.0f)
        t.lineTo(16.46f, 4.0f)
        t.lineTo(19.13f, 8.0f)
        t.moveTo(7.54f, 4.0f)
        t.lineTo(11.0f, 4.0f)
        t.lineTo(11.0f, 8.0f)
        t.lineTo(4.87f, 8.0f)
        t.lineTo(7.54f, 4.0f)
        t.moveTo(20.0f, 20.0f)
        t.lineTo(4.0f, 20.0f)
        t.lineTo(4.0f, 10.0f)
        t.lineTo(20.0f, 10.0f)
        t.lineTo(20.0f, 20.0f)

        t.transform(m)
        c.drawPath(t, p)
        c.drawPath(t, ps)
        c.restore()
        r(1, 0, 4, 2, 3)
        p.color = Color.parseColor("#757575")
        c.restore()
        r(1, 0, 4, 2, 3)
        p.color = Color.parseColor("#757575")
        c.restore()
        r(1, 0, 4, 2, 3)
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
                1 -> ps.color = Color.argb(0, 0, 0, 0)
                2 -> ps.strokeMiter = 4.0f * od
                3 -> p.color = Color.argb(0, 0, 0, 0)
                4 -> ps.strokeJoin = Paint.Join.MITER
            }
        }
    }
};