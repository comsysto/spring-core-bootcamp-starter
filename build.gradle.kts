plugins {
    java
    id("org.springframework.boot") version "2.6.0"
}

apply(plugin = "io.spring.dependency-management")

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
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
    compileOnly("org.immutables:value:2.8.2")
    annotationProcessor("org.immutables:value:2.8.2")
}

tasks.test {
    useJUnitPlatform()
}
