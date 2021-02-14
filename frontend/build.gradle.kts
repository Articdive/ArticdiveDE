group = "de.articdive.tools.frontend"

plugins {
    id("com.github.node-gradle.node") version "3.0.1"
}

node {
    // Other options are use-case-specific, this is all we need :)
    version.set("14.15.4")
    npmVersion.set("6.14.11")
    yarnVersion.set("1.22.10")
    download.set(true)

}

tasks {
    register<com.github.gradle.node.npm.task.NpmTask>("installDependencies") {
        args.set(
            listOf(
                "install",
                "autoprefixer@latest",
                "css-loader@latest",
                "@tailwindcss/forms@latest",
                "postcss@latest",
                "postcss-loader@latest",
                "style-loader@latest",
                "tailwindcss@latest",
                "webpack@latest",
                "webpack-cli@latest"
            )
        )
    }
    register<com.github.gradle.node.npm.task.NpmTask>("webpack") {
        dependsOn("installDependencies")
        // TODO: Different modes
        args.set(listOf("run", "build", "--", "--mode=none"))
    }
}