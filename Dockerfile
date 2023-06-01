FROM openjdk:19-jdk-alpine
VOLUME /tmp
EXPOSE 8080
ADD build/libs/audio-editor-PROD.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]