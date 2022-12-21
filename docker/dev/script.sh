#!/bin/bash
docker system prune -f
docker rmi $(docker images -a -q) 
./script3dev.sh
docker pull rabbitmq:3-management
docker pull postgres:11.18-bullseye
docker pull consul
docker compose up