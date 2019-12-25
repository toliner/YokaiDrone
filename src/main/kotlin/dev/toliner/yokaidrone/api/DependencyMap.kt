/*
 * Copyright (c) 2019. toliner.
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package dev.toliner.yokaidrone.api

class DependencyMap {
    internal val required = mutableListOf<Ability<*>>()
    internal val optional = mutableListOf<Ability<*>>()

    fun required(ability: Ability<*>) {
        required += ability
    }

    fun optional(ability: Ability<*>) {
        optional += ability
    }
}