# Stage 1: Build the JAR
FROM gradle:6.7.1-jdk11 as gradle
COPY --chown=gradle . /home/app
WORKDIR /home/app
RUN ./gradlew server:assembleServerAndClient --no-daemon

FROM adoptopenjdk/openjdk13-openj9:jdk-13.0.2_8_openj9-0.18.0-alpine-slim
COPY --from=gradle /home/app/server/build/libs/*-all.jar theApp.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-XX:+IdleTuningGcOnIdle", "-Xtune:virtualized", "-jar", "theApp.jar"]