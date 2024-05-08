package com.mgtriffid.games.cotta.showcase.systems

import com.mgtriffid.games.cotta.core.simulation.invokers.context.EffectProcessingContext
import com.mgtriffid.games.cotta.core.systems.EffectsConsumerSystem
import com.mgtriffid.games.cotta.showcase.components.Orientation
import com.mgtriffid.games.cotta.showcase.components.PositionComponent
import com.mgtriffid.games.cotta.showcase.components.createPositionComponent
import com.mgtriffid.games.cotta.showcase.components.createVelocityComponent
import com.mgtriffid.games.cotta.showcase.effects.ShootEffect

class ShootEffectConsumer : EffectsConsumerSystem<ShootEffect> {
    override val effectType: Class<ShootEffect> = ShootEffect::class.java

    override fun handle(e: ShootEffect, ctx: EffectProcessingContext) {
        val shooter = ctx.entities().get(e.shooterId) ?: return
        val position = shooter.getComponent(PositionComponent::class)
        val bullet = ctx.createEntity()
        bullet.addComponent(createPositionComponent(position.x, position.y, position.orientation))
        val velX = when (position.orientation) {
            Orientation.RIGHT -> 800f
            Orientation.LEFT -> -800f
            else -> 0f
        }
        val velY = when (position.orientation) {
            Orientation.UP -> 800f
            Orientation.DOWN -> -800f
            else -> 0f
        }
        bullet.addComponent(createVelocityComponent(velX, velY))
    }
}
