group = "de.articdive"

plugins {
    kotlin("jvm") version "1.4.21" apply false
}

val ktorVersion = project.property("ktor_version") as String
val slf4jVersion = project.property("slf4j_version") as String
val log4j2Version = project.property("log4j2_version") as String

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")

    repositories {
        mavenCentral()
        jcenter()
        maven { url = uri("https://kotlin.bintray.com/ktor") }
        maven { url = uri("https://kotlin.bintray.com/kotlin-js-wrappers") }
    }

    dependencies {
        val implementation by configurations
        val testImplementation by configurations
        // Kotlin
        implementation(kotlin("stdlib-jdk8"))
        // Ktor itself
        implementation("io.ktor:ktor-server-netty:$ktorVersion")
        implementation("io.ktor:ktor-server-core:$ktorVersion")

        // Html & CSS
        implementation("io.ktor:ktor-html-builder:$ktorVersion")
        implementation("org.jetbrains:kotlin-css:1.0.0-pre.144-kotlin-1.4.21")
        implementation("io.ktor:ktor-server-host-common:$ktorVersion")

        // Sessions
        implementation("io.ktor:ktor-server-sessions:$ktorVersion")

        // Content Negotiation
        implementation("io.ktor:ktor-gson:$ktorVersion")

        // Testing
        testImplementation("io.ktor:ktor-server-tests:$ktorVersion")

        // Logging
        implementation("org.slf4j:slf4j-api:$slf4jVersion")
        implementation("org.apache.logging.log4j:log4j-core:$log4j2Version")
        implementation("org.apache.logging.log4j:log4j-slf4j-impl:$log4j2Version")
    }
}
