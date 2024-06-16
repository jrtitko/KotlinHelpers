plugins {
//    application                         // For this repo, do we want it to be an application?
    kotlin("jvm") version "1.9.23"
//    id("java-test-fixtures")
}

group = "com.industriousgnomes"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
//    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("io.kotest:kotest-runner-junit5:5.4.2") // Kotest runner
    testImplementation("io.kotest:kotest-assertions-core:5.4.2") // Kotest assertions
    testImplementation("io.kotest:kotest-framework-api:5.4.2") // Kotest framework API

//    testImplementation("io.kotest:kotest-assertions-json:5.4.2") // explore
//    testImplementation("io.kotest:kotest-property-jvm:5.4.2") // explore

}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}
