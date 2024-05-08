package com.mgtriffid.games.cotta.showcase

import com.mgtriffid.games.cotta.core.CottaGame
import com.mgtriffid.games.cotta.core.annotations.Game
import com.mgtriffid.games.cotta.core.config.CottaConfig
import com.mgtriffid.games.cotta.core.input.InputProcessing
import com.mgtriffid.games.cotta.core.systems.CottaSystem
import com.mgtriffid.games.cotta.showcase.systems.MovementSystem
import com.mgtriffid.games.cotta.showcase.systems.ShootEffectConsumer
import com.mgtriffid.games.cotta.showcase.systems.ShootingSystem

@Game
class ShowcaseGame : CottaGame {
    override val config: CottaConfig = ShowcaseConfig()

    override val inputProcessing: InputProcessing = ShowcaseInputProcessing()

    override val playerInputKClass = ShowcasePlayerInput::class

    override val playersHandler = ShowcasePlayersHandler()

    override val systems: List<CottaSystem> = listOf(
        MovementSystem(),
        ShootingSystem(),
        ShootEffectConsumer()
    )
}
