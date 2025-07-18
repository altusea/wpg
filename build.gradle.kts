import org.flywaydb.gradle.task.AbstractFlywayTask
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    java
    id("org.springframework.boot") version "3.5.3"
    id("io.spring.dependency-management") version "1.1.7"
    id("org.flywaydb.flyway") version "11.10.3"
}

group = "com.example"
version = "1.0.0"

java {
    sourceCompatibility = JavaVersion.VERSION_24
    targetCompatibility = JavaVersion.VERSION_24
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    maven { url = uri("https://maven.aliyun.com/repository/public/") }
    maven { url = uri("https://maven.aliyun.com/repository/spring/") }
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
    implementation("org.jooq:jooq-codegen:3.19.24")

    implementation("com.google.guava:guava:33.4.8-jre")
    implementation("com.google.code.gson:gson")
    // https://mvnrepository.com/artifact/org.apache.commons/commons-lang3
    implementation("org.apache.commons:commons-lang3:3.18.0")
    // https://mvnrepository.com/artifact/org.apache.commons/commons-collections4
    implementation("org.apache.commons:commons-collections4:4.5.0")
    // https://mvnrepository.com/artifact/org.glavo.kala/kala-common
    implementation("org.glavo.kala:kala-common:0.82.0")
    implementation("org.modelmapper:modelmapper:3.2.4")
    implementation("org.dromara.hutool:hutool-all:6.0.0-M22")
    implementation("com.alibaba.fastjson2:fastjson2:2.0.57")
    implementation("commons-io:commons-io:2.19.0")
    implementation("net.javacrumbs.shedlock:shedlock-provider-redis-spring:6.9.2")
    implementation("org.redisson:redisson-spring-boot-starter:3.50.0")

    implementation("com.github.pagehelper:pagehelper-spring-boot-starter:2.1.1")

    // https://mvnrepository.com/artifact/org.postgresql/postgresql
    runtimeOnly("org.postgresql:postgresql:42.7.7")

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
