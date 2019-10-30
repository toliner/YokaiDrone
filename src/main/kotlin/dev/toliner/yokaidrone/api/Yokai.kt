/*
 * Copyright (c) 2019. toliner.
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package dev.toliner.yokaidrone.api

import net.dv8tion.jda.api.JDABuilder

/**
 * Interface for Yokai, which is one set of bot functions.
 * The first thing you should do when you build bot is choose or implement Yokai.
 * Yokai must be specified by command-line argument, then all specified Yokai is loaded by bootstrap.
 * Each Yokai can have some [Ability].
 * You can gain and configure [Ability]s by overriding [init] method.
 * **All implementation must have non-parameter constructor.**
 *
 * @author toliner
 */
interface Yokai {
    /**
     * This method is called by bootstrap at first.
     * You can configure all about [Yokai], including [Ability]s.
     * If this method is not called, the [Yokai] is not loaded.
     *
     * @param jdaBuilder [JDABuilder] instance to pass to [Ability]
     */
    fun init(jdaBuilder: JDABuilder)
}

/**
 * An helper function to gain ability.
 * By using this in [Yokai.init], Yokai can gain and configure [Ability]s.
 *
 * @param jdaBuilder [JDABuilder] instance to pass to [Ability]
 * @param ability An [Ability] to gain.
 * @param configure configure [AbilityConfig] in this lambda.
 */
inline fun <reified T : AbilityConfig> Yokai.gainAbility(
    jdaBuilder: JDABuilder,
    ability: Ability<T>,
    configure: T.() -> Unit
) {
    ability.gainedByYokai(this, T::class.java.newInstance().apply(configure), jdaBuilder)
}