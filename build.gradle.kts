import org.flywaydb.gradle.task.AbstractFlywayTask

plugins {
    java
    id("org.springframework.boot") version "3.1.3"
    id("io.spring.dependency-management") version "1.1.3"
    id("org.flywaydb.flyway") version "9.19.0"
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
    maven { url = uri("https://maven.aliyun.com/repository/public/") }
    maven { url = uri("https://maven.aliyun.com/repository/spring/") }
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
    // https://mvnrepository.com/artifact/org.jooq/jooq-codegen
    implementation("org.jooq:jooq-codegen:3.18.0")

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

    developmentOnly("org.springframework.boot:spring-boot-devtools")

    // https://mvnrepository.com/artifact/org.postgresql/postgresql
    runtimeOnly("org.postgresql:postgresql:42.6.0")

    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
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
