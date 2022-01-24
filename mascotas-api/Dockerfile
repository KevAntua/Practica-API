FROM openjdk:11.0-jdk-slim-stretch
VOLUME /temp
EXPOSE 8090
ARG JAR_FILE=target/mascotas-api-0.0.1.jar
ADD ${JAR_FILE} apimascotas.jar 
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/apimascotas.jar"] 