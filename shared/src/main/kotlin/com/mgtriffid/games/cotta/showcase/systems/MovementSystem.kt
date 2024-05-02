package com.mgtriffid.games.cotta.showcase.systems

import com.mgtriffid.games.cotta.core.annotations.Predicted
import com.mgtriffid.games.cotta.core.entities.Entity
import com.mgtriffid.games.cotta.core.simulation.invokers.context.EntityProcessingContext
import com.mgtriffid.games.cotta.core.systems.EntityProcessingSystem
import com.mgtriffid.games.cotta.showcase.WalkingDirections
import com.mgtriffid.games.cotta.showcase.components.ControllableComponent
import com.mgtriffid.games.cotta.showcase.components.PositionComponent

//@Predicted
class MovementSystem : EntityProcessingSystem {
    override fun process(e: Entity, ctx: EntityProcessingContext) {
        if (e.hasComponent(ControllableComponent::class) &&
            e.hasComponent(PositionComponent::class)
        ) {
            val controllable = e.getComponent(ControllableComponent::class)
            val position = e.getComponent(PositionComponent::class)
            val velX = when (controllable.direction) {
                WalkingDirections.LEFT -> -300f
                WalkingDirections.RIGHT -> 300f
                else -> 0f
            }
            val velY = when (controllable.direction) {
                WalkingDirections.UP -> 300f
                WalkingDirections.DOWN -> -300f
                else -> 0f
            }
            position.x += velX * ctx.clock().delta()
            position.y += velY * ctx.clock().delta()
        }
    }
}
