# Spring Core - Bootcamp - Starter

[![Build Status](https://travis-ci.org/comsysto/spring-core-bootcamp-starter.svg?branch=master)](https://travis-ci.org/comsysto/spring-core-bootcamp-starter)

This project serves as a basic start point for our Spring core training.
It provides a basic setup containing an embedded Tomcat and a basic REST controller to check if it works.
So with this participants should be able to start hacking right away.

## Requirements

To run this example project you need Java 8+ installed properly.
We suggest to use SDKMAN for this.

## How it works

This repository contains a basic Gradle project.
It should be able to just import it into the IDE of choice and start adding new stuff.

## How to check if the setup works

1. Start the application using gradle:
   ```
   ./gradlew run
   ```
2. Check if the provided health endpoint is responding:
   ```
   curl http://localhost:8080/health
   ```
   This should return:
   ```json
   {"status":"up"}
   ```

## What you get

1. Embedded Tomcat
   The project was setup to provide you with an embedded Tomcat so no need to deploy your own.
   The Tomcat is started as part of a normal Java "main" method.
2. Spring's DispatcherServlet
   The project also already provides a DispatcherServlet so REST controller can be reached via HTTP.
3. Basic /health endpoint
   The project also contains a first Spring MVC REST controller that is exposing an health endpoint.
   This is mainly done to help you check if the setup is working at all so you can more easily find errors.
