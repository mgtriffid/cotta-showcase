package com.mgtriffid.games.cotta.showcase

import com.mgtriffid.games.cotta.core.input.PlayerInput

data class ShowcasePlayerInput(
    val walkingDirection: Byte,
    val isShooting: Boolean
) : PlayerInput
