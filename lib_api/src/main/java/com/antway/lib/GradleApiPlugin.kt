package com.antway.lib

import com.antway.lib.gradle._BuildListener
import org.gradle.api.Plugin
import org.gradle.api.Project

class GradleApiPlugin :Plugin<Project> {
    override fun apply(project: Project) {
        println("start plugin")

        project.gradle.addBuildListener(_BuildListener())

        println("plugin end")
    }
}