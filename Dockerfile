FROM maven:3.8.5-openjdk-17 AS build

WORKDIR /app

COPY pom.xml ./
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY --from=build /app/target/mexibus-springboot-0.0.1-SNAPSHOT.jar /app/mexibus-springboot.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app/mexibus-springboot.jar"]