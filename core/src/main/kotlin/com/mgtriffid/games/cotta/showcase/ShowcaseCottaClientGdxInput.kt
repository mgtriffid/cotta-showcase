package com.mgtriffid.games.cotta.showcase

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.mgtriffid.games.cotta.gdx.CottaClientGdxInput

class ShowcaseCottaClientGdxInput : CottaClientGdxInput {
    private val storage = Storage()

    override fun accumulate() {
        with(storage) {
            upPressed = upPressed || Gdx.input.isKeyPressed(Input.Keys.W)
            downPressed = downPressed || Gdx.input.isKeyPressed(Input.Keys.S)
            leftPressed = leftPressed || Gdx.input.isKeyPressed(Input.Keys.A)
            rightPressed = rightPressed || Gdx.input.isKeyPressed(Input.Keys.D)
            shootPressed = shootPressed || Gdx.input.isKeyPressed(Input.Keys.SPACE)
        }
    }

    override fun input(): ShowcasePlayerInput {
        return ShowcasePlayerInput(
            walkingDirection = when {
                storage.upPressed && !storage.downPressed -> WalkingDirections.UP
                !storage.upPressed && storage.downPressed -> WalkingDirections.DOWN
                storage.leftPressed && !storage.rightPressed -> WalkingDirections.LEFT
                !storage.leftPressed && storage.rightPressed -> WalkingDirections.RIGHT
                else -> WalkingDirections.IDLE
            },
            isShooting = storage.shootPressed
        ).also { clear() }
    }

    private fun clear() {
        storage.upPressed = false
        storage.downPressed = false
        storage.leftPressed = false
        storage.rightPressed = false
        storage.shootPressed = false
    }

    private class Storage {
        var upPressed: Boolean = false
        var downPressed: Boolean = false
        var leftPressed: Boolean = false
        var rightPressed: Boolean = false
        var shootPressed: Boolean = false
    }
}
