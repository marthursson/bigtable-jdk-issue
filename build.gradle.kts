import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    application
    kotlin("jvm") version "1.9.22"
    id("io.spring.dependency-management") version "1.1.4"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(17)
}

dependencyManagement {
    imports {
        mavenBom("com.google.cloud:google-cloud-bom:0.214.0")
    }
}

dependencies {
    implementation("com.google.cloud:google-cloud-bigtable")
}

tasks.withType<Test> {
    testLogging.showExceptions = true
    useJUnitPlatform()
}

application {
    mainClass.set("com.example.bigtable.BigtableStartupLatencyKt")
}

tasks.withType<ShadowJar>() {
    mergeServiceFiles()
}