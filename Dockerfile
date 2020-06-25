FROM openjdk:8-jre
VOLUME /tmp
ADD target/donus-0.0.1-SNAPSHOT.war app.war
ENTRYPOINT ["java", "-jar", "/app.war"]