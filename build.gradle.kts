import org.flywaydb.gradle.task.AbstractFlywayTask
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    java
    alias(libs.plugins.spring.boot)
    alias(libs.plugins.spring.dependency.management)
    alias(libs.plugins.flyway)
}

group = "com.example"
version = "2026.10.0"

java {
    sourceCompatibility = JavaVersion.VERSION_27
    targetCompatibility = JavaVersion.VERSION_27
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

buildscript {
    dependencies {
        classpath(libs.flyway.database.postgresql)
    }
}

dependencies {
    implementation(libs.spring.boot.starter.data.jpa)
    implementation(libs.spring.boot.starter.webmvc)
    implementation(libs.spring.boot.starter.jooq)
    implementation(libs.spring.boot.starter.validation)
    implementation(libs.spring.boot.starter.data.redis)
    implementation(libs.spring.boot.starter.actuator)
    implementation(libs.spring.boot.starter.kafka)
    implementation(libs.jooq.codegen)

    implementation(libs.shedlock.provider.redis.spring)
    implementation(libs.redisson.spring.boot.starter)
    implementation(libs.pagehelper.spring.boot.starter)

    implementation(libs.guava)
    implementation(libs.gson)
    implementation(libs.commons.lang3)
    implementation(libs.commons.collections4)
    implementation(libs.httpclient5.fluent)
    implementation(libs.kala.common)
    implementation(libs.modelmapper)
    implementation(libs.hutool.all)
    implementation(libs.fastjson2.extension.spring6)
    implementation(libs.fory.json)
    implementation(libs.commons.io)
    implementation(libs.sensitive.word)
    implementation(libs.java.uuid.generator)
    implementation(libs.j2html)
    implementation(libs.joda.money)
    implementation(libs.failsafe)
    implementation(libs.fastexcel)
    implementation(libs.fesod.sheet)
    implementation(libs.netty.all)
    implementation(libs.mybatis.plus.core)
    implementation(libs.logstash.logback.encoder)

    runtimeOnly(libs.postgresql)

    annotationProcessor(libs.lombok)
    annotationProcessor(libs.spring.boot.configuration.processor)

    testImplementation(libs.spring.boot.starter.test)
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
