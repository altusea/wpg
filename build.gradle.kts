import org.flywaydb.gradle.task.AbstractFlywayTask
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    java
    id("org.springframework.boot") version "3.5.7"
    id("io.spring.dependency-management") version "1.1.7"
    id("org.flywaydb.flyway") version "11.15.0"
}

group = "com.example"
version = "1.0.0"

java {
    sourceCompatibility = JavaVersion.VERSION_25
    targetCompatibility = JavaVersion.VERSION_25
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
//    maven { url = uri("https://maven.aliyun.com/repository/public/") }
//    maven { url = uri("https://maven.aliyun.com/repository/spring/") }
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
    implementation("org.jooq:jooq-codegen:3.19.25")

    implementation("net.javacrumbs.shedlock:shedlock-provider-redis-spring:6.10.0")
    implementation("org.redisson:redisson-spring-boot-starter:3.52.0")
    implementation("com.github.pagehelper:pagehelper-spring-boot-starter:2.1.1")

    implementation("com.google.guava:guava:33.5.0-jre")
    implementation("com.google.code.gson:gson")
    implementation("org.apache.commons:commons-lang3:3.19.0")
    implementation("org.apache.commons:commons-collections4:4.5.0")
    implementation("org.glavo.kala:kala-common:0.85.0")
    implementation("org.modelmapper:modelmapper:3.2.5")
    implementation("cn.hutool.v7:hutool-all:7.0.0-M2")
    implementation("com.alibaba.fastjson2:fastjson2:2.0.59")
    implementation("commons-io:commons-io:2.20.0")
    implementation("com.github.houbb:sensitive-word:0.29.3")
    implementation("com.fasterxml.uuid:java-uuid-generator:5.1.1")
    implementation("com.j2html:j2html:1.6.0")
    implementation("org.joda:joda-money:2.0.2")
    implementation("dev.failsafe:failsafe:3.3.2")
    implementation("cn.idev.excel:fastexcel:1.3.0")
    implementation("io.netty:netty-all:4.2.7.Final")
    implementation("com.baomidou:mybatis-plus-core:3.5.14")
    implementation("net.logstash.logback:logstash-logback-encoder:9.0")

    runtimeOnly("org.postgresql:postgresql:42.7.8")

    annotationProcessor("org.projectlombok:lombok:1.18.42")
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
