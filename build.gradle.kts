plugins {
    application
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.11.3")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(26)
    }
}

application {
    mainClass = "Main"
}

tasks.test {
    useJUnitPlatform()
}

// Lets the user type anwsers when running with ./gradlew run
tasks.named<JavaExec>("run") {
    standardInput = System.`in`
}
