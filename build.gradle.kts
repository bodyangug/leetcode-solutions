plugins {
    kotlin("jvm") version "2.1.20"
    id("io.gitlab.arturbosch.detekt") version "1.23.6"
    application
}

group = "com.pandus.leetcode.solutions"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:1.23.3")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}
