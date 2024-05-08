package com.mgtriffid.games.cotta.showcase.systems

import com.mgtriffid.games.cotta.core.annotations.Predicted
import com.mgtriffid.games.cotta.core.entities.Entity
import com.mgtriffid.games.cotta.core.simulation.invokers.context.EntityProcessingContext
import com.mgtriffid.games.cotta.core.systems.EntityProcessingSystem
import com.mgtriffid.games.cotta.showcase.components.PositionComponent
import com.mgtriffid.games.cotta.showcase.components.VelocityComponent

@Predicted
class MovementSystem : EntityProcessingSystem {
    override fun process(e: Entity, ctx: EntityProcessingContext) {
        if (e.hasComponent(VelocityComponent::class) &&
            e.hasComponent(PositionComponent::class)
        ) {
            val velocity = e.getComponent(VelocityComponent::class)
            val position = e.getComponent(PositionComponent::class)
            position.x += velocity.x * ctx.clock().delta()
            position.y += velocity.y * ctx.clock().delta()
        }
    }
}
