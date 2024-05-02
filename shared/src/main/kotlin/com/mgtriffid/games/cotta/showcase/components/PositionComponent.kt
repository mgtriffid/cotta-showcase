package com.mgtriffid.games.cotta.showcase.components

import com.mgtriffid.games.cotta.core.entities.MutableComponent

interface PositionComponent : MutableComponent<PositionComponent> {
    var x: Float
    var y: Float
}
