package com.mgtriffid.games.cotta.showcase.components

import com.mgtriffid.games.cotta.core.entities.MutableComponent
import com.mgtriffid.games.cotta.core.entities.PlayerId

interface ControllableComponent : MutableComponent<ControllableComponent> {
    var direction: Byte
    var isShooting: Boolean
    val playerId: PlayerId
}
