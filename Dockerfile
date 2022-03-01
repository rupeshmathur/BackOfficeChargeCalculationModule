FROM openjdk:8-jdk-alpine
ARG JAR_FILE=build/BODerivativesDummy-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} BODerivativesDummy-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/BODerivativesDummy-0.0.1-SNAPSHOT.jar"] 