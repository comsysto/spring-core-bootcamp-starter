plugins {
    java
    application
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
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
    val springVersion = "5.3.8"
    implementation("org.springframework:spring-webmvc:$springVersion")
    testImplementation("org.springframework:spring-test:$springVersion")

    /*
     * Embedded Apache Tomcat to run the application on.
     */
    implementation("org.apache.tomcat.embed:tomcat-embed-jasper:9.0.40")
    implementation("com.sun.activation:javax.activation:1.2.0")

    /*
     * Jackson to serialize and deserialize JSON.
     */
    val jacksonVersion = "2.12.0"
    implementation("com.fasterxml.jackson.core:jackson-databind:$jacksonVersion")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:$jacksonVersion")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jdk8:$jacksonVersion")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:$jacksonVersion")

    /*
     * Logback behind SLF4J for logging
     */
    implementation("org.slf4j:slf4j-api:1.7.30")
    runtimeOnly("ch.qos.logback:logback-classic:1.2.3")

    val jpaVersion = "2.1.1.RELEASE"
    val hibernateVersion = "5.4.1.Final"
    val postgresVersion = "42.2.23"
    implementation("org.springframework.data:spring-data-jpa:$jpaVersion")
    implementation("org.hibernate:hibernate-core:$hibernateVersion") {
        exclude(group = "org.glassfish.jaxb", module = "jaxb-runtime")
    }
    implementation("org.postgresql:postgresql:$postgresVersion")

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
    testImplementation("org.mockito:mockito-core:3.6.28")
    testImplementation("org.mockito:mockito-core:3.6.28")

    /*
     * JsonPath used to evaluate values in JSON responses as part of test cases
     */
    testImplementation("com.jayway.jsonpath:json-path-assert:2.4.0")
}

tasks.test {
    useJUnitPlatform()
}
