/*
 * Copyright (c) 2019. toliner.
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.50"
    application
}

group = "dev.toliner"
version = "0.0.1"

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("ch.qos.logback:logback-classic:1.2.3")
    implementation("com.github.ajalt:clikt:2.2.0")

    testImplementation(kotlin("test-junit5"))
    testRuntime("org.junit.jupiter:junit-jupiter-engine:5.0.0")

    api("net.dv8tion:JDA:4.0.0_54")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClassName = "dev.toliner.yokaidrone.BootstrapKt"
}

tasks.withType<Test> {
    useJUnitPlatform()
}