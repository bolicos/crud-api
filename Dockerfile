FROM eclipse-temurin:21-jdk-alpine AS builder

WORKDIR /apps

COPY ./src ./src
COPY ./gradle ./gradle
COPY gradlew settings.gradle build.gradle ./

RUN chmod +x ./gradlew
RUN ./gradlew clean build --no-daemon

FROM eclipse-temurin:21-jre-alpine AS app

LABEL architecture="amd64"
LABEL authors="bolicos"

WORKDIR /apps/api/dragons

COPY --from=builder /apps/build/libs/app.jar /apps/api/dragons/app.jar

RUN chmod +x ./app.jar

EXPOSE 8000

ENTRYPOINT ["java","-jar", "./app.jar"]