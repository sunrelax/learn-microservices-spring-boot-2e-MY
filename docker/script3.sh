#!/bin/bash
# Questo è un commento
echo Compilazione e build frontend # Anche questo è un commento!
cd /home/giuseppe/Documents/java/workspace/git/learn-microservices-spring-boot-2e-my/challenges-frontend/
export NODE_OPTIONS=--openssl-legacy-provider
npm run build
docker buildx build --platform linux/amd64,linux/arm64 -t sunrelax/challenges-frontend:1.0.0 --push .
echo Compilazione e build multiplication # Anche questo è un commento!
cd /home/giuseppe/Documents/java/workspace/git/learn-microservices-spring-boot-2e-my/multiplication
mvn clean install -DskipTests
docker buildx build --platform linux/amd64,linux/arm64 -t sunrelax/multiplication:0.0.1-SNAPSHOT --push .
echo Compilazione e build gamification # Anche questo è un commento!
cd /home/giuseppe/Documents/java/workspace/git/learn-microservices-spring-boot-2e-my/gamification
mvn clean install -DskipTests
docker buildx build --platform linux/amd64,linux/arm64 -t sunrelax/gamification:0.0.1-SNAPSHOT --push .
echo Compilazione e build gateway # Anche questo è un commento!
cd /home/giuseppe/Documents/java/workspace/git/learn-microservices-spring-boot-2e-my/gateway
mvn clean install -DskipTests
docker buildx build --platform linux/amd64,linux/arm64 -t sunrelax/gateway:0.0.1-SNAPSHOT --push .
echo Compilazione e build logs # Anche questo è un commento!
cd /home/giuseppe/Documents/java/workspace/git/learn-microservices-spring-boot-2e-my/logs
mvn clean install -DskipTests
docker buildx build --platform linux/amd64,linux/arm64 -t sunrelax/logs:0.0.1-SNAPSHOT --push .
echo Compilazione e build consul-importer # Anche questo è un commento!
cd /home/giuseppe/Documents/java/workspace/git/learn-microservices-spring-boot-2e-my/docker/consul/
docker buildx build --platform linux/amd64,linux/arm64 -t sunrelax/consul-importer:0.0.1-SNAPSHOT --push .

