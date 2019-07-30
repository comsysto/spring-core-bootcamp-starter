plugins {
    java
    application
}

java {
    sourceCompatibility = JavaVersion.VERSION_12
}

application {
    mainClassName = "de.comsystoreply.spring.core.bootcamp.Application"
}

repositories {
    jcenter()
    mavenCentral()
}

dependencies {
    /*
     * Spring Framework and Testing support.
     */
    val springVersion = "5.1.8.RELEASE"
    implementation("org.springframework:spring-webmvc:$springVersion")
    testImplementation("org.springframework:spring-test:$springVersion")

    /*
     * Embedded Apache Tomcat to run the application on.
     */
    implementation("org.apache.tomcat.embed:tomcat-embed-jasper:9.0.21")
    implementation("com.sun.activation:javax.activation:1.2.0")

    /*
     * Jackson to serialize and deserialize JSON.
     */
    val jacksonVersion = "2.9.9"
    implementation("com.fasterxml.jackson.core:jackson-databind:$jacksonVersion")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:$jacksonVersion")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jdk8:$jacksonVersion")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:$jacksonVersion")

    /*
     * Spring Data
     */
    implementation("org.springframework.data:spring-data-jpa:2.1.9.RELEASE")
    implementation("com.h2database:h2:1.4.199")
    implementation("org.hibernate:hibernate-core:5.4.3.Final") {
        exclude("org.glassfish.jaxb", "jaxb-runtime")
    }
    implementation("org.postgresql:postgresql:42.2.6")

    /*
     * Logback behind SLF4J for logging
     */
    implementation("org.slf4j:slf4j-api:1.7.26")
    runtime("ch.qos.logback:logback-classic:1.2.3")

    /*
     * JUnit test framework
     */
    val junitVersion = "5.4.2"
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testRuntime("org.junit.jupiter:junit-jupiter-engine:$junitVersion")

    /*
     * Library with matchers to be used as part of test cases
     */
    testImplementation("org.hamcrest:hamcrest-junit:2.0.0.0")

    /*
     * Add Mockito mocking framework.
     */
    testImplementation("org.mockito:mockito-core:2.28.2")

    /*
     * JsonPath used to evaluate values in JSON responses as part of test cases
     */
    testImplementation("com.jayway.jsonpath:json-path-assert:2.4.0")
}

tasks.test {
    useJUnitPlatform()
}
