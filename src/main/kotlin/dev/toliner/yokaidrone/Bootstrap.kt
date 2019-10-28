/*
 * Copyright (c) 2019. toliner.
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package dev.toliner.yokaidrone

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.options.option
import dev.toliner.yokaidrone.api.Yokai
import net.dv8tion.jda.api.JDABuilder

fun main(args: Array<String>) {
    Bootstrap().main(args)
}

private class Bootstrap : CliktCommand() {

    private val token by argument(help = "Access token for your discord bot")
    private val yokais by option(help = "List of yokai class canonical names, separated by ':'")

    override fun run() {
        val builder = JDABuilder(token)
        yokais?.split(':')?.forEach {
            runCatching {
                ClassLoader.getSystemClassLoader().loadClass(it).newInstance() as Yokai
            }.onFailure {
                println("$it is not valid canonical name for the yokai class")
            }.onSuccess {
                it.init(builder)
            }
        }
    }
}