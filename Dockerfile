FROM openjdk:8-jdk-alpine
ARG JAR_FILE= F:/SPRING_BOOT_PROJECTS/BackOfficeChargeCalculationModule/target/*.jar
COPY ${JAR_FILE} BODerivativesDummy-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","F:/SPRING_BOOT_PROJECTS/BODerivativesDummy-0.0.1-SNAPSHOT.jar"]