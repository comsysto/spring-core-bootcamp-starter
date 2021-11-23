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
     * Spring Boot for WebMVC
     */
    implementation("org.springframework.boot:spring-boot-starter-web")

    /*
     * Spring Boot for JPA
     */
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    /*
     * Spring Boot "production ready features"
     */
    implementation("org.springframework.boot:spring-boot-starter-actuator")

    /*
     * Spring Boot test support
     */
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
     * Bring up test container for our integration tests.
     */
    testImplementation("org.testcontainers:junit-jupiter")
    testImplementation("org.testcontainers:postgresql")
}

tasks.test {
    useJUnitPlatform()
}
