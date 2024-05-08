package com.mgtriffid.games.cotta.showcase.components

import com.mgtriffid.games.cotta.core.entities.MutableComponent

interface VelocityComponent : MutableComponent<VelocityComponent> {
    var x: Float
    var y: Float
}
