/*
 * Copyright (c) 2019. toliner.
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package dev.toliner.yokaidrone.test

import dev.toliner.yokaidrone.main
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.slf4j.LoggerFactory
import kotlin.test.assertFails

@Suppress("RemoveSingleExpressionStringTemplate")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BootstrapTest {

    private val token = System.getenv("DISCORD_ACCESS_TOKEN")
    private val logger = LoggerFactory.getLogger("Test")

    @BeforeAll
    fun `change security manager to make process not exit by System#exit()`() {
        BanSystemExitForTest.change()
    }

    @AfterAll
    fun `reset security manager`() {
        BanSystemExitForTest.reset()
    }

    @Test
    fun `run main() without args`() {
        assertFails {
            main(emptyArray())
        }
    }

    @Test
    fun `run main() for help`() {
        assertFails {
            main(arrayOf("--help"))
        }
    }

    @Test
    fun `run main() with incorrect yokai classpath`() {
        assertFails {
            main(
                arrayOf(
                    "--yokai=dev.toliner.yokaidrone.Nothing",
                    "$token"
                )
            )
        }
    }

    @Test
    fun `run main() with non-yokai class`() {
        assertFails {
            main(
                arrayOf(
                    "--yokai=${List::class.java.canonicalName}",
                    "$token"
                )
            )
        }
    }

    @Test
    fun `logging test`() {
        logger.error("Error")
        logger.warn("Warn")
        logger.info("Info")
        logger.debug("Debug")
        logger.trace("Trace")
    }
}