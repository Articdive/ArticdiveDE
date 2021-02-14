group = "de.articdive.tools.backend"

plugins {
    application
    id("com.github.johnrengelman.shadow") version "6.1.0"
}

val ktorVersion = project.property("ktor_version") as String
val slf4jVersion = project.property("slf4j_version") as String
val log4j2Version = project.property("log4j2_version") as String

application {
    @Suppress("DEPRECATION")
    mainClassName = "io.ktor.server.netty.EngineMain"
}

dependencies {
    implementation(project(":backend:ccc"))
    implementation(project(":backend:rcg"))
}

tasks {
    // Task to copy frontend distribution to our resources
    register<Copy>("frontend") {
        dependsOn(project(":frontend").tasks["webpack"])
        from(file("${project(":frontend").projectDir}/dist"))
        into(file("$buildDir/resources/main/frontend"))
    }
    // Copy resources from our frontend module
    processResources {
        dependsOn("frontend")
    }
    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        // Opt into the Experimental API
        kotlinOptions.freeCompilerArgs += "-Xopt-in=kotlin.RequiresOptIn"
        // JVM 11
        kotlinOptions.jvmTarget = "11"
    }
    shadowJar {
        archiveVersion.set("")
        archiveClassifier.set("fat")
        manifest {
            mapOf(
                "Main-Class" to application.mainClass.get()
            )
        }
    }
}