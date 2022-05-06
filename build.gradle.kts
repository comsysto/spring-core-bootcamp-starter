plugins {
    java
    id("org.springframework.boot") version "2.6.0"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
}

apply(plugin = "io.spring.dependency-management")

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencyManagement {
    imports {
        mavenBom("org.testcontainers:testcontainers-bom:1.16.2")
    }
}

dependencies {

    /*
     * We use automatic dependency management via the Spring Boot plugin.
     * This allows us to in most cases omit specifying the version to use. The plugin will automatically resolve a
     * version compatible with our Spring Boot version for us.
     */

    /*
     * Spring Boot
     */
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    runtimeOnly("com.h2database:h2")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    /*
     * DB driver
     */
    runtimeOnly("org.postgresql:postgresql")

    /*
     * Generate immutable classes.
     */
    val immutablesVersion = "2.8.2"
    compileOnly("org.immutables:value:${immutablesVersion}")
    annotationProcessor("org.immutables:value:${immutablesVersion}")

    /*
     * Test containers allow for Docker container to be started as part of the normal test live cycle.
     */
    testImplementation("org.testcontainers:postgresql")
}

tasks.test {
    useJUnitPlatform()
}
