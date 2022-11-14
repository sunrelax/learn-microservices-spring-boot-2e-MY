FROM eclipse-temurin:11
COPY ./target/gamification-0.0.1-SNAPSHOT.jar /usr/src/gamification/
EXPOSE 8080
CMD ["java", "-jar", "multiplication-0.0.1-SNAPSHOT.jar"]