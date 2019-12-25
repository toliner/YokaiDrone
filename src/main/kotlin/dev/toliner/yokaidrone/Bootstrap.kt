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
import dev.toliner.yokaidrone.data.DroneModule
import dev.toliner.yokaidrone.data.YokaiDroneContext
import dev.toliner.yokaidrone.internal.Drone
import net.dv8tion.jda.api.JDABuilder
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    Bootstrap().main(args)
}

private class Bootstrap : CliktCommand() {

    companion object {
        val logger: Logger = LoggerFactory.getLogger(Bootstrap::class.java)
    }

    private val token by argument(help = "Access token for your discord bot")
    private val yokai by option(help = "List of yokai class canonical names, separated by ':'")

    override fun run() {
        logger.info("YokaiDrone start setting up")
        yokai?.split(':')?.forEach {
            runCatching {
                ClassLoader.getSystemClassLoader().loadClass(it).newInstance() as Yokai
            }.onFailure { e ->
                logger.error("$it is not valid canonical name for the yokai class")
                printStacktraceToDebug(e)
                exitProcess(1)
            }.onSuccess {
                Drone.registerYokai(it)
            }
        }
        Drone.setup(YokaiDroneContext.Default(DroneModule(JDABuilder(), token)))
    }

    private fun printStacktraceToDebug(e: Throwable) {
        logger.debug(e.toString())
        logger.debug(e.stackTrace.joinToString("\n"))
        if (e.cause != null) {
            printStacktraceToDebug(e.cause!!)
        }
    }
}