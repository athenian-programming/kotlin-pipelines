plugins {
    kotlin("jvm") version "1.3.21"
}

group = "org.athenian"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral(),
    mavenLocal()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}