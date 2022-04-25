package com.antway.lib.gradle

import org.gradle.BuildListener
import org.gradle.BuildResult
import org.gradle.api.Task
import org.gradle.api.execution.TaskExecutionListener
import org.gradle.api.initialization.Settings
import org.gradle.api.invocation.Gradle
import org.gradle.api.tasks.TaskState

class _BuildListener : BuildListener,TaskExecutionListener {
    private var mTaskStartTime: Long = 0
    private val mTimesList = mutableListOf<Pair<Long, String>>()
    override fun settingsEvaluated(p0: Settings) {
    }

    override fun projectsLoaded(p0: Gradle) {
    }

    override fun projectsEvaluated(p0: Gradle) {
    }

    /**
     * 编译结束时输出全部的耗时统计
     */
    override fun buildFinished(p0: BuildResult) {
        mTimesList.filter { it.first > 50 }.forEach {
            println("${it.second} spend ${it.first}ms")
        }
    }

    override fun beforeExecute(p0: Task) {
        mTaskStartTime = System.currentTimeMillis()
    }

    override fun afterExecute(task: Task, p1: TaskState) {
        val duration = System.currentTimeMillis() - mTaskStartTime
        mTimesList.add(Pair(duration, task.path))
        task.project.logger.warn("${task.path} spend ${duration}ms")
    }
}