FROM openjdk:17-jdk-alpine
VOLUME build/libs
COPY build/libs/spring-core-bootcamp-starter.jar /spring-core-bootcamp-starter.jar
ENTRYPOINT ["java","-jar","/spring-core-bootcamp-starter.jar"]
