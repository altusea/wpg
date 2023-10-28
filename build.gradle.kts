import org.flywaydb.gradle.task.AbstractFlywayTask
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    java
    id("org.springframework.boot") version "3.1.5"
    id("io.spring.dependency-management") version "1.1.3"
    id("org.flywaydb.flyway") version "9.22.3"
}

group = "com.example"
version = "1.0.0"

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    // spring
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    // https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-jooq
    implementation("org.springframework.boot:spring-boot-starter-jooq")
    // https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-validation
    implementation("org.springframework.boot:spring-boot-starter-validation")
    // https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-redis
    implementation("org.springframework.boot:spring-boot-starter-data-redis")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.kafka:spring-kafka")
    // https://mvnrepository.com/artifact/org.jooq/jooq-codegen
    implementation("org.jooq:jooq-codegen:3.18.7")

    implementation("com.google.guava:guava:32.1.2-jre")
    // https://mvnrepository.com/artifact/org.apache.commons/commons-lang3
    implementation("org.apache.commons:commons-lang3:3.13.0")
    // https://mvnrepository.com/artifact/org.apache.commons/commons-collections4
    implementation("org.apache.commons:commons-collections4:4.4")
    // https://mvnrepository.com/artifact/org.glavo.kala/kala-common
    implementation("org.glavo.kala:kala-common:0.67.0")
    implementation("org.modelmapper:modelmapper:3.1.1")
    implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.11")
    implementation("cn.hutool:hutool-all:5.8.22")
    implementation("com.alibaba.fastjson2:fastjson2:2.0.40")
    implementation("commons-io:commons-io:2.13.0")
    implementation("one.util:streamex:0.8.2")

    // https://mvnrepository.com/artifact/org.postgresql/postgresql
    runtimeOnly("org.postgresql:postgresql:42.6.0")

    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<BootJar> {
    mainClass = "com.example.wpg.WpgApplication"
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<AbstractFlywayTask> {
    cleanDisabled = false
    url = "jdbc:postgresql://localhost:5432/postgres"
    user = "postgres"
    password = "whatever"
    schemas = arrayOf("wpg")
}
