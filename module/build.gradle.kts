import com.moowork.gradle.node.yarn.YarnTask

plugins {
      base
      id("com.github.node-gradle.node") version "3.0.1"
}

node {
      version = "12.20.0"
      yarnVersion = "1.22.10"
      download = true
}

tasks {
      val yarnBuild by registering(YarnTask::class) {
            description = "yarn build"
            group = "Build"

            args = listOf("run", "build")
            dependsOn("yarn_install")
      }

      "build" {
            dependsOn(yarnBuild)
      }
}
