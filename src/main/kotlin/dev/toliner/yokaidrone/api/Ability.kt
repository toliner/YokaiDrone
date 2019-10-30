/*
 * Copyright (c) 2019. toliner.
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package dev.toliner.yokaidrone.api

import net.dv8tion.jda.api.JDABuilder

/**
 * Ability is a configurable function for [Yokai].
 * When the Ability is gained by [Yokai], it should configure [JDABuilder]
 * based on config to capture event from Discord.
 * **All implementation should be object-declaration**
 *
 * @author toliner
 */
interface Ability<T : AbilityConfig> {
    /**
     * Configure Ability and [builder] for [yokai] based on [config]
     *
     * @param yokai The [Yokai] which gain this ability.
     * @param config Configuration for this Ability.
     * @param builder [JDABuilder] instance to configure about discord event.
     */
    fun gainedByYokai(yokai: Yokai, config: T, builder: JDABuilder)
}