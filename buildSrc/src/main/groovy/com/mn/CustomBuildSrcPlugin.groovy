package com.mn

import org.gradle.api.Plugin
import org.gradle.api.Project

class CustomBuildSrcPlugin implements Plugin<Project> {

    @Override
    void apply(Project target) {
        target.task("showCustomPluginBuildSrc") {
            doLast {
                println("InBuildSrc: Module Name is $project.name")
            }
        }
    }
}
