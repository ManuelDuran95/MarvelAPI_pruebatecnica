FROM openjdk:17-jdk
VOLUME /tmp
ADD target/MarvelAPI-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
ENV DEMO1=$DEMO1
