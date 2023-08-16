ext {

}

plugins {
    java
    id("org.springframework.boot") version "3.1.2"
    id("io.spring.dependency-management") version "1.1.2"
}

repositories {
    mavenCentral()
}

tasks {
    jar {
        enabled = false
    }
    build {
        enabled = false
    }
    bootJar {
        enabled = false
    }
}

allprojects {
    group = "io.github.agramar"
    version = "0.0.1-SNAPSHOT"

    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "java")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")

    java.sourceCompatibility = JavaVersion.VERSION_17
    java.targetCompatibility = JavaVersion.VERSION_17

    configurations {
        compileOnly {
            extendsFrom(configurations.annotationProcessor.get())
        }
    }

    dependencies {
        implementation("org.springframework.boot:spring-boot-starter-web")
        implementation("org.springframework.boot:spring-boot-starter-validation")

        annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

        compileOnly ("org.projectlombok:lombok")
        annotationProcessor ("org.projectlombok:lombok")
        testCompileOnly("org.projectlombok:lombok")
        testAnnotationProcessor("org.projectlombok:lombok")

        testImplementation ("org.springframework.boot:spring-boot-starter-test")
    }

    tasks {
        register("prepareKotlinBuildScriptModel")

        test {
            useJUnitPlatform()
        }
    }
}

project(":default") {

}