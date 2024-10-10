FROM amazoncorretto:17
MAINTAINER EDO
COPY target/avance-tp-0.0.1-SNAPSHOT.jar d.jar
ENTRYPOINT ["java", "-jar", "/d.jar"]