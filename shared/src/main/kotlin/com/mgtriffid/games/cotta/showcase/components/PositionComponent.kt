package com.mgtriffid.games.cotta.showcase.components

import com.mgtriffid.games.cotta.core.annotations.Interpolated
import com.mgtriffid.games.cotta.core.entities.MutableComponent

interface PositionComponent : MutableComponent<PositionComponent> {
    @Interpolated var x: Float
    @Interpolated var y: Float
    var orientation: Byte
}

object Orientation {
    const val UP: Byte = 0
    const val RIGHT: Byte = 1
    const val DOWN: Byte = 2
    const val LEFT: Byte = 3
}
