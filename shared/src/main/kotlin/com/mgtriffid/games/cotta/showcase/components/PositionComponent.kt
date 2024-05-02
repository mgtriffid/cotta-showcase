package com.mgtriffid.games.cotta.showcase.components

import com.mgtriffid.games.cotta.core.annotations.Interpolated
import com.mgtriffid.games.cotta.core.entities.MutableComponent

interface PositionComponent : MutableComponent<PositionComponent> {
    /*@Interpolated*/ var x: Float
    /*@Interpolated*/ var y: Float
}
