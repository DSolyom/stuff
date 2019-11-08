package com.ds.balloons.vm

class Balloon(val color: Int, val isTarget: Boolean) {

    /**
     * X coordinate in [0, 1) - representing the balloon horizontal place in available space.
     */
    var x: Double = 0.5 // Math.random()

    /**
     * Y coordinate in [0, 1) - representing the balloon vertical place in available space.
     */
    var y: Double = Math.random()

    /**
     * Is this balloon selected?
     */
    var isSelected: Boolean = false
}
