FROM amazoncorretto:17-alpine-jdk

COPY target/mexibus-springboot-0.0.1-SNAPSHOT.jar mexibus.jar

ENTRYPOINT ["java", "-jar", "/mexibus.jar"]