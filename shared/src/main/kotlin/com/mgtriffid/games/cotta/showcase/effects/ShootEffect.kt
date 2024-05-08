package com.mgtriffid.games.cotta.showcase.effects

import com.mgtriffid.games.cotta.core.effects.CottaEffect
import com.mgtriffid.games.cotta.core.entities.id.EntityId

interface ShootEffect : CottaEffect {
    val shooterId: EntityId
}
