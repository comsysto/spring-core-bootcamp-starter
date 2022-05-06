FROM openjdk:17-jdk-alpine
VOLUME build/libs
ARG JAR_FILE
COPY ${JAR_FILE} /spring-core-bootcamp-starter.jar
ENTRYPOINT ["java","-jar","/spring-core-bootcamp-starter.jar"]