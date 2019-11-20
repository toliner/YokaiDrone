/*
 * Copyright (c) 2019. toliner.
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package dev.toliner.yokaidrone.test

import java.security.Permission

object BanSystemExitForTest : SecurityManager() {

    private val systemSecManager = System.getSecurityManager()

    override fun checkPermission(permission: Permission) {
        if ("exitVM" == permission.name)
            println("System.exit[exitVM] is called")
        // super.checkPermission(permission)
    }

    override fun checkExit(status: Int) {
        throw ExitException(status)
    }

    override fun checkRead(file: String?) {

    }

    fun change() {
        // JVMを終了させない
        System.setSecurityManager(this)
    }

    fun reset() {
        System.setSecurityManager(systemSecManager)
    }

    class ExitException(state: Int) : SecurityException() {
        var state = 0

        init {
            this.state = state
        }
    }
}