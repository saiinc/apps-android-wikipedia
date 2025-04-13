package org.wikipedia.homeworks.homework19

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import org.wikipedia.homeworks.homework20.NamedSteps

private val stepMap = mutableMapOf<TestContext<*>, Steps>()
private val namedStepsMap = mutableMapOf<TestContext<*>, NamedSteps>()

val TestContext<*>.steps: Steps
    get() {
        if (stepMap.containsKey(this)) {
            return stepMap.getValue(this)
        }
        else {
            val steps = Steps(this)
            stepMap[this] = steps
            return steps
        }
    }

val TestContext<*>.namedSteps: NamedSteps
    get() {
        if (namedStepsMap.containsKey(this)) {
            return namedStepsMap.getValue(this)
        }
        else {
            val namedSteps = NamedSteps(this)
            namedStepsMap[this] = namedSteps
            return namedSteps
        }
    }