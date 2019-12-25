/*
 * Copyright (c) 2019. toliner.
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package dev.toliner.yokaidrone.test

import dev.toliner.yokaidrone.ability.commandHandling
import dev.toliner.yokaidrone.api.Abilities
import dev.toliner.yokaidrone.api.Drone
import dev.toliner.yokaidrone.api.Yokai
import dev.toliner.yokaidrone.api.gainAbility
import dev.toliner.yokaidrone.data.YokaiDroneContext
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockKExtension::class)
class AbilitiesTest {
    @RelaxedMockK
    lateinit var yokai: Yokai

    @RelaxedMockK
    lateinit var context: YokaiDroneContext.Default

    @BeforeAll
    fun `setup drone`() {
        Drone.setup(context)
    }

    @Test
    fun `gain abilities`() {
        yokai.gainAbility(Abilities.commandHandling) {
            onGuildMessageReceived { _, _, _, _ -> }
            onPrivateMessageReceived { _, _, _, _ -> }
        }
    }
}