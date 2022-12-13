FROM eclipse-temurin:11
COPY ./target/multiplication-0.0.1-SNAPSHOT.jar /home/
WORKDIR /usr/src/multiplication
EXPOSE 8080
CMD ["java", "-jar", "/home/multiplication-0.0.1-SNAPSHOT.jar"]
