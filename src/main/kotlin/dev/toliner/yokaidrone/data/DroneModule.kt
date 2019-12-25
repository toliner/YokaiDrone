/*
 * Copyright (c) 2019. toliner.
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package dev.toliner.yokaidrone.data

import net.dv8tion.jda.api.JDABuilder

data class DroneModule(
    val jdaBuilder: JDABuilder,
    val token: String
)