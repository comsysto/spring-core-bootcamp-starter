# Spring Core - Bootcamp - Solution using Spring Boot

This is an example project to demonstrate how the problem from the bootcamp could be solved using Spring Boot.
As part of the training we ask participants to forgo this route as we feel it is important to know how to do Spring by hand.
But for a more practical approach Spring Boot is what would normally be used by most projects by now.

## Requirements

To run this example project you need Java 17+ installed properly.
We suggest to use SDKMAN for this.

You also need a working Docker installation.
On Windows and MacOs Docker Desktop is most likely the easy way here.
On Linux, follow the official instructions to install it from the command line.

## How it works

This repository contains a basic Gradle project.
It should be able to just import it into the IDE of choice and start adding new stuff.

## How to check if the setup works

1. Start the application using gradle:
   ```
   docker-compose up -d
   ./gradlew bootRun
   ```

2. Check if the provided health endpoint is responding:
   ```
   curl http://localhost:8080/actuator/health
   ```
   This should return:
   ```json
   {"status":"UP"}
   ```

## What you get

1. Embedded Tomcat
   The project was setup to provide you with an embedded Tomcat so no need to deploy your own.
   The Tomcat is started as part of a normal Java "main" method.
2. Basic management endpoints
3. Some basic controller methods to create racing teams

## Things to note

- The tests in this project bring up their own dockerized database.
  Please be not surprised if you see nothing in the DB started using `docker-compose`
