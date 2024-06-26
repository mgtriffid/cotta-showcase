package com.mgtriffid.games.cotta.showcase

import com.mgtriffid.games.cotta.core.entities.Component
import com.mgtriffid.games.cotta.showcase.components.PositionComponent
import kotlin.reflect.KClass

fun getDrawableComponentClasses(): List<KClass<Component<*>>> = listOf(
    position as KClass<Component<*>>
)

val position = PositionComponent::class
