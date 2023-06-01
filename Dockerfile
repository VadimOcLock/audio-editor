FROM gradle:8.0.2-jdk19 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build

FROM openjdk:19-jdk-alpine
EXPOSE 8080
COPY --from=build /home/gradle/src/build/libs/audio-editor-PROD.jar /app/
RUN bash -c 'touch /app/audio-editor-PROD.jar'
ENTRYPOINT ["java","-jar","/app/audio-editor-PROD.jar"]