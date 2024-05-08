package com.mgtriffid.games.cotta.showcase.systems

import com.mgtriffid.games.cotta.core.entities.Entity
import com.mgtriffid.games.cotta.core.simulation.invokers.context.EntityProcessingContext
import com.mgtriffid.games.cotta.core.systems.EntityProcessingSystem
import com.mgtriffid.games.cotta.showcase.components.ControllableComponent
import com.mgtriffid.games.cotta.showcase.components.PositionComponent
import com.mgtriffid.games.cotta.showcase.effects.createShootEffect

class ShootingSystem : EntityProcessingSystem {
    override fun process(e: Entity, ctx: EntityProcessingContext) {
        if (e.hasComponent(ControllableComponent::class) &&
            e.hasComponent(PositionComponent::class)
        ) {
            val controllable = e.getComponent(ControllableComponent::class)
            if (controllable.isShooting) {
                ctx.fire(createShootEffect(e.id))
            }
        }
    }
}
