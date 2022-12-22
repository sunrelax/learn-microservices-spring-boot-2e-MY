#!/bin/bash
docker system prune -f
docker rmi $(docker images -a -q) 
./script3dev.sh
docker pull --platform=linux/arm64 rabbitmq:3-management 
docker pull --platform=linux/arm64 postgres:11.18-bullseye
docker pull --platform=linux/arm64 consul
docker compose up