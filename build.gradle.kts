import org.flywaydb.gradle.task.AbstractFlywayTask
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    java
    id("org.springframework.boot") version "4.0.0-M1"
    id("io.spring.dependency-management") version "1.1.7"
    id("org.flywaydb.flyway") version "11.10.5"
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
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-jooq")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-data-redis")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.kafka:spring-kafka")
    implementation("org.jooq:jooq-codegen:3.19.24")

    implementation("net.javacrumbs.shedlock:shedlock-provider-redis-spring:6.9.2")
    implementation("org.redisson:redisson-spring-boot-starter:3.50.0")
    implementation("com.github.pagehelper:pagehelper-spring-boot-starter:2.1.1")

    implementation("com.google.guava:guava:33.4.8-jre")
    implementation("com.google.code.gson:gson")
    implementation("org.apache.commons:commons-lang3:3.18.0")
    implementation("org.apache.commons:commons-collections4:4.5.0")
    implementation("org.glavo.kala:kala-common:0.82.0")
    implementation("org.modelmapper:modelmapper:3.2.4")
    implementation("cn.hutool.v7:hutool-all:7.0.0-M1")
    implementation("com.alibaba.fastjson2:fastjson2:2.0.58")
    implementation("commons-io:commons-io:2.20.0")
    implementation("com.github.houbb:sensitive-word:0.27.1")
    implementation("com.fasterxml.uuid:java-uuid-generator:5.1.0")
    implementation("com.j2html:j2html:1.6.0")
    implementation("dev.failsafe:failsafe:3.3.2")
    implementation("cn.idev.excel:fastexcel:1.2.0")
    implementation("com.baomidou:mybatis-plus-core:3.5.12")

    runtimeOnly("org.postgresql:postgresql:42.7.7")

    annotationProcessor("org.projectlombok:lombok")
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
