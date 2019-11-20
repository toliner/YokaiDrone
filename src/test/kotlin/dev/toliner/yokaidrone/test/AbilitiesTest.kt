/*
 * Copyright (c) 2019. toliner.
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package dev.toliner.yokaidrone.test

import dev.toliner.yokaidrone.ability.CommandHandlingAbility
import dev.toliner.yokaidrone.api.Yokai
import dev.toliner.yokaidrone.api.gainAbility
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.junit5.MockKExtension
import net.dv8tion.jda.api.JDABuilder
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockKExtension::class)
class AbilitiesTest {
    @RelaxedMockK
    lateinit var jdaBuilder: JDABuilder

    @RelaxedMockK
    lateinit var yokai: Yokai

    @Test
    fun `gain abilities`() {
        yokai.gainAbility(jdaBuilder, CommandHandlingAbility) {
            onGuildMessageReceived { _, _, _, _ -> }
            onPrivateMessageReceived { _, _, _, _ -> }
        }
    }
}