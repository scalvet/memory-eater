import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.10"
    kotlin("kapt") version "1.4.10"
    application
    id("com.google.cloud.tools.jib") version "2.2.0"
}
repositories {
    mavenCentral()
}
dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))
    testImplementation(kotlin("test"))
    testImplementation(kotlin("test-junit"))
}

application {
    // Define the main class for the application.
    mainClassName = "memeater.MainKt"
}
jib {

    container {
        jvmFlags = listOf(
                "-XshowSettings:vm"
        )
    }
    to {
        //image = "${dockerRegistry}/${project.name}"
        image = "${project.name}"
    }
    from {
        //image = "gcr.io/distroless/java:8"
        //image = "gcr.io/distroless/java:8-debug"
        //image = "gcr.io/distroless/java:11"
        //image = "gcr.io/distroless/java:11-debug"
        image = "registry.access.redhat.com/redhat-openjdk-18/openjdk18-openshift"

    }
}
val jar by tasks.getting(Jar::class) {
    manifest {
        attributes["Main-Class"] = "memeater.MainKt"
    }
}
tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions.suppressWarnings = true
    kotlinOptions.jvmTarget = "1.8"
}