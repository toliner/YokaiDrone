/*
 * Copyright (c) 2019. toliner.
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package dev.toliner.yokaidrone.ability

import dev.toliner.yokaidrone.api.Ability
import dev.toliner.yokaidrone.api.AbilityConfig
import dev.toliner.yokaidrone.api.Yokai
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent
import net.dv8tion.jda.api.events.message.priv.PrivateMessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

private typealias FuncOnGuildMessageReceived = (
    command: String,
    args: List<String>,
    event: GuildMessageReceivedEvent,
    config: CommandHandlingAbility.Config
) -> Unit

private typealias FuncOnPrivateMessageReceived = (
    command: String,
    args: List<String>,
    event: PrivateMessageReceivedEvent,
    config: CommandHandlingAbility.Config
) -> Unit

@Suppress("unused")
object CommandHandlingAbility : Ability<CommandHandlingAbility.Config> {

    var prefix: String = "!"

    override fun gainedByYokai(yokai: Yokai, config: Config, builder: JDABuilder) {
        builder.addEventListeners(CommandHandlingEventListener(config))
    }


    class Config : AbilityConfig {

        internal var funcGuildMessage: FuncOnGuildMessageReceived? = null

        internal var funcPrivateMessage: FuncOnPrivateMessageReceived? = null

        @Suppress("unused")
        fun onGuildMessageReceived(action: FuncOnGuildMessageReceived) {
            funcGuildMessage = action
        }

        @Suppress("unused")
        fun onPrivateMessageReceived(action: FuncOnPrivateMessageReceived) {
            funcPrivateMessage = action
        }
    }

    private class CommandHandlingEventListener(val config: Config) : ListenerAdapter() {
        override fun onGuildMessageReceived(event: GuildMessageReceivedEvent) {
            val message = event.message.contentRaw
            val split = message.split(" ")
            if (message.startsWith(prefix)) {
                config.funcGuildMessage?.invoke(split[0].removePrefix(prefix), split.drop(1), event, config)
            }
        }

        override fun onPrivateMessageReceived(event: PrivateMessageReceivedEvent) {
            val message = event.message.contentRaw
            val split = message.split(" ")
            if (message.startsWith(prefix)) {
                config.funcPrivateMessage?.invoke(split[0].removePrefix(prefix), split.drop(1), event, config)
            }
        }
    }
}