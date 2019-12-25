/*
 * Copyright (c) 2019. toliner.
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package dev.toliner.yokaidrone.api

import dev.toliner.yokaidrone.data.DroneModule
import dev.toliner.yokaidrone.data.YokaiDroneContext
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import space.traversal.kapsule.Injects
import space.traversal.kapsule.inject
import space.traversal.kapsule.required
import kotlin.reflect.KClass
import kotlin.reflect.full.declaredMemberExtensionProperties
import kotlin.reflect.full.isSuperclassOf

/**
 * Controller of all Yokai and their abilities.
 */
object Drone : Injects<DroneModule> {
    private val logger: Logger = LoggerFactory.getLogger(Drone::class.java)
    private val yokaiSet = mutableSetOf<Yokai>()
    private val yokaiAbilities = mutableMapOf<Yokai, MutableSet<Pair<Ability<*>, AbilityConfig>>>()
    private val token by required { token }
    private val builder by required { jdaBuilder }

    fun registerYokai(yokai: Yokai) {
        yokaiSet += yokai
    }

    fun <T : AbilityConfig> abilityGainedByYokai(yokai: Yokai, ability: Ability<T>, config: T) {
        if (!yokaiAbilities.containsKey(yokai)) {
            yokaiAbilities[yokai] = mutableSetOf()
        }

        yokaiAbilities[yokai]!! += ability to config
    }

    fun setup(context: YokaiDroneContext) {

        inject(context.droneModule)

        builder.setToken(token)

        yokaiSet.forEach { it.init() }

        // Ability dependency handling
        val abilityDependency = Abilities::class.declaredMemberExtensionProperties
            .map {
                it.returnType.classifier as KClass<*>
            }.filter {
                Ability::class.isSuperclassOf(it)
            }.map {
                it.objectInstance as Ability<*>
            }.associateWith { ability ->
                ability.run {
                    DependencyMap().apply {
                        dependencies()
                    }
                }
            }

        yokaiAbilities.forEach { (yokai, set) ->
            val gainedAbilities = mutableSetOf<Ability<*>>()
            val abilityConfigMap = set.toMap()

            set.map { it.first }.forEach {
                gainedAbilities += it
                if (abilityDependency.containsKey(it)) {
                    gainedAbilities += abilityDependency.getValue(it).required
                }
            }

            gainedAbilities.forEach {
                val config = abilityConfigMap[it] ?: it.getDefaultConfig()

                @Suppress("UNCHECKED_CAST")
                (it as Ability<AbilityConfig>).gainedByYokai(yokai, config, builder)
            }
        }

        logger.info("YokaiDrone is ready now, start booting.")
        builder.build().awaitReady()
    }


}