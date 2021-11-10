plugins {
    java
    application
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

application {
    mainClass.set("de.comsystoreply.spring.core.bootcamp.Application")
}

repositories {
    mavenCentral()
}

dependencies {
    /*
     * Spring Framework and Testing support.
     */
    val springVersion = "5.3.12"
    implementation("org.springframework:spring-webmvc:$springVersion")
    testImplementation("org.springframework:spring-test:$springVersion")

    /*
     * Embedded Apache Tomcat to run the application on.
     */
    implementation("org.apache.tomcat.embed:tomcat-embed-jasper:9.0.50")
    implementation("com.sun.activation:javax.activation:1.2.0")

    /*
     * Jackson to serialize and deserialize JSON.
     */
    val jacksonVersion = "2.12.4"
    implementation("com.fasterxml.jackson.core:jackson-databind:$jacksonVersion")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:$jacksonVersion")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jdk8:$jacksonVersion")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:$jacksonVersion")

    /*
     * Logback behind SLF4J for logging
     */
    implementation("org.slf4j:slf4j-api:1.7.30")
    runtimeOnly("ch.qos.logback:logback-classic:1.2.3")

    /*
     * JUnit test framework
     */
    val junitVersion = "5.7.0"
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitVersion")

    /*
     * Library with matchers to be used as part of test cases
     */
    testImplementation("org.hamcrest:hamcrest:2.2")

    /*
     * Add Mockito mocking framework.
     */
    val mockitoVersion = "3.11.2"
    testImplementation("org.mockito:mockito-core:$mockitoVersion")
    testImplementation("org.mockito:mockito-junit-jupiter:$mockitoVersion")

    /*
     * JsonPath used to evaluate values in JSON responses as part of test cases
     */
    testImplementation("com.jayway.jsonpath:json-path-assert:2.6.0")
}

tasks.test {
    useJUnitPlatform()
}
