plugins {
    java
}

group = "ru.stileyn"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.mockito:mockito-core:3.12.4")
}

sourceSets {
    main {
        java.srcDirs("src/main/java")
    }
    test {
        java.srcDirs("src/test/java")
    }
}

tasks.test {
    useJUnitPlatform()
}

val jarOne by tasks.registering(Jar::class) {
    archiveFileName.set("TaskOne.jar")
    from(sourceSets.main.get().output)
    manifest {
        attributes["Main-Class"] = "ru.stileyn.TaskOne.One"
    }
}

val jarTwo by tasks.registering(Jar::class) {
    archiveFileName.set("TaskTwo.jar")
    from(sourceSets.main.get().output)
    manifest {
        attributes["Main-Class"] = "ru.stileyn.TaskTwo.Two"
    }
}

val jarThree by tasks.registering(Jar::class) {
    archiveFileName.set("TaskThree.jar")
    from(sourceSets.main.get().output)
    manifest {
        attributes["Main-Class"] = "ru.stileyn.TaskThree.Three"
    }
}

val jarFour by tasks.registering(Jar::class) {
    archiveFileName.set("TaskFour.jar")
    from(sourceSets.main.get().output)
    manifest {
        attributes["Main-Class"] = "ru.stileyn.TaskFour.Four"
    }
}

tasks.named<Jar>("jar") {
    enabled = false
}


tasks.named<Jar>("jar") {
    dependsOn("jarOne", "jarTwo", "jarThree", "jarFour")
}
