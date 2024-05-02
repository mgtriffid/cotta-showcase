package com.mgtriffid.games.cotta.showcase

import com.mgtriffid.games.cotta.core.effects.EffectBus
import com.mgtriffid.games.cotta.core.entities.Entities
import com.mgtriffid.games.cotta.core.entities.Entity
import com.mgtriffid.games.cotta.core.entities.PlayerId
import com.mgtriffid.games.cotta.core.input.InputProcessing
import com.mgtriffid.games.cotta.core.input.PlayerInput
import com.mgtriffid.games.cotta.showcase.components.ControllableComponent

class ShowcaseInputProcessing : InputProcessing {
    override fun processPlayerInput(
        playerId: PlayerId,
        input: PlayerInput,
        entities: Entities,
        effectBus: EffectBus
    ) {
        val character = getCharacter(entities, playerId) ?: return
        val controllable = character.getComponent(ControllableComponent::class)
        controllable.direction = (input as ShowcasePlayerInput).walkingDirection
    }

    private fun getCharacter(entities: Entities, playerId: PlayerId): Entity? {
        return entities.all().find { it.ownedBy == Entity.OwnedBy.Player(playerId) }
    }
}
