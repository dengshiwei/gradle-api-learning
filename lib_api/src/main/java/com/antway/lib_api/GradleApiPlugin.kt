package com.antway.lib_api

import org.gradle.api.Plugin
import org.gradle.api.Project

class GradleApiPlugin :Plugin<Project> {
    override fun apply(p0: Project) {
        println("start plugin")
    }
}