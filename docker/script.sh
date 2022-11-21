#!/bin/bash
# Questo è un commento
echo Hello World # Anche questo è un commento!
cd /home/giuseppe/Documents/java/workspace/git/learn-microservices-spring-boot-2e-my/multiplication
sudo ./mvnw spring-boot:build-image -DskipTests
cd /home/giuseppe/Documents/java/workspace/git/learn-microservices-spring-boot-2e-my/gamification
sudo ./mvnw spring-boot:build-image -DskipTests
cd /home/giuseppe/Documents/java/workspace/git/learn-microservices-spring-boot-2e-my/gateway
sudo ./mvnw spring-boot:build-image -DskipTests
cd /home/giuseppe/Documents/java/workspace/git/learn-microservices-spring-boot-2e-my/logs
sudo ./mvnw spring-boot:build-image -DskipTests
