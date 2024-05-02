package com.mgtriffid.games.cotta.showcase

import com.mgtriffid.games.cotta.core.PlayersHandler
import com.mgtriffid.games.cotta.core.entities.Entities
import com.mgtriffid.games.cotta.core.entities.Entity
import com.mgtriffid.games.cotta.core.entities.PlayerId
import com.mgtriffid.games.cotta.showcase.components.createControllableComponent
import com.mgtriffid.games.cotta.showcase.components.createDrawableComponent
import com.mgtriffid.games.cotta.showcase.components.createPositionComponent

class ShowcasePlayersHandler : PlayersHandler {
    override fun onEnterGame(playerId: PlayerId, entities: Entities) {
        entities.create(ownedBy = Entity.OwnedBy.Player(playerId)).apply {
            addComponent(createControllableComponent(0, playerId))
            addComponent(createDrawableComponent())
            addComponent(createPositionComponent(120f, 120f))
        }
    }

    override fun onLeaveGame(playerId: PlayerId, entities: Entities) {
        val entityId = entities.all().find { it.ownedBy == Entity.OwnedBy.Player(playerId) }?.id
        if (entityId != null) {
            entities.remove(entityId)
        }
    }
}
