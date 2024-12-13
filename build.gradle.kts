plugins {
    kotlin("jvm") version "2.1.0"
    id("com.github.ben-manes.versions") version "0.51.0"
}

group = "org.athenian"
version = "1.0-SNAPSHOT"

repositories {
    google()
    mavenCentral()
}

dependencies {
}

kotlin {
    jvmToolchain(11)
}
