FROM openjdk:17-jdk
VOLUME /tmp
COPY target/movie.jar movie.jar
ENTRYPOINT ["java", "-jar", "movie.jar"]