package com.mgtriffid.games.cotta.showcase.systems

import com.mgtriffid.games.cotta.core.annotations.Predicted
import com.mgtriffid.games.cotta.core.entities.Entity
import com.mgtriffid.games.cotta.core.simulation.invokers.context.EntityProcessingContext
import com.mgtriffid.games.cotta.core.systems.EntityProcessingSystem
import com.mgtriffid.games.cotta.showcase.WalkingDirections
import com.mgtriffid.games.cotta.showcase.components.ControllableComponent
import com.mgtriffid.games.cotta.showcase.components.Orientation
import com.mgtriffid.games.cotta.showcase.components.PositionComponent
import com.mgtriffid.games.cotta.showcase.components.VelocityComponent

@Predicted
class MovementControlSystem : EntityProcessingSystem {
    override fun process(e: Entity, ctx: EntityProcessingContext) {
        if (e.hasComponent(ControllableComponent::class) &&
            e.hasComponent(VelocityComponent::class) &&
            e.hasComponent(PositionComponent::class)
        ) {
            val controllable = e.getComponent(ControllableComponent::class)
            val velocity = e.getComponent(VelocityComponent::class)
            velocity.x = when (controllable.direction) {
                WalkingDirections.LEFT -> -300f
                WalkingDirections.RIGHT -> 300f
                else -> 0f
            }
            velocity.y = when (controllable.direction) {
                WalkingDirections.UP -> 300f
                WalkingDirections.DOWN -> -300f
                else -> 0f
            }
            val position = e.getComponent(PositionComponent::class)
            position.orientation = when (controllable.direction) {
                WalkingDirections.UP -> Orientation.UP
                WalkingDirections.RIGHT -> Orientation.RIGHT
                WalkingDirections.DOWN -> Orientation.DOWN
                WalkingDirections.LEFT -> Orientation.LEFT
                else -> position.orientation
            }
        }
    }
}
